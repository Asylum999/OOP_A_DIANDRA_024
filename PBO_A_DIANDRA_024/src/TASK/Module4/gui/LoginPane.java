package Task.Module4.gui;

import Task.Module4.main.loginSystem;
import Task.Module4.users.userLogin;
import Task.Module4.users.admin;
import Task.Module4.users.mahasiswa;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class LoginPane {

    public static void show(Stage stage) {
        // Inisialisasi user sebelum login
        loginSystem.initUsers();

        ComboBox<String> roleBox = new ComboBox<>();
        roleBox.getItems().addAll("Mahasiswa", "Admin");
        roleBox.setValue("Mahasiswa");

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Label messageLabel = new Label();

        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> {
            String role = roleBox.getValue();
            String user = usernameField.getText();
            String pass = passwordField.getText();

            // Gunakan versi login yang pakai String
            userLogin u = loginSystem.login(role.toLowerCase(), user, pass);
            if (u != null) {
                if (u instanceof admin) {
                    AdminDashboard.show(stage, (admin) u);
                } else if (u instanceof mahasiswa) {
                    MahasiswaDashboard.show(stage, (mahasiswa) u);
                }
            } else {
                messageLabel.setText("Login gagal, periksa username atau password.");
            }
        });

        VBox layout = new VBox(10, new Label("Login Sistem Lost & Found"),
                roleBox, usernameField, passwordField, loginButton, messageLabel);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);

        stage.setScene(new Scene(layout, 350, 250));
        stage.setTitle("Lost & Found Kampus");
        stage.show();
    }
}
