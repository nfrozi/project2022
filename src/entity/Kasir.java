package entity;

public class Kasir {
    private final String nama;
    private final int nip;
    private String pass;

    public Kasir(String nama, int nip, String pass)
    {
        this.nama = nama;
        this.nip = nip;
        this.pass = pass;
    }

    public void cetak()
    {
        System.out.println("Nama : " + this.nama);
        System.out.println("NIP  : " + this.nip);
        System.out.println("Pass : " + this.pass);
        System.out.println("---------------------");
    }

    public int getNip() {
        return nip;
    }

    public void changePass(String newPass) {
        this.pass = newPass;
    }

    public boolean equals(Kasir kasir) {
        return (nip == kasir.getNip());
    }

    public boolean equals(Kasir kasir, boolean withPass) {
        return (nip == kasir.getNip() && pass == kasir.pass);
    }
}
