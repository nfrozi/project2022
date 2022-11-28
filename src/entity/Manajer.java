package entity;

public class Manajer extends Pekerja {

    private int bonus = 500000;

    public Manajer(String nama, int nip, String pass) {
        // panggil konstruktor parent
        super(nama, nip, pass + "$", "Manajer");
    }

    @Override
    public void cetak() {
        System.out.println("Tambahan di kelas Manajer...");
        super.cetak();
    }

    @Override
    public int getGaji() {
        return super.getGaji() + bonus;
    }
}
