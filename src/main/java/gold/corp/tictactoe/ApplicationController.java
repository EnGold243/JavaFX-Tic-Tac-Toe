package gold.corp.tictactoe;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import java.net.URL;
import java.util.ResourceBundle;

public class ApplicationController implements Initializable {
    @FXML
    protected AnchorPane panes;
    @FXML
    protected Label tvStep;

    protected boolean whoseTurn;
    protected double layoutX,layoutY;
    protected final double size = 50;

    protected final char[] place = new char[9];
    protected boolean isWin;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(whoseTurn)
            tvStep.setText("X's turn");
        else
            tvStep.setText("O's turn");
        panesOnClick();
        panesStyle();
    }

    private void panesOnClick(){
        for (int i = 0; i < 9; i++) {
            int finalI = i;
            panes.getChildren().get(i).setOnMouseClicked(mouseEvent ->
            {
                Pane pane = (Pane) panes.getChildren().get(finalI);
                layoutX = pane.getWidth()/2-size;
                layoutY = pane.getHeight()/2-size;

                if(whoseTurn && !(place[finalI] == 'X' || place[finalI] == 'O') && !isWin){
                    place[finalI] = 'X';
                    Line line1 = new Line(-size, 0, size, 0);
                    Line line2 = new Line(0, -size, 0, size);
                    StackPane lines = new StackPane(line1, line2);
                    lines.setRotate(45);
                    setShape(pane, lines);
                    whoseTurn = !whoseTurn;
                    tvStep.setText("O's turn");
                    isWin = winXCheck();
                }
                else if(!whoseTurn && !(place[finalI] == 'X' || place[finalI] == 'O') && !isWin) {
                    place[finalI] = 'O';
                    Circle circle = new Circle(50);
                    circle.setFill(Color.TRANSPARENT);
                    circle.setStrokeWidth(1.0);
                    circle.setStroke(Color.BLACK);
                    StackPane circlePane = new StackPane(circle);
                    setShape(pane, circlePane);
                    whoseTurn = !whoseTurn;
                    tvStep.setText("X's turn");
                    isWin = winOCheck();
                }
            });
        }
    }
    private void setShape(Pane node, StackPane shape) {
        shape.setLayoutX(layoutX);
        shape.setLayoutY(layoutY);
        node.getChildren().add(shape);
    }
    private void panesStyle(){
        for (int i = 0; i < 9; i++) {
            panes.getChildren().get(i).getStyleClass().add("border");
        }
    }
    private boolean winXCheck(){
        char thisP = 'X';
        if(place[0] == thisP && place[1] == thisP && place[2] == thisP){
            tvStep.setText("WIN " + thisP);
            return true;
        }
        else  if(place[3] == thisP && place[4] == thisP && place[5] == thisP){
            tvStep.setText("WIN " + thisP);
            return true;
        }
        else  if(place[6] == thisP && place[7] == thisP && place[8] == thisP){
            tvStep.setText("WIN " + thisP);
            return true;
        }
        else  if(place[0] == thisP && place[3] == thisP && place[6] == thisP){
            tvStep.setText("WIN " + thisP);
            return true;
        }
        else  if(place[1] == thisP && place[4] == thisP && place[7] == thisP){
            tvStep.setText("WIN " + thisP);
            return true;
        }
        else  if(place[2] == thisP && place[5] == thisP && place[8] == thisP){
            tvStep.setText("WIN " + thisP);
            return true;
        }
        else  if(place[0] == thisP && place[4] == thisP && place[8] == thisP){
            tvStep.setText("WIN " + thisP);
            return true;
        }
        else if(place[2] == thisP && place[4] == thisP && place[6] == thisP) {
            tvStep.setText("WIN " + thisP);
            return true;
        }
        return false;
    }
    private boolean winOCheck(){
        char thisP = 'O';
        if(place[0] == thisP && place[1] == thisP && place[2] == thisP){
            tvStep.setText("WIN " + thisP);
            return true;
        }
        else  if(place[3] == thisP && place[4] == thisP && place[5] == thisP){
            tvStep.setText("WIN " + thisP);
            return true;
        }
        else  if(place[6] == thisP && place[7] == thisP && place[8] == thisP){
            tvStep.setText("WIN " + thisP);
            return true;
        }
        else  if(place[0] == thisP && place[3] == thisP && place[6] == thisP){
            return true;
        }
        else  if(place[1] == thisP && place[4] == thisP && place[7] == thisP){
            tvStep.setText("WIN " + thisP);
            return true;
        }
        else  if(place[2] == thisP && place[5] == thisP && place[8] == thisP){
            tvStep.setText("WIN " + thisP);
            return true;
        }
        else  if(place[0] == thisP && place[4] == thisP && place[8] == thisP){
            tvStep.setText("WIN " + thisP);
            return true;
        }
        else if(place[2] == thisP && place[4] == thisP && place[6] == thisP) {
            tvStep.setText("WIN " + thisP);
            return true;
        }
        return false;
    }

    public void resetGame() {
        for (int i = 0; i < 9; i++) {
            place[i] = ' ';
            Pane pane = (Pane) panes.getChildren().get(i);
            pane.getChildren().clear();
        }
        whoseTurn = false;
        tvStep.setText("O's turn");
        isWin = false;
    }
}
