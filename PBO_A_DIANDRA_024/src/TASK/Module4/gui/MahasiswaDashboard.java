package Task.Module4.gui;

import javafx.collections.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import Task.Module4.Model.items;
import Task.Module4.main.loginSystem;
import Task.Module4.users.mahasiswa;

public class MahasiswaDashboard {

    public static void show(Stage stage, mahasiswa user) {
        Label welcome = new Label("Selamat datang, " + user.getUserName());
        Label laporanLabel = new Label("Laporkan Barang Hilang/Temuan");

        // Input Fields
        TextField namaField = new TextField();
        namaField.setPromptText("Nama barang");

        TextField deskripsiField = new TextField();
        deskripsiField.setPromptText("Deskripsi");

        TextField lokasiField = new TextField();
        lokasiField.setPromptText("Lokasi");

        Button laporBtn = new Button("Laporkan");

        // Table setup
        TableView<items> table = new TableView<>();
        ObservableList<items> data = FXCollections.observableArrayList(loginSystem.reporteditems);
        table.setItems(data);

        table.getColumns().addAll(
                createColumn("Nama", "itemname"),
                createColumn("Lokasi", "lokasi"),
                createColumn("Status", "status")
        );

        Label tableLabel = new Label("Daftar Laporan Anda");

        // Lapor button action
        laporBtn.setOnAction(e -> {
            String nama = namaField.getText();
            String lokasi = lokasiField.getText();
            String deskripsi = deskripsiField.getText();

            if (!nama.isEmpty() && !lokasi.isEmpty()) {
                items item = new items(nama, deskripsi, lokasi, "Reported");
                loginSystem.reporteditems.add(item);
                table.refresh();

                namaField.clear();
                deskripsiField.clear();
                lokasiField.clear();
            }
        });

        // Layout for input form
        HBox formBox = new HBox(10,
                new Label("Nama"), namaField,
                new Label("Deskripsi"), deskripsiField,
                new Label("Lokasi"), lokasiField,
                laporBtn
        );
        formBox.setAlignment(Pos.CENTER_LEFT);

        Button logoutBtn = new Button("Logout");
        logoutBtn.setOnAction(e -> LoginPane.show(stage));

        VBox root = new VBox(10,
                welcome,
                laporanLabel,
                formBox,
                tableLabel,
                table,
                logoutBtn
        );
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.TOP_LEFT);

        stage.setScene(new Scene(root, 700, 500));
        stage.setTitle("Lost & Found Kampus - Mahasiswa");
    }

    private static TableColumn<items, String> createColumn(String title, String property) {
        TableColumn<items, String> col = new TableColumn<>(title);
        col.setCellValueFactory(new PropertyValueFactory<>(property));
        col.setMinWidth(150);
        return col;
    }
}
