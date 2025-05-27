/// itemes
package Task.Module4.Model;
public class items {
    private String itemname;
    private String deskripsi;
    private String lokasi;
    private String status;

    public items(String itemname, String deskripsi, String lokasi, String status) {
        this.itemname = itemname;
        this.deskripsi = deskripsi;
        this.lokasi = lokasi;
        this.status = status;
    }
    // Getter dan Setter
    public String getItemname() {
        return itemname;
    }
    public String getDeskripsi() {
        return deskripsi;
    }
    public String getLokasi() {
        return lokasi;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}