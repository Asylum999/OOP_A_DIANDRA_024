import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

import java.util.Random;

public class TebakAngkaApp extends Application {
    private int angkaBenar;
    private int jumlahPercobaan;
    private Random random = new Random();

    @Override
    public void start(Stage primaryStage) {
        /// judul awal
        Label judul = new Label("Tebak Angka");
        judul.setFont(Font.font("Arial", FontWeight.EXTRA_LIGHT, 20));
        judul.setTextFill(Color.BLUE);

        ///sub judulny
        Label subJudul = new Label("🤓Ayo menebak angka 1-100");
        subJudul.setFont(Font.font("Times New Roman", FontWeight.BOLD, 27));

        /// isi
        TextField inputTebakan = new TextField();
        inputTebakan.setPromptText("Masukkan angka disini: ");
        inputTebakan.setPrefWidth(180);
        inputTebakan.setStyle("-fx-border-color: #33c7ff; -fx-border-radius: 5; -fx-background-radius: 5");

        Button tombol = new Button("🎲ayo di tebak");
        tombol.setStyle("-fx-background-color: #007cff; -fx-text-fill: white; -fx-font-weight: bold;");

        Label labelFeedback = new Label();
        labelFeedback.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        Label labelPercobaan = new Label("Jumlah percobaan: 0");
        labelPercobaan.setFont(Font.font("Arial", FontWeight.BOLD, 12));

        /// Layout
        HBox hbox = new HBox(10, inputTebakan, tombol); ///horizontal
        hbox.setAlignment(Pos.CENTER);

        VBox vbox = new VBox(15,subJudul ,judul,labelFeedback, hbox, labelPercobaan); ///vertical
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(30));
        vbox.setStyle("-fx-Background-color:#cedff1");

        /// Inisialisasi angka
        generateAngkaBaru();

        /// tombol
        tombol.setOnAction(e -> {
            if (tombol.getText().equals("🔁Main Lagi Yuk!")) {
                generateAngkaBaru();
                jumlahPercobaan = 0;
                labelFeedback.setText("");
                labelPercobaan.setText("Jumlah percobaan: 0");
                tombol.setText("Coba Tebak!");
                inputTebakan.setStyle("-fx-background-color: white; -fx-text-fill: white; -fx-font-weight: bold;");
                inputTebakan.clear();
                inputTebakan.setDisable(false);  // Enable the TextField again
                return;
            }
            try {
                int tebakan = Integer.parseInt(inputTebakan.getText());
                jumlahPercobaan++;
                if (tebakan < angkaBenar) {
                    labelFeedback.setText("🔽kekecilan wok!");
                    labelFeedback.setTextFill(Color.ORANGE);
                } else if (tebakan > angkaBenar) {
                    labelFeedback.setText("🔼kegedean wok!");
                    labelFeedback.setTextFill(Color.ORANGE);
                } else {
                    labelFeedback.setText("horeee bener congrats!");
                    labelFeedback.setTextFill(Color.GREEN);
                    tombol.setText("🔁Main Lagi Yuk!");
                    tombol.setStyle("-fx-background-color: #0078D7; -fx-text-fill: white; -fx-font-weight: bold;");
                    inputTebakan.setDisable(true);
                }
                labelPercobaan.setText("Jumlah percobaan: " + jumlahPercobaan);
                inputTebakan.clear();
            } catch (NumberFormatException ex) {
                labelFeedback.setText("⚠️ Masukkan angka yang valid!");
                labelFeedback.setTextFill(Color.RED);
            }
        });

        ///scene & stage
        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setTitle("Tebak ygy");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void generateAngkaBaru() {
        angkaBenar = random.nextInt(100) + 1; ///random
    }

    public static void main(String[] args) {
        launch(args);
    }
}
