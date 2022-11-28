package data;
import entity.Kasir;

import java.util.ArrayList;

public class DataKasir {

    public final static int DATA_NOT_FOUND = -1;
    private final ArrayList<Kasir> data;

    public DataKasir()
    {
        data = new ArrayList<Kasir>();
    }

    public ArrayList<Kasir> getAll() {
        return data;
    }

    public void create(String nama, int nip, String pass)
    {
        this.data.add(new Kasir(nama, nip, pass));
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
