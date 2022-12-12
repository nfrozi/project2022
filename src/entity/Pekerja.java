package entity;

import java.util.HashMap;

public class Pekerja {
    private final String nama;
    private final int nip;
    private String pass;
    private String tipe;
    private int gaji = 1500000;
    protected final HashMap<String, Integer> tambahanGaji;

    public Pekerja(String nama, int nip, String pass, String tipe)
    {
        this.nama = nama;
        this.nip = nip;
        this.pass = pass;
        this.tipe = tipe;
        tambahanGaji = new HashMap<>();
    }

    public void cetak()
    {
        System.out.println("Nama : " + this.nama);
        System.out.println("NIP  : " + this.nip);
        System.out.println("Pass : " + this.pass);
        System.out.println("Tipe : " + this.tipe);
        System.out.println("Gaji : " +
            new KalkulatorGaji()
                .hitung(this)
        );
        System.out.println("---------------------");
    }

    public int getNip() {
        return nip;
    }

    public int getGaji() {
        return gaji;
    }

    public HashMap<String, Integer> getTambahanGaji() {
        return tambahanGaji;
    }

    public void changePass(String newPass) {
        this.pass = newPass;
    }

    public boolean equals(Pekerja kasir) {
        return (nip == kasir.getNip());
    }

    public boolean equals(Pekerja kasir, boolean withPass) {
        return (nip == kasir.getNip() && pass == kasir.pass);
    }
}
