module com.cs210.nothingtoeat {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.datatransfer;

    opens com.cs210.nothingtoeat to javafx.fxml;
  //  exports com.cs210.nothingtoeat;
    exports com.cs210.nothingtoeat.controller;
    opens com.cs210.nothingtoeat.controller to javafx.fxml;
    exports com.cs210.nothingtoeat.view;
    opens com.cs210.nothingtoeat.view to javafx.fxml;
}