package it.nicolabrogelli.aviscerrtoguidi.fragment.uistatiche;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import it.nicolabrogelli.aviscerrtoguidi.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link IdoneitaAllaDonazioneFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link IdoneitaAllaDonazioneFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IdoneitaAllaDonazioneFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment IdoneitaAllaDonazioneFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static IdoneitaAllaDonazioneFragment newInstance(String param1, String param2) {
        IdoneitaAllaDonazioneFragment fragment = new IdoneitaAllaDonazioneFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public IdoneitaAllaDonazioneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_idoneita_alla_donazione, container, false);

        String text = "<strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Peso corporeo < 50kg (60kg per multicomponenti con GR)\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Fino al raggiungimento del peso stabilito\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dal rilievo della condizione\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Età < 18 anni\n" +
                "<br><br><strong>Periodo sospensione</strong><br><br>Fino ai 18 anni\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dal rilievo della condizione\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Età > 65 anni\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Definitiva\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dal rilievo della condizione\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Età > 60 anni dalla prima donazione\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Definitiva\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dal rilievo della condizione\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Frequenza cardiaca < 50/min o > 110min\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Fino al ritorno ai valori stabiliti\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dal rilievo della condizione\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Pressione arteriosa sistolica < 110 mmHg o > 180 mmHg\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Fino al ritorno ai valori stabiliti\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dal rilievo della condizione\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Pressione arteriosa diastolica < 60 mmHg o > 100 mmHg\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Fino al ritorno ai valori stabiliti\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dal rilievo della condizione\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Donazione di sangue intero: Hb < 13.5gr/dl (uomini) o < 12.5gr/dl (donne)\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Fino al ritorno ai valori stabiliti\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dal rilievo della condizione\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong><br><br>\n" +
                "<br><br>Donazione di plasma: Hb < 12.5gr/dl (uomini) o < 11.5gr/dl (donne)\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Fino al ritorno ai valori stabiliti\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dal rilievo della condizione\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Gravidanza, parto\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>1 anno\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dal parto\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Interruzione di gravidanza\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>6 mesi\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dall'interruzione di gravidanza\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Stato di ebbrezza alcolica\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Fino al ripristino della sobrietà\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dal rilievo della condizione\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Condizioni psichiche alterate\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Fino al ripristino di condizioni psichiche normali\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dal rilievo della condizione";

        String text1 = "<strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Trasfusioni di sangue, emocomponenti, emoderivati (comprese Ig)\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>4 mesi\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dalla trasfusione\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Stretto contatto domestico con persone affette da epatite B\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>4 mesi\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dalla cessazione della condizione\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Rapporti sessuali con nuovi partner\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>3 mesi\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dal contatto\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Rapporti sessuali occasionali a rischio di trasmissione di malattie infettive\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>4 mesi\n" +
                "<br><br><string>Decorrenza sospensione</strong>\n" +
                "<br><br>Dal contatto\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br>Comportamenti sessuali che espongono\n" +
                "<br>ad alto rischio di contrarre gravi malattie infettive trasmissibili con il sangue\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Sospensione definitiva\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dal rilievo della condizione\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Abitudine a cambiare frequentemente partner\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Fino al perdurare della condizione\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dal rilievo\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Partner sessuale di soggetto con epatite virale o HIV 1-2 positivo o affetto da sifilide\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Sospensione definitiva\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dal rilievo della condizione\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Tossicodipendenza (anche droghe non iniettive)\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Sospensione definitiva\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dal rilievo della condizione\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Cure dentarie\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>2 mesi\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dalla fine delle cure\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Interventi chirurgici ambulatoriali\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>2 mesi\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dall'intervento\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Interventi chirurgici non ambulatoriali, esami endoscopici con strumenti flessibili, procedure\n" +
                "<br>diagnostiche invasive (ad es. angiografia, coronarografia),\n" +
                "<br>uso di catetere, agopuntura con materiale non monouso, foratura delle orecchie,\n" +
                "<br>piercing, tatutaggi, spruzzo delle mucose con sangue o lesioni da ago\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>4 mesi\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dall'esecuzione\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Febbre > 38 gradi\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Almeno 2 settimane\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dall'insorgenza\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Contatto con affetti da malattie infettive\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Periodo = all'incubazione\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dal contatto\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Encefalopatia spongiforme trasmissibile (TSE), soggetti trattati con estratti derivati dalla\n" +
                "<br>ghiandola pituitaria umana o con\n" +
                "<br>storia familiare della malattia che abbiano ricevuto un trapianto di \n" +
                "<br>dura madre o cornea, candidati donatori che abbiano soggiornato\n" +
                "<br>per più di sei mesi nel Regno Unito tra il 1980 e il 1996 o che abbiano ricevuto\n" +
                "<br>trasfusioni allogeniche nel Regno Unito dopo il 1980\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Sospensione definitiva\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dal rilievo della condizione\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Soggiorno in zona malarica senza sviluppare malattia\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>6 mesi\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dal ritorno\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Soggiorno in aree malariche nei primi 5 anni di vita o per 5 anni consecutivi\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>3 anni\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dall'ultima visita area di endemia\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Provenienza da zone endemiche per malattie tropicali\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>6 mesi se non malesseri\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dall'arrivo\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Vaccinazioni: BCG, Poliomelite (orale), morbillo, parotite, rosolia, febbre gialla, vaiolo\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>4 settimane\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dalla vaccinazione\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Vaccinazioni: colera, tifo e paratifo, tetano, poliomelite (iniezione), influenza\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>48 ore se asintomatici\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dalla vaccinazione\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Somministrazione di tossoidi: difterite, tetano\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>48 ore se asintomatici\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dalla somministrazione\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Vaccinazioni: epatite A e B, rabbia senza esposizione\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>48 ore se asintomatici\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dalla vaccinazione\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Vaccionazioni: epatite A e B, rabbia con esposizione\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>1 anno\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dalla vaccinazione\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Somministrazione di sieri di origine animale\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>3 mesi\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dalla somministrazione\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Xenotrapianti\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Sospensione definitiva\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dal trapianto";

        String text2 = "<strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Malattie infettive in genere\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>2 settimane\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dalla scomparsa\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Raffreddore\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>1 settimana\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dalla scomparsa\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Malaria\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>6 mesi (poi solo plasma)\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dalla guarigione\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Brucellosi, tubercolosi, leptospirosi, febbre Q, osteomelite\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>2 anni\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dalla guarigione completa\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Babesiosi, lesmaniosi, lebbra, tripanosmiasi, m. di Chagas\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Sospensione definitiva\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dalla diagnosi\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Infezione da virus del Nilo Occidentale o soggiono in zona endemica (vd. linee guida)\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>28 giorni\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dalla guarigione\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Infezioni protozoarie ed elmintiche (escluse quelle che danno sosp. definitiva)\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>2 anni\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dalla guarigione completa\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Mononucleosi, toxoplasmosi, infezione da CMV, m. di Lyme, infezione da parovirus B19\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>6 mesi\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dalla guarigione (assenza di IgM)\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Borreliosi, puntura di zecca asintomatica\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>3 mesi\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dalla guarigione o dalla puntura\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Diarrea del viaggiatore o altri disturbi gastro-enterici durante il viaggio\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>1 mese\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dall'episodio\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>EIA HIV 1-2 e/o HIV NAT positiva o border-line\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Sospensione definitiva\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dal rilievo della condizione\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Positività test HTLV Io II\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Sospensione definitiva\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dal rilievo della condizione\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>HbsAg e/o HBV NAT positivo o border-line\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Sospensione definitiva\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dal rilievo della condizione\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Epatite ed eziologia indeterminata\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Sospensione definitiva\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dal rilievo della condizione\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Coinvolgimento in più di un caso di epatite post-trasfusionale\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Sospensione definitiva\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dal rilievo della condizione\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Unico donatore implicato in un caso di epatite post-trasfusionale\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Sospensione definitiva\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dal rilievo della condizione\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Positività TPHA e/o VDRL\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Sospensione definitiva\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dal rilievo della condizione\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Infezioni croniche\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Sospensione definitiva\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dal rilievo della condizione";

            String text3 = "<strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Ulcera gastrica o duodenale\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Fino a guarigione documentata\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dalla diagnosi\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Malattie croniche gastro-intestinali\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Sospensione definitiva\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dalla diagnosi\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Reumatismo articolare acuto\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Almeno 2 anni (se non sequele cardiologiche e/o renali)\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dalla guarigione\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Malattie cardiache (esclusi: anomalie congenite completamente curate,\n" +
                "<br>blocchi di branca incompleti, valvulopatie emodinamicamente non significative, extrasistoli sopraventicolari sporadiche)\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Sospensione definitiva\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dalla diagnosi\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Vasculopatie cerebrali, trombosi arteriosi o venose ricorrenti\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Sospensione definitiva\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dalla diagnosi\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Ipertensione grave non controllata farmacologicamente\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Sospensione definitiva\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dalla diagnosi\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Glomerulonefrite acuta\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>5 anni\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dalla scomparsa dei sintomi\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Malattie croniche renali\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Sospensione definitiva\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dalla diagnosi\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Malattie croniche uro-genitali\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Sospensione definitiva\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dalla diagnosi\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Malattie croniche epatiche\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Sospensione definitiva\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dalla diagnosi\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Malattie croniche respiratorie (comprese asma bronchiale,\n" +
                "<br>se di discreta entità o in trattamento per lunghi periodi, e bronchite)\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Sospensione definitiva\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dalla diagnosi\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Malattie croniche metaboliche\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Sospensione definitiva\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dalla diagnosi\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Diabete scompensato e/o in trattamento insulinico\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Sospensione definitiva\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dalla diagnosi\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Malattie croniche immunologiche\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Sospensione definitiva\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dalla diagnosi\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Neoplasie maligne (eccetto Ca in situ guarito)\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Sospensione definitiva\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dalla diagnosi\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Neoplasie benigne\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>A discrezione del Medico\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dalla diagnosi\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Emopatie (eccezioni: anemie carenziali, piastrinopenia con PLT > 110000/mm cubici, linfocitopenia con linfociti > 800/mm cubici\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Sospensione definitiva\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dalla diagnosi\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Malattie importanti di coagulazione ed emostasi\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Sospensione definitiva\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dalla diagnosi\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Emocromatosi ereditaria, porfirie\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Sospensione definitiva\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dalla diagnosi\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br>Epilessia, malattie convulsive in età adulta, \"crisi di svenimenti\"\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Sospensione definitiva\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dalla diagnosi\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Malattie demielinizzanti, malattie degenerative del SN,\n" +
                "<br>gravi malattie organiche del SNC, neurochirurgia del SNC\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Sospensione definitiva\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dalla diagnosi\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Psicosi\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Sospensione definitiva\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dalla diagnosi\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Allergie con manifestazioni cliniche persistenti\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Sospensione definitiva\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dalla diagnosi\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Iposensibilizzazione per allergia\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>72 ore\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dalla somministrazione\n" +
                "<br>Condizione rilevata all'accettazione\n" +
                "<br>Malattie autoimmuni (escluso l'ipotiroidismo in trattamento,\n" +
                "<br>ben compensato e la malattia celiaca in eta priva di glutine)\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Sospensione definitiva\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dalla diagnosi\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Ipertranaminasemia\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Vedi linee guida\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dal rilievo\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Terapia con FANS se piastrinoferesi\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>7 giorni\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Da ultima assunzione\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Terapia con antibiotici e antimicotici\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>10 giorni\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Da ultima assunzione\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Terapia con beta-bloccanti\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Durante il trattamento\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Da inizio terapia\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Terapia con ACE-inibitori\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Per il periodo di trattamento per le donazioni in aferesi\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Da inizio terapia\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Terapia isotretinoina, finasteride, altri teratogeni\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>2 mesi\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Da ultima assunzione\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Terapia con acitretina\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>1 anno\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Da ultima assunzione\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Terapia con etretinato\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Sospensione definitiva\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Da inizio terapia\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Terapia con anoressizzanti\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>1 mese\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Da ultima assunzione\n" +
                "<br><br><strong>Condizione rilevata all'accettazione</strong>\n" +
                "<br><br>Sostanze via IM, EV con rischio infettivo(doping)\n" +
                "<br><br><strong>Periodo sospensione</strong>\n" +
                "<br><br>Sospensione definitiva\n" +
                "<br><br><strong>Decorrenza sospensione</strong>\n" +
                "<br><br>Dalla diagnosi";

        TextView textView = (TextView) view.findViewById(R.id.Text_fattori);
        TextView textView_situazioni = (TextView) view.findViewById(R.id.Text_situazioni);
        TextView textView_infettive = (TextView) view.findViewById(R.id.Text_infettive);
        TextView textView_nonInfettive = (TextView) view.findViewById(R.id.Text_nonInfettive);

        textView.setText(Html.fromHtml(text));
        textView_situazioni.setText(Html.fromHtml(text1));
        textView_infettive.setText(Html.fromHtml(text2));
        textView_nonInfettive.setText(Html.fromHtml(text3));

        // Inflate the layout for this fragment
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
