public class TuristiklassiReisija implements Reisija{

    private String reisijaNimi;
    private String viimaseLennuInfo;

    public TuristiklassiReisija(String reisijaNimi) {
        this.reisijaNimi = reisijaNimi;
    }

    @Override
    public double arvutaHind(double alghind) {
        return alghind;
    }

    @Override
    public void salvestaLennuinfo(String lennuinfo) {
        this.viimaseLennuInfo = lennuinfo;
    }

    @Override
    public String toString() {
        return "Turistiklassi reisija info" +
                ". Reisija nimi: " + reisijaNimi +
                ". Viimane lend: " + viimaseLennuInfo;
    }
}
