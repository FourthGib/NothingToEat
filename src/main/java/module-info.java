module com.cs210.nothingtoeat {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.cs210.nothingtoeat to javafx.fxml;
    exports com.cs210.nothingtoeat;
}