module com.ivytech.adventure {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.ivytech.adventure to javafx.fxml;
    exports com.ivytech.adventure;
}