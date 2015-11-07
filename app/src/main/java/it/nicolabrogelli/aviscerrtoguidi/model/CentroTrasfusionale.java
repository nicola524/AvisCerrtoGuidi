package it.nicolabrogelli.aviscerrtoguidi.model;


import com.google.android.gms.maps.model.LatLng;

public class CentroTrasfusionale {

    private String struttura;
    private String localita;
    private String indirizzo;
    private String telefono;
    private String fax;
    private LatLng latLng;


    public CentroTrasfusionale(String struttura, String localita, String indirizzo, String telefono,
                               String fax, LatLng latLng ) {

        this.struttura = struttura;
        this.localita = localita;
        this.indirizzo = indirizzo;
        this.telefono = telefono;
        this.fax = fax;
        this.latLng = latLng;
    }


    public String getStruttura() {
        return this.struttura;
    }

    public String getLocalita() {
        return this.localita;
    }

    public String getIndirizzo() {
        return this.indirizzo;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public String getFax() {
        return this.fax;
    }

    public LatLng getLatLng() {
        return this.latLng;
    }

}
