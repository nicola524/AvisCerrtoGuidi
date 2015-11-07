package it.nicolabrogelli.aviscerrtoguidi.asynctask;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.app.FragmentManager;
import android.text.Html;
import android.util.Log;
import android.widget.ArrayAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

import it.nicolabrogelli.aviscerrtoguidi.model.Post;
import it.nicolabrogelli.aviscerrtoguidi.util.CustomDialogBox;
import it.nicolabrogelli.aviscerrtoguidi.util.DoneHandlerInputStream;

/**
 * Created by Nicola on 27/09/2015.
 */
public class DownloadPostAsyncTask extends AsyncTask<Void, Post, ArrayList<Post>> {

    private ArrayList<Post> postArrayList;

    // URL to get contacts JSON
    private  String site_url = "http://www.aviscerretoguidi.it/api/get_recent_posts/";

    // JSON Node names
    private static final String TAG_POSTS = "posts";
    private static final String TAG_ID = "id";
    private static final String TAG_POST_URL = "url";
    private static final String TAG_TYPE = "type";
    private static final String TYPE_SULG = "slug";
    private static final String TAG_STATUS = "status";
    private static final String TAG_TITLE = "title";
    private static final String TAG_CONTENT = "content";
    private static final String TAG_ATTACHMENTS = "attachments";
    private static final String TAG_URL_IMAGE = "url";
    private static final String TAG_POST_EXCERPT = "excerpt";

    private int count_post;

    public DownloadPostAsyncTask() {
        postArrayList = new ArrayList<Post>();
    }

    /**
     * Override this method to perform a computation on a background thread. The
     * specified parameters are the parameters passed to {@link #execute}
     * by the caller of this task.
     * <p/>
     * This method can call {@link #publishProgress} to publish updates
     * on the UI thread.
     *
     * @param params The parameters of the task.
     * @return A result, defined by the subclass of this task.
     * @see #onPreExecute()
     * @see #onPostExecute
     * @see #publishProgress
     */
    @Override
    protected ArrayList<Post> doInBackground(Void... params) {

        try {

            JSONObject obj = getJSONObject(site_url);

            if (obj.getString("status").equalsIgnoreCase("ok")) {
                count_post = obj.getInt("count");

                JSONArray jsonArray = obj.getJSONArray("posts");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    Post t = new Post();
                    t.set_ID(jsonObject.getInt(TAG_ID));
                    //t.set_TITLE(jsonObject.getString(TAG_TITLE));
                    t.set_TITLE(Html.fromHtml(jsonObject.getString(TAG_TITLE).toString()).toString());
                    t.set_CONTENT(jsonObject.getString(TAG_CONTENT));
                    t.set_URL(jsonObject.getString(TAG_POST_URL));
                    t.set_EXCERPT(jsonObject.getString(TAG_POST_EXCERPT));


                    try {
                        JSONArray image = jsonObject.getJSONArray(TAG_ATTACHMENTS);
                        JSONObject objImg = image.getJSONObject(0);
                        //t.set_IMAGE_POST(downloadBitmap(objImg.getString("url")));
                        t.set_ProfileImageUrl(objImg.getString("url"));

                    } catch (Exception e) {

                    }
                    //publishProgress(t);
                    postArrayList.add(t);
                    t = null;
                }
            }
        } catch (JSONException ignored) {
            Log.e("ERRORE", ignored.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return postArrayList;
    }

    @Override
    protected void onProgressUpdate(Post... values) {
        /*
        for (Post post : values) {
            postArrayList.add(post);
        }
        */
    }



    private  JSONObject getJSONObject(String url) throws IOException, MalformedURLException, JSONException {
        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();

        InputStream in = conn.getInputStream();

        try {
            StringBuilder sb = new StringBuilder();
            BufferedReader r = new BufferedReader(new InputStreamReader(new DoneHandlerInputStream(in)));
            for (String line = r.readLine(); line != null; line = r.readLine()) {
                sb.append(line);
            }
            return new JSONObject(sb.toString());
        } finally {
            in.close();
        }
    }

}
