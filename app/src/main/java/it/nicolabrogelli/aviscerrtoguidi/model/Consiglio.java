package it.nicolabrogelli.aviscerrtoguidi.model;

/**
 * Created by Nicola on 13/09/2015.
 */
public class Consiglio {

    private String cognomeNome;
    private String ruolo;
    private String struttura;
    private String dataInizio;
    private String dataFine;


    public Consiglio(String cognomeNome, String ruolo, String struttura, String dataInizio, String dataFine) {
        this.cognomeNome = cognomeNome;
        this.ruolo = ruolo;
        this.struttura = struttura;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
    }

    public String getCognomeNome() {
        return this.cognomeNome;
    }

    public String getRuolo() {
        return this.ruolo;
    }

    public String getStruttura() {
        return  this.struttura;
    }

    public String getDataInizio() {
        return this.dataInizio;
    }

    public String getDataFine() {
        return this.getDataFine();
    }

}
