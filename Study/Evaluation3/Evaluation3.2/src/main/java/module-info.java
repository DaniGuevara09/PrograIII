module org.example.evaluation3_2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.evaluation3_2 to javafx.fxml;
    exports org.example.evaluation3_2;
}