package it.nicolabrogelli.aviscerrtoguidi.model;

import android.app.backup.BackupManager;
import android.graphics.Bitmap;

/**
 * Created by Nicola on 23/06/2014.
 */
public class Notifica {

    private String _Stato;
    private Bitmap _Link;



    public void set_Stato(String stato) {
        this._Stato = stato;
    }
    public void set_Link(Bitmap link) {
        this._Link = link;
    }

    public String get_Stato() {
        return this._Stato;
    }
    public Bitmap get_Link() {
        return this._Link;
    }



}
