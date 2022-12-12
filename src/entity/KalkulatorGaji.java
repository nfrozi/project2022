package entity;

import java.util.Map;

public class KalkulatorGaji {

    public int hitung(Pekerja pekerja) {
        return pekerja.getGaji() +
            hitungTambahanGaji(pekerja);
    }

    private int hitungTambahanGaji(Pekerja pekerja) {
        int totalTambahanGaji = 0;

        for(Map.Entry<String, Integer> entry : pekerja.getTambahanGaji().entrySet()) {
            totalTambahanGaji = totalTambahanGaji + entry.getValue();
        }

        return totalTambahanGaji;
    }
}
