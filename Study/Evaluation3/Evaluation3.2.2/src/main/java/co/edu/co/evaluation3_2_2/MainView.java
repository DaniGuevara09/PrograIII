package co.edu.co.evaluation3_2_2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class MainView extends Application {
    private Label label1;
    private Label label2;
    private Label label3;
    private static ImageView imageView1;
    private static ImageView imageView2;
    private static ImageView imageView3;
    private Button playButton;
    private Button pauseButton;
    private Button stopButton;
    private boolean isPlayClicked = false;
    private static Figure f1;
    private static Figure f2;
    private static Figure f3;

    public MainView() {
        label1 = new Label("País 1");
        label2 = new Label("País 2");
        label3 = new Label("País 3");
        imageView1 = new ImageView(new Image("file:src/main/resources/icon/beef.png"));
        imageView2 = new ImageView(new Image("file:src/main/resources/icon/bread.png"));
        imageView3 = new ImageView(new Image("file:src/main/resources/icon/orange.png"));
        playButton = new Button("Play");
        pauseButton = new Button("Pause");
        stopButton = new Button("Stop");
    }

    public void threads(){
        Time t1 = new Time("Europe/Madrid", label1);
        Time t2 = new Time("America/Bogota", label2);
        Time t3 = new Time("Asia/Tokyo", label3);

        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        Thread thread3 = new Thread(t3);

        thread1.start();
        thread2.start();
        thread3.start();
    }

    public static void threadsFigure(int op) {
        if (f1 == null || f2 == null || f3 == null) {
            f1 = new Figure(imageView1, 1);
            f2 = new Figure(imageView2, 1);
            f3 = new Figure(imageView3, 1);

            Thread thread4 = new Thread(f1);
            Thread thread5 = new Thread(f2);
            Thread thread6 = new Thread(f3);

            thread4.start();
            thread5.start();
            thread6.start();
        }

        switch (op) {
            case 2 -> {
                f1.resume();
                f2.resume();
                f3.resume();
            }
            case 3 -> {
                f1.pause();
                f2.pause();
                f3.pause();
            }
            case 4 -> {
                f1.stop();
                f2.stop();
                f3.stop();
            }
        }
    }

    public void actions() {
        playButton.setOnAction(e -> {
            if (!isPlayClicked) {
                threadsFigure(1);
                isPlayClicked = true;
            } else {
                threadsFigure(2);
            }
        });

        pauseButton.setOnAction(e -> threadsFigure(3)); // Pausa
        stopButton.setOnAction(e -> threadsFigure(4));  // Detiene
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        borderPane.setPrefSize(600, 400);

        GridPane topGrid = new GridPane();
        topGrid.setAlignment(javafx.geometry.Pos.CENTER);
        topGrid.setPrefSize(600, 74);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHalignment(javafx.geometry.HPos.CENTER);
        col1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        col1.setPrefWidth(100);

        ColumnConstraints col2 = new ColumnConstraints();
        col2.setHalignment(javafx.geometry.HPos.CENTER);
        col2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        col2.setPrefWidth(100);

        ColumnConstraints col3 = new ColumnConstraints();
        col3.setHalignment(javafx.geometry.HPos.CENTER);
        col3.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        col3.setPrefWidth(100);

        topGrid.getColumnConstraints().addAll(col1, col2, col3);

        RowConstraints row = new RowConstraints();
        row.setMinHeight(10);
        row.setPrefHeight(30);
        row.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
        topGrid.getRowConstraints().add(row);

        topGrid.add(label1, 0, 0);
        topGrid.add(label2, 1, 0);
        topGrid.add(label3, 2, 0);

        GridPane bottomGrid = new GridPane();
        bottomGrid.setAlignment(javafx.geometry.Pos.CENTER);
        bottomGrid.setPrefSize(604, 79);
        bottomGrid.setStyle("-fx-border-color: black;");

        bottomGrid.getColumnConstraints().addAll(col1, col2, col3);
        bottomGrid.getRowConstraints().add(row);

        bottomGrid.add(playButton, 0, 0);
        bottomGrid.add(pauseButton, 1, 0);
        bottomGrid.add(stopButton, 2, 0);

        Pane centerPane = new Pane();
        centerPane.setPrefSize(600, 200);

        imageView1.setFitHeight(50);
        imageView1.setFitWidth(50);
        imageView1.setLayoutX(434);
        imageView1.setLayoutY(100);

        imageView2.setFitHeight(50);
        imageView2.setFitWidth(50);
        imageView2.setLayoutX(264);
        imageView2.setLayoutY(100);

        imageView3.setFitHeight(50);
        imageView3.setFitWidth(50);
        imageView3.setLayoutX(74);
        imageView3.setLayoutY(100);

        centerPane.getChildren().addAll(imageView1, imageView2, imageView3);

        borderPane.setTop(topGrid);
        borderPane.setBottom(bottomGrid);
        borderPane.setCenter(centerPane);

        threads();
        actions();

        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Window");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
