package Paint_app;

import javafx.application.Application;
import javafx.scene.Scene;

import javafx.scene.layout.BorderPane;

import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

import java.awt.*;


public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Välkommen till Ritprogrammet!");
        primaryStage.setWidth(1000); // Vi sätter bredden till 1000 pixlar
        primaryStage.setHeight(600); // Vi sätter höjden till 600 pixlar

        Sidepanel side = new Sidepanel();
        Colorpanel x = new Colorpanel();
        MyCanvas canvas = new MyCanvas();


        HBox mainLayout = new HBox();
        mainLayout.setMaxWidth(1000);
        mainLayout.setMaxHeight(600);
        mainLayout.getChildren().add(side); // Sidopanelen
        mainLayout.getChildren().add(x); // Sidopanelen
        mainLayout.getChildren().add(canvas); // Sidopanelen

        Scene theScene = new Scene(mainLayout); // Vi skapar en scen åt vår layout
        primaryStage.setScene(theScene); // Vi sätter scenen i fönstret
        primaryStage.show(); // Vi säger till fönstret att rita ut sig.
    }
}