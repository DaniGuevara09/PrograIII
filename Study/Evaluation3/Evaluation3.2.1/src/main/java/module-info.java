module co.edu.co.evaluation3_2_1 {
    requires javafx.controls;
    requires javafx.fxml;

    exports co.edu.co.evaluation3_2_1.view;
    opens co.edu.co.evaluation3_2_1.view to javafx.fxml;
    exports co.edu.co.evaluation3_2_1.controller;
    opens co.edu.co.evaluation3_2_1.controller to javafx.fxml;
}