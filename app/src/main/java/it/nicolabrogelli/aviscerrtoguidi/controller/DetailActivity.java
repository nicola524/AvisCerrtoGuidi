package it.nicolabrogelli.aviscerrtoguidi.controller;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.plus.PlusShare;
import it.nicolabrogelli.aviscerrtoguidi.R;


public class DetailActivity extends AppCompatActivity {

    private static final int SHARED_MY_POST = 1;
    final String mimeType = "text/html";
    final String encoding = "utf-8";
    private String titolo, url, estratto, post, url_immagine, testo;
    private TextView Titolo;
    private TextView Post;
    private  ImageView Immagine;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle bundle = getIntent().getExtras();

        titolo = bundle.getString("titolo");
        post = bundle.getString("contenuto");
        estratto = bundle.getString("riassunto");
        url = bundle.getString("URL");
        //url_immagine = bundle.getString("URL_IMMAGINE");

        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }



        webView = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        final String customHtml = post;
        webView.loadDataWithBaseURL("", customHtml + "<style type=\'text/css\'>" + "img{max-width:300px!important; height:auto!important;}" + "</style>", mimeType, encoding, "");
        testo = post; //android.text.Html.fromHtml(customHtml).toString();

        Button shareButton = (Button) findViewById(R.id.share_button);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Avvia la finestra di dialogo di condivisione di Google+ con l'attribuzione alla tua app.
                Intent shareIntent = new PlusShare.Builder(getApplicationContext())
                        .setType("text/plain")
                        .setText(titolo + " \n" + testo + "\n" + url )
                        .setContentUrl(Uri.parse("https://plus.google.com/101399258028167949791/about?gl=it&hl=it"))
                        .getIntent();

                startActivityForResult(shareIntent, 0);


            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == SHARED_MY_POST) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                // The user picked a contact.
                // The Intent's data Uri identifies which contact was selected.

                // Do something with the contact here (bigger example below)
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_condivisi:

                // Avvia la finestra di dialogo di condivisione di Google+ con l'attribuzione alla tua app.
                Intent shareIntent = new PlusShare.Builder(getApplicationContext())
                        .setType("text/plain")
                        .setText( testo + "\n" + url )
                        .setContentUrl(Uri.parse("https://plus.google.com/101399258028167949791/about?gl=it&hl=it"))
                        .getIntent();

                startActivityForResult(shareIntent, 0);

                return true;

            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
