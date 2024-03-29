package Paint_app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class Sidepanel extends VBox {
    private Button rightBtn, leftBtn;

    public Sidepanel() {
        // Vi sätter en bakgrundsfärg, #d4d6d5 är hexkoden för en
        // färg. Googla efter colorpicker och välj en färg ni gillar.
        setStyle("-fx-background-color: #a4d6d5;");
        setMaxHeight(100); // Sätter höjden på panelen till 100 pixlar
        setMaxWidth(100); // Sätter bredden till 1000 pixlar

        // Vi initerar knapparna. Mer under Knappar / Buttons om hur de fungerar.
        rightBtn = new Button("Right");
        leftBtn = new Button("Left");
        // Vi lägger till leftButton först då vi vill ha den vänster.
        getChildren().add(leftBtn);
        getChildren().add(rightBtn);	          // Vi sätter en bakgrundsfärg, #d4d6d5 är hexkoden för en
    }
}
