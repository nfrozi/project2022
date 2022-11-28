import data.DataKasir;
import entity.Auth;
import entity.Kasir;
import entity.UnknownKasir;
import java.util.ArrayList;

public class Main {

    public final DataKasir databaseKasir;

    public Main() {
        databaseKasir = new DataKasir();
    }

    public void seedDatabase() {
        databaseKasir.create("Kurniawan",155,"123");
        databaseKasir.create("Aan",156,"123");
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
            if (nip == DataKasir.DATA_NOT_FOUND) {
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
            if (nip == DataKasir.DATA_NOT_FOUND) {
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

    public static void main(String[] args){
        System.out.println("Project PBO 2022\n");

        Main app = new Main();
        app.seedDatabase();
        app.readDatabase();

        app.updatePassTest();
        app.readDatabase();

        app.deleteKasirTest();
        app.readDatabase();

        app.loginTest();
    }
}