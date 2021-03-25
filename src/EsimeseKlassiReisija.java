import java.util.ArrayList;

public class EsimeseKlassiReisija implements Reisija{

    private int kliendiNr;
    private ArrayList<String> lennuinfo = new ArrayList<>();

    public EsimeseKlassiReisija(int kliendiNr) {
        this.kliendiNr = kliendiNr;
    }

    @Override
    public double arvutaHind(double alghind) {
        return alghind*1.5;
    }

    @Override
    public void salvestaLennuinfo(String lennuinfo) {
        this.lennuinfo.add(lennuinfo);
    }

    @Override
    public String toString() {
        return "EsimeseKlassiReisija:" +
                " Kliendi number: " + kliendiNr +
                "; Lennuinfo: " + lennuinfo;
    }
}
