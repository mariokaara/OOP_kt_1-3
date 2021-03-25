import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Peaklass {

    public static List<Lend> loeLennud(String failinimi) throws Exception {
        List<Lend> list1 = new ArrayList<>();
        try (java.util.Scanner sc = new java.util.Scanner(Path.of(failinimi), "UTF-8")) {
            while (sc.hasNextLine()) {
                String rida = sc.nextLine();
                String[] tükid = rida.split(" ");
                if (tükid.length == 3) {
                    list1.add(new RahvusvahelineLend(tükid[0], tükid[1], Double.parseDouble(tükid[2])));
                } else {
                    list1.add(new Lend(tükid[0], Double.parseDouble(tükid[1])));
                }
            }
        }
        return list1;
    }


    public static void main(String[] args) throws Exception {

        // Rakendatakse vastavat staatilist meetodit, et lugeda failist lendude andmed
        List<Lend> lennud = loeLennud("fail");

        // Luuakse mitu turistiklassi ja esimese klassi reisijat ja koondatakse nad ühte listi
        TuristiklassiReisija turist1 = new TuristiklassiReisija("Mart Helmes");
        TuristiklassiReisija turist2 = new TuristiklassiReisija("Martin Helmes");
        EsimeseKlassiReisija ärikas1 = new EsimeseKlassiReisija(100234);
        EsimeseKlassiReisija ärikas2 = new EsimeseKlassiReisija(100664);
        List<Reisija> reisijad = new ArrayList<>();
        reisijad.addAll(Arrays.asList(turist1, turist2, ärikas1, ärikas2));


        // Reisijad jagatakse juhuslikult lendude vahel nii, et iga reisija lendab 3 lennuga. Selleks tuleb
        // kasutada Collections.shuffle meetodit. Antud meetod võtab argumendiks listi ning järjestab selle
        // suvalises järjekorras. Lendude list järjestada iga reisija jaoks uuesti ümber ning transportida
        // reisija esimese kolme reisiga

        for (Reisija i : reisijad) {
            Collections.shuffle(lennud);
            for (int j = 0; j < 3; j++) {
                lennud.get(j).transpordiReisija(i);
            }
        }

        // Sorteeritakse lennud vastavalt meetodis compareTo kirjeldatud järjekorrale
        Collections.sort(lennud);

        // Lendude info väljastatakse ekraanile
        for (Lend i : lennud) {
            System.out.println(i.toString());
        }

        // Lendude reisijate info väljastatakse ekraanile
        for (Lend i : lennud) {
            System.out.println(i.väljastaReisijad());
        }

    }


}

