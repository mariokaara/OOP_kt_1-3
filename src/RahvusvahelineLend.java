public class RahvusvahelineLend extends Lend {

    private String sihtriik;

    public RahvusvahelineLend(String sihtkoht, String sihtriik, double alghind) {
        super(sihtkoht, alghind);
        this.sihtriik = sihtriik;
    }

    @Override
    String vormindaLennuinfo() {
        return super.vormindaLennuinfo() + ", " + sihtriik;
    }
}
