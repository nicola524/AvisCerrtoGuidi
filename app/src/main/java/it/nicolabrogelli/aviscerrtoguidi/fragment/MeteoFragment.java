package it.nicolabrogelli.aviscerrtoguidi.fragment;


import android.app.ProgressDialog;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Base64;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import it.nicolabrogelli.aviscerrtoguidi.R;
import it.nicolabrogelli.aviscerrtoguidi.model.Notifica;
import it.nicolabrogelli.aviscerrtoguidi.util.CustomDialogBox;


public class MeteoFragment extends Fragment {

    ImageView imgAP, imgAM, imgBP, imgBM, img0P, img0M, imgABP, imgABM;
    TextView txtAggiornamento;
    private FragmentManager fm;
    private CustomDialogBox cdb;
    private String Aggironamento;
    private ProgressDialog pDialog;
    private ProgressBar progressBar;
    private static final String TEXT_FRAGMENT = "TEXT_FRAGMENT";
    private boolean mSearchCheck;


    public static MeteoFragment newInstance(String text){
        MeteoFragment mFragment = new MeteoFragment();
        Bundle mBundle = new Bundle();
        mBundle.putString(TEXT_FRAGMENT, text);
        mFragment.setArguments(mBundle);
        return mFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View rootView = inflater.inflate(R.layout.fragment_meteo, container, false);


        imgAP = (ImageView) rootView.findViewById(R.id.imageViewAP);
        imgAM = (ImageView) rootView.findViewById(R.id.imageViewAM);
        imgBP = (ImageView) rootView.findViewById(R.id.imageViewBP);
        imgBM = (ImageView) rootView.findViewById(R.id.imageViewBM);
        img0P = (ImageView) rootView.findViewById(R.id.imageView0P);
        img0M = (ImageView) rootView.findViewById(R.id.imageView0M);
        imgABP = (ImageView) rootView.findViewById(R.id.imageViewABP);
        imgABM = (ImageView) rootView.findViewById(R.id.imageViewABM);
        progressBar = (ProgressBar) rootView.findViewById(R.id.progressBar_meteo);
        txtAggiornamento = (TextView) rootView.findViewById(R.id.textViewAggiornamento);

        imgAP.setOnClickListener(new myOnClickListener());
        imgAM.setOnClickListener(new myOnClickListener());
        imgBP.setOnClickListener(new myOnClickListener());
        imgBM.setOnClickListener(new myOnClickListener());
        img0P.setOnClickListener(new myOnClickListener());
        img0M.setOnClickListener(new myOnClickListener());
        imgABP.setOnClickListener(new myOnClickListener());
        imgABM.setOnClickListener(new myOnClickListener());


        /*
        View parent = inflater.inflate(R.layout.fragment_meteo, container, false);
        View layouttoast = inflater.inflate(R.layout.tosat_layout_root, null);
        ((TextView) layouttoast.findViewById(R.id.text_toast)).setText("Ciao");
        ((ImageView) layouttoast.findViewById(R.id.image_toast)).setImageDrawable(R.drawable.ab);
        //layouttoast.findViewById(R.id.imagetoast)).setBackgroundResource(R.drawable.icon);
        Toast mytoast = new Toast(getActivity());
        mytoast.setView(layouttoast);
        mytoast.setDuration(Toast.LENGTH_LONG);
        mytoast.show();
        */


        new LongOperation().execute();

        rootView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return rootView;
    }

    public class myOnClickListener implements View.OnClickListener {


        /**
         * Called when a view has been clicked.
         *
         * @param v The view that was clicked.
         */
        @Override
        public void onClick(View v) {

            switch (v.getId()) {

                case R.id.imageViewABM:
                    break;

                case R.id.imageViewABP:
                    break;

                case R.id.imageView0M:
                    break;

                case R.id.imageView0P:
                    break;

                case R.id.imageViewAM:
                    break;

                case R.id.imageViewAP:
                    break;

                case R.id.imageViewBM:
                    break;

                case R.id.imageViewBP:
                    break;


            }

        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
    }



    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // TODO Auto-generated method stub
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_meteo, menu);

        menu.findItem(R.id.menu_refresch_meteo).setVisible(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub


        switch (item.getItemId()) {

            case R.id.menu_refresch_meteo:
                new LongOperation().execute();
                //Toast.makeText(getActivity(), "Refresh", Toast.LENGTH_SHORT).show();
                break;

        }
        return true;
    }



    private class LongOperation extends AsyncTask<Void, Integer, List<Notifica>> {

        @Override
        protected List<Notifica> doInBackground(Void... params) {

            List<Notifica> lista = new ArrayList<Notifica>();
            Document doc = null;

            try {
                doc = Jsoup.parse(new URL("https://web.e.toscana.it/crs/meteo/"), 2000);   //http://www.bits4beats.it/

                int idx = 1;
                Elements resultImg = doc.select("a img");
                for (Element link : resultImg) {
                    Notifica n = new Notifica();
                    n.set_Link(downloadBitmap("https://web.e.toscana.it/crs/meteo/" + link.attr("src")));
                    lista.add(n);
                    n = null;
                    idx+=10;
                    publishProgress(idx);
                }


                Elements resultImput = doc.select("input");
                for (Element link : resultImput) {

                    Notifica n = new Notifica();
                    n.set_Stato(link.attr("value"));
                    lista.add(n);
                    n = null;
                    idx+=10;
                    publishProgress(idx);

                }


                Elements resultDiv = doc.select("div");
                for (Element link : resultDiv) {
                    if(link.attr("id").toString().equalsIgnoreCase("aggiornamento")) {
                        Aggironamento = link.text().toString();
                        Log.d("ID", link.attr("id").toString());

                    }
                    idx+=10;
                    publishProgress(idx);

                }
            } catch (IOException e) {
                e.printStackTrace();
            }


            return lista;
        }

        protected void onPostExecute(List<Notifica> lista) {

            if((lista != null) && (lista.size() > 0)) {
                for (int idx = 0; idx <= lista.size(); idx++) {

                    if (idx == 0) {
                        imgAP.setImageBitmap(lista.get(idx).get_Link());
                    }
                    else if (idx == 2) {
                        imgAM.setImageBitmap(lista.get(idx).get_Link());
                    }
                    if (idx == 4) {
                        imgBP.setImageBitmap(lista.get(idx).get_Link());
                    }
                    else if (idx == 6) {
                        imgBM.setImageBitmap(lista.get(idx).get_Link());
                    }

                    if (idx == 8) {
                        img0P.setImageBitmap(lista.get(idx).get_Link());
                    }
                    else if (idx == 10) {
                        img0M.setImageBitmap(lista.get(idx).get_Link());
                    }
                    if (idx == 12) {
                        imgABP.setImageBitmap(lista.get(idx).get_Link());
                    }
                    else if (idx == 14) {
                        imgABM.setImageBitmap(lista.get(idx).get_Link());
                    }
                }

                if(Aggironamento.equalsIgnoreCase("")) {

                }
                else
                {
                    txtAggiornamento.setText(Aggironamento);
                }
            }
            else {
                txtAggiornamento.setText("Data aggiornamento non disponibile");

            }
            progressBar.setVisibility(View.GONE);
            cdb.dismiss();
            cdb = null;
            fm = null;

        }


        @Override
        protected void onPreExecute() {
            // Showing progress dialog
            progressBar.setVisibility(View.VISIBLE);
            progressBar.setProgress(0);

            fm = getActivity().getSupportFragmentManager();
            cdb = new CustomDialogBox();

            cdb.show(fm,".....");


        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            progressBar.setProgress(values[0]);
        }
    }


    /**
     *
     * @param fileUrl
     * @return
     */
    private Bitmap downloadBitmap(String fileUrl)
    {
        InputStream is = null;
        try
        {
            HttpURLConnection conn = (HttpURLConnection) new URL(fileUrl).openConnection();
            conn.connect();
            is = conn.getInputStream();

            return BitmapFactory.decodeStream(is);
        }
        catch (MalformedURLException e)
        {
            is = null;
        }
        catch (IOException e)
        {
            is = null;

        }
        finally
        {
            if (is != null)
                try
                {
                    is.close();
                }
                catch (IOException e)
                {

                }
        }

        return null;
    }


}
