package Game;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Window extends Group {
    public final static double CELL_WIDTH = 20.0;

    @FXML private int rowCount;
    @FXML private int columnCount;
    private ImageView[][] cellViews;
    private Image pacmanRightImage;
    private Image pacmanUpImage;
    private Image pacmanDownImage;
    private Image pacmanLeftImage;
    private Image ghost1Image;
    private Image ghost2Image;
    private Image blueGhostImage;
    private Image wallImage;
    private Image bigDotImage;
    private Image smallDotImage;

    /**
     * Initializes the values of the image instance variables from files
     */
    public Window() {
        this.pacmanRightImage = new Image(getClass().getResourceAsStream("/res/pacmanRight.gif"));
        this.pacmanUpImage = new Image(getClass().getResourceAsStream("/res/pacmanUp.gif"));
        this.pacmanDownImage = new Image(getClass().getResourceAsStream("/res/pacmanDown.gif"));
        this.pacmanLeftImage = new Image(getClass().getResourceAsStream("/res/pacmanLeft.gif"));
        this.ghost1Image = new Image(getClass().getResourceAsStream("/res/redghost.gif"));
        this.ghost2Image = new Image(getClass().getResourceAsStream("/res/ghost2.gif"));
        this.blueGhostImage = new Image(getClass().getResourceAsStream("/res/blueghost.gif"));
        this.wallImage = new Image(getClass().getResourceAsStream("/res/wall.png"));
        this.bigDotImage = new Image(getClass().getResourceAsStream("/res/whitedot.png"));
        this.smallDotImage = new Image(getClass().getResourceAsStream("/res/smalldot.png"));
    }

    /**
     * Constructs an empty grid of ImageViews
     */
    private void initializeGrid() {
        if (this.rowCount > 0 && this.columnCount > 0) {
            this.cellViews = new ImageView[this.rowCount][this.columnCount];
            for (int row = 0; row < this.rowCount; row++) {
                for (int column = 0; column < this.columnCount; column++) {
                    ImageView imageView = new ImageView();
                    imageView.setX((double)column * CELL_WIDTH);
                    imageView.setY((double)row * CELL_WIDTH);
                    imageView.setFitWidth(CELL_WIDTH);
                    imageView.setFitHeight(CELL_WIDTH);
                    this.cellViews[row][column] = imageView;
                    this.getChildren().add(imageView);
                }
            }
        }
    }

    /** Updates the view to reflect the state of the model
     *
     * @param model
     */
    public void update(Model model) {
        assert model.getRowCount() == this.rowCount && model.getColumnCount() == this.columnCount;
        //for each ImageView, set the image to correspond with the CellValue of that cell
        for (int row = 0; row < this.rowCount; row++){
            for (int column = 0; column < this.columnCount; column++){
                Model.CellValue value = model.getCellValue(row, column);
                if (value == Model.CellValue.WALL) {
                    this.cellViews[row][column].setImage(this.wallImage);
                }
                else if (value == Model.CellValue.BIGDOT) {
                    this.cellViews[row][column].setImage(this.bigDotImage);
                }
                else if (value == Model.CellValue.SMALLDOT) {
                    this.cellViews[row][column].setImage(this.smallDotImage);
                }
                else {
                    this.cellViews[row][column].setImage(null);
                }
                //check which direction PacMan is going in and display the corresponding image
                if (row == model.getPacmanLocation().getX() && column == model.getPacmanLocation().getY() && (Model.getLastDirection() == Model.Direction.RIGHT || Model.getLastDirection() == Model.Direction.NONE)) {
                    this.cellViews[row][column].setImage(this.pacmanRightImage);
                }
                else if (row == model.getPacmanLocation().getX() && column == model.getPacmanLocation().getY() && Model.getLastDirection() == Model.Direction.LEFT) {
                    this.cellViews[row][column].setImage(this.pacmanLeftImage);
                }
                else if (row == model.getPacmanLocation().getX() && column == model.getPacmanLocation().getY() && Model.getLastDirection() == Model.Direction.UP) {
                    this.cellViews[row][column].setImage(this.pacmanUpImage);
                }
                else if (row == model.getPacmanLocation().getX() && column == model.getPacmanLocation().getY() && Model.getLastDirection() == Model.Direction.DOWN) {
                    this.cellViews[row][column].setImage(this.pacmanDownImage);
                }
                //make ghosts "blink" towards the end of ghostEatingMode (display regular ghost images on alternating updates of the counter)
                if (Model.isGhostEatingMode() && (Events.getGhostEatingModeCounter() == 6 ||Events.getGhostEatingModeCounter() == 4 || Events.getGhostEatingModeCounter() == 2)) {
                    if (row == model.getGhost1Location().getX() && column == model.getGhost1Location().getY()) {
                        this.cellViews[row][column].setImage(this.ghost1Image);
                    }
                    if (row == model.getGhost2Location().getX() && column == model.getGhost2Location().getY()) {
                        this.cellViews[row][column].setImage(this.ghost2Image);
                    }
                }
                //display blue ghosts in ghostEatingMode
                else if (Model.isGhostEatingMode()) {
                    if (row == model.getGhost1Location().getX() && column == model.getGhost1Location().getY()) {
                        this.cellViews[row][column].setImage(this.blueGhostImage);
                    }
                    if (row == model.getGhost2Location().getX() && column == model.getGhost2Location().getY()) {
                        this.cellViews[row][column].setImage(this.blueGhostImage);
                    }
                }
                //dispaly regular ghost images otherwise
                else {
                    if (row == model.getGhost1Location().getX() && column == model.getGhost1Location().getY()) {
                        this.cellViews[row][column].setImage(this.ghost1Image);
                    }
                    if (row == model.getGhost2Location().getX() && column == model.getGhost2Location().getY()) {
                        this.cellViews[row][column].setImage(this.ghost2Image);
                    }
                }
            }
        }
    }

    public double getBoardWidth() {
        return CELL_WIDTH * this.getColumnCount();
    }

    public double getBoardHeight() {
        return CELL_WIDTH * this.getRowCount();
    }

    public int getRowCount() {
        return this.rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
        this.initializeGrid();
    }

    public int getColumnCount() {
        return this.columnCount;
    }

    public void setColumnCount(int columnCount) {
        this.columnCount = columnCount;
        this.initializeGrid();
    }
}
