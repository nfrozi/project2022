package ui;

import data.PekerjaRepository;
import entity.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Cli {

    private final PekerjaRepository databaseKasir;
    private final Scanner scanner;

    public Cli() {
        databaseKasir = new PekerjaRepository();
        scanner = new Scanner(System.in);
    }

    public void seedDatabase() {
        databaseKasir.create("Kurniawan",155,"123");
        databaseKasir.create("Aan",156,"123");
    }

    public PekerjaRepository getDatabaseKasir() {
        return databaseKasir;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void readDatabase() {
        databaseKasir.read();
    }

    public void updatePassTest() {
        System.out.println("\nUpdate pass test...\n");

        // cek method update
        ArrayList<Integer> testedNip = new ArrayList<>();
        testedNip.add(databaseKasir.updatePass(111, "111")); //pengujian salah
        testedNip.add(databaseKasir.updatePass(155, "111")); //pengujian benar

        for (Integer nip : testedNip) {
            if (nip == PekerjaRepository.DATA_NOT_FOUND) {
                System.out.println("Data tidak ditemukan");
            } else {
                System.out.println("Data nip " + nip + " berhasil update password");
            }
        }
    }

    public void deleteKasirTest() {
        System.out.println("\nDelete karyawan test...\n");

        //cek method delete
        ArrayList<Integer> testedNip = new ArrayList<>();
        testedNip.add(databaseKasir.delete(111)); //pengujian salah
        testedNip.add(databaseKasir.delete(155)); //pengujian benar

        for (Integer nip : testedNip) {
            if (nip == PekerjaRepository.DATA_NOT_FOUND) {
                System.out.println("Data tidak ditemukan");
            }
            else {
                System.out.println("Data dengan NIP " + nip + " berhasil dihapus");
            }
        }
    }

    public void loginTest() {
        System.out.println("\nLogin test...\n");

        ArrayList<Kasir> testedKasir = new ArrayList<>();

        // Cek auth
        Auth auth = new Auth(databaseKasir);
        testedKasir.add(
            auth.login(new Kasir("Aan", 155, "111"))
        ); // gagal
        testedKasir.add(
            auth.login(new Kasir("Aan", 156, "123"))
        ); // sukses

        for (Kasir kasir : testedKasir) {
            if (kasir instanceof UnknownKasir) {
                System.err.println("Login kasir dg NIP " + kasir.getNip() + " tidak ditemukan.");
            }
            else {
                System.out.println("Login kasir dg NIP " + kasir.getNip() + " SUKSES.");
            }
        }
    }

    public static void main(String[] args) {
        Cli app = new Cli();

//        Kasir agus = new Kasir("Agus", 111, "111");
        Pekerja cahyo = new Kasir("Cahyo", 113, "113");
        Pekerja budi = new Manajer("Budi", 112, "112");

//        cahyo.cetak();
//        budi.cetak();

        PekerjaRepository database = new PekerjaRepository();
        database.create(cahyo);
        database.create(budi);

        Pekerja x = database.getSingle(1);
        x.cetak();





//        ArrayList<Pekerja> pekerjaList = new ArrayList<>();
//        pekerjaList.add(new Kasir("Agus", 112, "112"));
//        pekerjaList.add(new Manajer("Budi", 113, "113"));
//
//        pekerjaList.get(0).cetak();
//        Manajer exManajer = (Manajer) pekerjaList.get(1);
//        exManajer.cetak();

//        String lanjut;
//        int pilihan;
//
//        do {
//            System.out.println("Entri pekerjaList...");
//            System.out.println("Pilih: ");
//            System.out.println("1. Manajer");
//            System.out.println("2. Kasir");
//
//            System.out.println("Pilihan Anda: ");
//            pilihan = app.getScanner().nextInt();
//            String nama;
//            int nip;
//            String pass;
//
//            System.out.print("Masukkan nama = ");
//            nama = app.getScanner().next();
//            System.out.print("Masukkan NIP = ");
//            nip = app.getScanner().nextInt();
//            System.out.print("Masukkan pass = ");
//            pass = app.getScanner().next();
//
//            if (pilihan == 1) {
//                pekerjaList.add(new Manajer(nama, nip, pass));
//            }
//            else {
//                pekerjaList.add(new Kasir(nama, nip, pass));
//            }
//
//            System.out.print("Lanjut [Y/T]: ");
//            lanjut = app.getScanner().next();
//
//        } while (lanjut.equals("Y"));
//
//        for (Pekerja pekerja : pekerjaList) {
////            if (pekerja instanceof Kasir) {
////                System.out.println("Mencetak kasir");
////            } else if (pekerja instanceof Manajer) {
////                System.out.println("Mencetak Manajer");
////            }
//            pekerja.cetak();
//        }

//        kasir.cetak();
//        mgr.cetak();

//        System.out.println("Project PBO 2022\n");
//
//        Main app = new Main();
//        app.seedDatabase();
//        app.readDatabase();
//
//        app.updatePassTest();
//        app.readDatabase();
//
//        app.deleteKasirTest();
//        app.readDatabase();
//
//        app.loginTest();
    }
}