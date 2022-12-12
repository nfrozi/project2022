package data;
import entity.Kasir;
import entity.Pekerja;

import java.util.ArrayList;

public class PekerjaRepository {

    public final static int DATA_NOT_FOUND = -1;
    private final ArrayList<Pekerja> data;

    public PekerjaRepository()
    {
        data = new ArrayList<>();
    }

    public ArrayList<Pekerja> getAll() {
        return data;
    }

    public Pekerja getSingle(int indeks) {
        return data.get(indeks);
    }

    public void create(String nama, int nip, String pass)
    {
        this.data.add(new Kasir(nama, nip, pass));
    }

    public void create(Pekerja pekerja)
    {
        this.data.add(pekerja);
    }

    public void read()
    {
        System.out.println("==== DATA KASIR ====");
        for (int i = 0; i < this.data.size(); i++)
        {
            this.data.get(i).cetak();
        }
    }

    private int search(int nip)
    {
        for (int i = 0; i < this.data.size(); i++)
        {
            if (nip == this.data.get(i).getNip())
            {
                return i;
            }
        }
        return DATA_NOT_FOUND;
    }

    public int updatePass(int nip, String newPass)
    {
        int index = this.search(nip);

        if (index == DATA_NOT_FOUND) {
            return DATA_NOT_FOUND;
        }
        else {
            this.data.get(index).changePass(newPass);
            return nip;
        }
    }

    public int delete(int nip)
    {
        int index = this.search(nip);

        if (index == DATA_NOT_FOUND) {
            return DATA_NOT_FOUND;
        }
        else {
            this.data.remove(index);
            return nip;
        }
    }
}
