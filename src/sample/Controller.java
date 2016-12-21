package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Controller {

    private double xOffset, yOffset;

    @FXML
    private Hyperlink closeButton;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private Hyperlink minimizeBut;

    @FXML
    private HBox topControls;


    @FXML
    void closeWindow(ActionEvent event) {
        Stage stage = (Stage) Stage.class.cast(Hyperlink.class.cast(event.getSource()).getScene().getWindow()).getScene().getWindow();
        stage.close();
        System.exit(0);
    }

    @FXML
    void minimizeWindow(ActionEvent event) {
        Stage stage = (Stage) Stage.class.cast(Hyperlink.class.cast(event.getSource()).getScene().getWindow()).getScene().getWindow();
        stage.setIconified(true);
    }


    @FXML
    void setOffset(MouseEvent event) {
        Stage stage = Stage.class.cast(HBox.class.cast(event.getSource()).getScene().getWindow());


        xOffset = stage.getX() - event.getScreenX();
        yOffset = stage.getY() - event.getScreenY();
    }

    @FXML
    void setPosition(MouseEvent event) {
        Stage stage = (Stage) Stage.class.cast(HBox.class.cast(event.getSource()).getScene().getWindow()).getScene().getWindow();

        stage.setX(event.getScreenX() + xOffset);
        stage.setY(event.getScreenY() + yOffset);
    }

    @FXML
    void initialize() {
        assert closeButton != null : "fx:id=\"closeButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert mainPane != null : "fx:id=\"mainPane\" was not injected: check your FXML file 'sample.fxml'.";
        assert minimizeBut != null : "fx:id=\"minimizeBut\" was not injected: check your FXML file 'sample.fxml'.";
        assert topControls != null : "fx:id=\"topControls\" was not injected: check your FXML file 'sample.fxml'.";


    }

}
