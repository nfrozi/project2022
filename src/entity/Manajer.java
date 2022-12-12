package entity;

import java.util.HashMap;

public class Manajer extends Pekerja {

    public Manajer(String nama, int nip, String pass) {
        // panggil konstruktor parent
        super(nama, nip, pass + "$", "Manajer");
        tambahanGaji.put("bonus", 500000);
        tambahanGaji.put("tunjangan kesehatan", 750000);
    }

//    @Override
//    public int getGaji() {
//        return super.getGaji() + bonus;
//    }
}
