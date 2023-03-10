package Game;

import javafx.fxml.FXML;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.application.Platform;
import java.util.Timer;
import java.util.TimerTask;

public class Events implements EventHandler<KeyEvent> {
    final private static double FRAMES_PER_SECOND = 5.0;

    @FXML private Label scoreLabel;
    @FXML private Label levelLabel;
    @FXML private Label gameOverLabel;
    @FXML private Window gameWindow;
    private Model gameModel;
    private static final String[] levelFiles = {"src/maps/normal.txt"};

    private Timer timer;
    private static int ghostEatingModeCounter;
    private boolean paused;

    public Events() {
        this.paused = false;
    }
 

    /**
     * Takes in user keyboard input to control the movement of PacMan and start new games
     * @param keyEvent user's key click
     */
    @Override
    public void handle(KeyEvent keyEvent) {
        boolean keyRecognized = true;
        KeyCode code = keyEvent.getCode();
        Model.Direction direction = Model.Direction.NONE;
        if (code == KeyCode.LEFT) {
            direction = Model.Direction.LEFT;
        } else if (code == KeyCode.RIGHT) {
            direction = Model.Direction.RIGHT;
        } else if (code == KeyCode.UP) {
            direction = Model.Direction.UP;
        } else if (code == KeyCode.DOWN) {
            direction = Model.Direction.DOWN;
        } else if (code == KeyCode.G) {
            pause();
            this.gameModel.startNewGame();
            this.gameOverLabel.setText(String.format(""));
            paused = false;
            //this.startTimer();
        } else {
            keyRecognized = false;
        }
        if (keyRecognized) {
            keyEvent.consume();
            gameModel.setCurrentDirection(direction);
        }
    }

    /**
     * Pause the timer
     */
    public void pause() {
            this.timer.cancel();
            this.paused = true;
    }

    public static void setGhostEatingModeCounter() {
        ghostEatingModeCounter = 25;
    }

    public static int getGhostEatingModeCounter() {
        return ghostEatingModeCounter;
    }

    public static String getLevelFile(int x)
    {
        return levelFiles[x];
    }

    public boolean getPaused() {
        return paused;
    }
}