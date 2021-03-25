import java.util.ArrayList;
import java.util.List;

public class Lend implements Comparable<Lend> {

    private String sihtkoht;
    private double alghind;

    private double summa = 0;

    private List<Reisija> reisijad = new ArrayList<>();

    public Lend(String sihtkoht, double alghind) {
        this.sihtkoht = sihtkoht;
        this.alghind = alghind;
    }

    String vormindaLennuinfo() {
        return "Lend sihtkohaga - " + sihtkoht;
    }

    void transpordiReisija(Reisija reisija) {
        reisijad.add(reisija);
        summa += reisija.arvutaHind(alghind);
        reisija.salvestaLennuinfo(vormindaLennuinfo());
    }


    @Override
    public int compareTo(Lend o) {
        return Double.compare(this.summa, o.summa);
    }

    String väljastaReisijad() {
        return reisijad.toString();
    }

    @Override
    public String toString() {
        return "Sihtkoht: " + sihtkoht +
                "; Alghind: " + alghind +
                "; Summa: " + summa +
                "; Reisijad: " + reisijad;
    }
}

