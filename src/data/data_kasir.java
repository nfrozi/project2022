package data;
import entity.entity_kasir;

import java.util.ArrayList;

public class data_kasir {
    private ArrayList<entity_kasir> data_kasir;

    public data_kasir()
    {
        data_kasir = new ArrayList<entity_kasir>();
    }

    public void create(String nama, int nip, String pass)
    {
        this.data_kasir.add(new entity_kasir(nama,nip,pass));
    }

    public void read()
    {
        System.out.println("==== DATA KASIR ====");
        for (int i=0;i<this.data_kasir.size();i++)
        {
            this.data_kasir.get(i).cetak();
        }
    }

    private int search(int nip)
    {
        for (int i=0;i<this.data_kasir.size();i++)
        {
            if (nip == this.data_kasir.get(i).getNip())
            {
                return i;
            }
        }
        return -1;
    }

    public void update_pass(int nip, String pass)
    {
        int index = this.search(nip);
        if (index == -1)
        {
            System.out.println("data tidak ditemukan");
        }
        else
        {
            this.data_kasir.get(index).setPass(pass);
            System.out.println("data nip "+nip+" berhasil update password");
        }
    }

    public void delete(int nip)
    {
        int index = this.search(nip);
        if (index == -1)
        {
            System.out.println("data tidak ditemukan");
        }
        else
        {
            this.data_kasir.remove(index);
            System.out.println("data dengan NIP "+index +" berhasil dihapus");
        }
    }
    private int cek_login(int nip, String pass)
    {
        for (int i=0;i<this.data_kasir.size();i++)
        {
            if (nip==this.data_kasir.get(i).getNip())
            {
                if (pass.equals(this.data_kasir.get(i).getPass()))
                {
                    return this.data_kasir.get(i).getNip();
                }
            }
        }
        return -1;
    }

    public int login(int nip, String pass)
    {
        int nipKasir = this.cek_login(nip,pass);
        if (nipKasir == -1)
        {
            System.out.println("NIP "+nip +" login gagal");
        }
        else
        {
            System.out.println("NIP "+nip +" login berhasil");
        }
        return nipKasir;
    }
}
