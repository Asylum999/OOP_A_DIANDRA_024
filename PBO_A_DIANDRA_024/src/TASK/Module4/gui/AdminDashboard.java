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
import Task.Module4.users.*;

public class AdminDashboard {

    public static void show(Stage stage, admin user) {
        Label welcome = new Label("Halo, Administrator " + user.getUserName());

        // Tabel Barang
        TableView<items> itemTable = new TableView<>();
        ObservableList<items> itemData = FXCollections.observableArrayList(loginSystem.reporteditems);
        itemTable.setItems(itemData);

        itemTable.getColumns().addAll(
                createColumn("Nama", "itemname"),
                createColumn("Lokasi", "lokasi"),
                createColumn("Status", "status")
        );

        Label itemLabel = new Label("Daftar Barang");
        Button claimBtn = new Button("Tandai Claimed");
        claimBtn.setOnAction(e -> {
            items selected = itemTable.getSelectionModel().getSelectedItem();
            if (selected != null && selected.getStatus().equals("Reported")) {
                selected.setStatus("Claimed");
                itemTable.refresh();
            }
        });

        VBox itemBox = new VBox(5, itemLabel, itemTable, claimBtn);
        itemBox.setPadding(new Insets(10));
        itemBox.setAlignment(Pos.TOP_LEFT);

        // Tabel Mahasiswa
        TableView<mahasiswa> mahasiswaTable = new TableView<>();
        ObservableList<mahasiswa> mahasiswaList = FXCollections.observableArrayList();
        for (userLogin u : loginSystem.userList) {
            if (u instanceof mahasiswa) {
                mahasiswaList.add((mahasiswa) u);
            }
        }

        mahasiswaTable.setItems(mahasiswaList);
        mahasiswaTable.getColumns().addAll(
                createColumn("Nama", "userName"),
                createColumn("NIM", "userPassw")
        );

        Label mahasiswaLabel = new Label("Data Mahasiswa");
        VBox mahasiswaBox = new VBox(5, mahasiswaLabel, mahasiswaTable);
        mahasiswaBox.setPadding(new Insets(10));
        mahasiswaBox.setAlignment(Pos.TOP_LEFT);

        HBox dashboard = new HBox(20, itemBox, mahasiswaBox);
        dashboard.setPadding(new Insets(10));

        Button logoutBtn = new Button("Logout");
        logoutBtn.setOnAction(e -> LoginPane.show(stage));

        VBox root = new VBox(15, welcome, dashboard, logoutBtn);
        root.setPadding(new Insets(20));

        stage.setScene(new Scene(root, 850, 500));
        stage.setTitle("Dashboard Admin - Lost & Found");
    }

    private static <T> TableColumn<T, String> createColumn(String title, String property) {
        TableColumn<T, String> col = new TableColumn<>(title);
        col.setCellValueFactory(new PropertyValueFactory<>(property));
        col.setMinWidth(150);
        return col;
    }
}
