package sample;

import java.applet.Applet;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Controller {

    enum LINK_STATES { PLAY, FORUM, DONATE, VOTE, HIGHSCORES, NEWS}

    private LINK_STATES state;

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
    private Pane gamePane;

    @FXML
    private Hyperlink donateLink;

    @FXML
    private Hyperlink forumLink;

    @FXML
    private Hyperlink highscoreLink;

    @FXML
    private Hyperlink playLink;

    @FXML
    private Hyperlink voteLink;


    @FXML
    private Hyperlink newsLink;


    @FXML
    private ProgressBar progressBar;


    @FXML
    private WebView linkView;


    @FXML
    void clickDonate(ActionEvent event) {

        removeUnderline();

        state = LINK_STATES.DONATE;

        donateLink.setStyle("-fx-underline: true;");
        linkView.setVisible(false);
        progressBar.setVisible(true);
        linkView.getEngine().load("http://trendingfour.com/forum/Shop");

        progressBar.progressProperty().bind(linkView.getEngine().getLoadWorker().progressProperty());

        linkView.getEngine().getLoadWorker().stateProperty().addListener(
                new ChangeListener<Worker.State>() {
                    @Override
                    public void changed(ObservableValue ov, Worker.State oldState, Worker.State newState) {
                        if (newState == Worker.State.SUCCEEDED) {
                            // hide progress bar then page is ready
                            progressBar.setVisible(false);
                            linkView.setVisible(true);

                        }
                    }
                });

    }

    @FXML
    void newsClick(ActionEvent event) {
        removeUnderline();
        state = LINK_STATES.NEWS;
        newsLink.setStyle("-fx-underline: true;");

        linkView.getEngine().load("http://trendingfour.com/forum/forum/news-and-announcements");
        linkView.setVisible(false);

        progressBar.setVisible(true);

        progressBar.progressProperty().bind(linkView.getEngine().getLoadWorker().progressProperty());


        linkView.getEngine().getLoadWorker().stateProperty().addListener(
                new ChangeListener<Worker.State>() {
                    @Override
                    public void changed(ObservableValue ov, Worker.State oldState, Worker.State newState) {
                        if (newState == Worker.State.SUCCEEDED) {
                            // hide progress bar then page is ready
                            progressBar.setVisible(false);
                            linkView.setVisible(true);

                        }
                    }
                });




    }

    @FXML
    void clickForum(ActionEvent event) {
        removeUnderline();
        state = LINK_STATES.FORUM;
        forumLink.setStyle("-fx-underline: true;");


        linkView.getEngine().load("http://trendingfour.com/forum/");
        linkView.setVisible(false);

        progressBar.setVisible(true);
        progressBar.progressProperty().bind(linkView.getEngine().getLoadWorker().progressProperty());


        linkView.getEngine().getLoadWorker().stateProperty().addListener(
                new ChangeListener<Worker.State>() {
                    @Override
                    public void changed(ObservableValue ov, Worker.State oldState, Worker.State newState) {
                        if (newState == Worker.State.SUCCEEDED) {
                            // hide progress bar then page is ready
                            progressBar.setVisible(false);
                            linkView.setVisible(true);
                        }
                    }
                });

    }

    @FXML
    void clickHighscore(ActionEvent event) {
        removeUnderline();

        state = LINK_STATES.HIGHSCORES;

        highscoreLink.setStyle("-fx-underline: true;");

        linkView.getEngine().load("http://trendingfour.com/forum/Highscores");
        linkView.setVisible(false);

        progressBar.setVisible(true);
        progressBar.progressProperty().bind(linkView.getEngine().getLoadWorker().progressProperty());


        linkView.getEngine().getLoadWorker().stateProperty().addListener(
                new ChangeListener<Worker.State>() {
                    @Override
                    public void changed(ObservableValue ov, Worker.State oldState, Worker.State newState) {
                        if (newState == Worker.State.SUCCEEDED) {
                            // hide progress bar then page is ready
                            progressBar.setVisible(false);
                            linkView.setVisible(true);
                        }
                    }
                });


    }

    @FXML
    void clickVote(ActionEvent event) {
        removeUnderline();

        state = LINK_STATES.VOTE;

        voteLink.setStyle("-fx-underline: true;");

        linkView.getEngine().load("http://trendingfour.com/forum/Vote");
        linkView.setVisible(false);

        progressBar.setVisible(true);
        progressBar.progressProperty().bind(linkView.getEngine().getLoadWorker().progressProperty());


        linkView.getEngine().getLoadWorker().stateProperty().addListener(
                new ChangeListener<Worker.State>() {
                    @Override
                    public void changed(ObservableValue ov, Worker.State oldState, Worker.State newState) {
                        if (newState == Worker.State.SUCCEEDED) {
                            // hide progress bar then page is ready
                            progressBar.setVisible(false);
                            linkView.setVisible(true);
                        }
                    }
                });


    }

    @FXML
    void playClick(ActionEvent event) {
        removeUnderline();
        state = LINK_STATES.PLAY;

        playLink.setStyle("-fx-underline: true;");

        linkView.setVisible(false);

    }

    void removeUnderline(){
        donateLink.setStyle("-fx-underline: false;");
        playLink.setStyle("-fx-underline: false;");
        voteLink.setStyle("-fx-underline: false;");
        highscoreLink.setStyle("-fx-underline: false;");
        forumLink.setStyle("-fx-underline: false;");
        newsLink.setStyle("-fx-underline: false;");
    }

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
    void initialize() throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        assert closeButton != null : "fx:id=\"closeButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert donateLink != null : "fx:id=\"donateLink\" was not injected: check your FXML file 'sample.fxml'.";
        assert forumLink != null : "fx:id=\"forumLink\" was not injected: check your FXML file 'sample.fxml'.";
        assert gamePane != null : "fx:id=\"gamePane\" was not injected: check your FXML file 'sample.fxml'.";
        assert highscoreLink != null : "fx:id=\"highscoreLink\" was not injected: check your FXML file 'sample.fxml'.";
        assert mainPane != null : "fx:id=\"mainPane\" was not injected: check your FXML file 'sample.fxml'.";
        assert minimizeBut != null : "fx:id=\"minimizeBut\" was not injected: check your FXML file 'sample.fxml'.";
        assert playLink != null : "fx:id=\"playLink\" was not injected: check your FXML file 'sample.fxml'.";
        assert topControls != null : "fx:id=\"topControls\" was not injected: check your FXML file 'sample.fxml'.";
        assert voteLink != null : "fx:id=\"voteLink\" was not injected: check your FXML file 'sample.fxml'.";

        state = LINK_STATES.PLAY;

        playLink.setStyle("-fx-underline: true;");

        linkView.setVisible(false);
        progressBar.setVisible(false);

    }



}
