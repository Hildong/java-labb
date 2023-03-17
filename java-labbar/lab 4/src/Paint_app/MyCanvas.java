package Paint_app;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class MyCanvas extends Canvas {

    GraphicsContext context = getGraphicsContext2D();
    public MyCanvas() {
        // Precis som andra "paneler" kan vi sätta bredd och höjd på vårt canvas
        setHeight(500);
        setWidth(900);
        // Vi kan även sätta bakgrundsfärg om vi vill
        setStyle("-fx-background-color: #00f241;");

        // Vi kan säga vad som ska hända när vi klickar i vårt canvas.
        setOnMouseClicked(event -> {
            context.fillRect(event.getX() - 25, event.getY() - 25, 50, 50);
            System.out.println("Ojojoj, vi klicka i Canvas. Tvärtufft!");
        });
    }
}