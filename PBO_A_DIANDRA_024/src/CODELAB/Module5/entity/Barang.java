package entity;
public class Barang {
    private String nama;
    private int stok;

    public Barang(String nama, int stok) {//cons
        this.nama = nama;
        this.stok = stok;
    }
    public String getNama() {//geTter
        return nama;
    }
    public int getStok() {//getTer
        return stok;
    }
    public void setStok(int stok) {//setTer
        this.stok = stok;
    }
}
