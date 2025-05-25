package Codelab.Module6;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.geometry.*;
public class kakaw extends Application{

    @Override
    public void start(Stage stage) {
        TextField tf = new TextField();
        //tf.setPromptText("Masukkan Angka: ");

        TextField tf1 = new TextField();
        tf1.setPromptText("Masukkan Angka kedua: ");

        Button tambah = new Button("Tambah");
        Label i = new Label();
        i.setText("Welcome");

        Label hasil = new Label();

        tambah.setOnAction(e -> {
            try {
                int a = Integer.parseInt(tf.getText());
                int b = Integer.parseInt(tf1.getText());
                int hasill = a + b;
                hasil.setText("hasil: " + hasill);

            } catch (NumberFormatException e1) {
                hasil.setText("Masukkan Angka yang benar!");
            }
        });

        HBox root = new HBox(10,i , tf1, tf, tambah, hasil);
        root.setPadding(new Insets(20));

        Scene scene = new Scene(root, 700, 500);

        stage.setTitle("Kalkulator asu");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
