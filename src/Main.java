import data.data_kasir;

public class Main {
    public static void main(String[] args){
        System.out.println("Project PBO 2022");

        //input data kasir
        data_kasir database_kasir = new data_kasir();
        database_kasir.create("kurniawan",155,"123");
        database_kasir.create("aan",156,"123");
        database_kasir.read(); // viev database kasir

        // cek method update
        database_kasir.update_pass(111,"111");
        database_kasir.update_pass(155,"111");
        database_kasir.read();

        //cek method delete
        database_kasir.delete(111);
        database_kasir.delete(155);
        database_kasir.read();
    }
}