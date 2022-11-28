package entity;

public class Kasir extends Pekerja {

    public Kasir(String nama, int nip, String pass) {
        // panggil konstruktor parent
        super(nama, nip, pass, "Kasir");
    }
}
