package kegiatan3prak8;
public class MainKegiatan3 {
    public static void main(String[] args) {
        Lingkaran lingkaran = new Lingkaran("Merah", 7);

        lingkaran.cetakWarna();
        System.out.println("Luas lingkaran: " + lingkaran.hitungLuas());
    }
}
