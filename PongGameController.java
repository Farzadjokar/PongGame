import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.security.SecureRandom;

public class PongGameController {
    public void initialize(){
        SecureRandom random=new SecureRandom();
        Timeline timeline=new Timeline(new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>() {
            int dx=10;
            int dy=10;
            @Override
            public void handle(final ActionEvent event) {
                circle.setLayoutY(dy+circle.getLayoutY());
                circle.setLayoutX(dx+circle.getLayoutX());
                Bounds bounds=anchorPane.getBoundsInLocal();
                if(circle.getLayoutY()<=(bounds.getMinY()+circle.getRadius())||
                circle.getLayoutY()>=(bounds.getMaxY()-circle.getRadius())){
                    dy*=-1;
                }
                if(circle.getLayoutX()==rectangle1.getLayoutX()&&circle.getLayoutY()>=rectangle1.getLayoutY()&&circle.getLayoutY()<=100+rectangle1.getLayoutY()){
                    dx*=-1;
                }else if (circle.getLayoutX()==rectangle2.getLayoutX()&&circle.getLayoutY()>=rectangle2.getLayoutY()&&circle.getLayoutY()<=100+rectangle2.getLayoutY()){
                    dx*=-1;
                }
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

  private   double y=150;
  private  double x=150;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Rectangle rectangle1;

    @FXML
    private Rectangle rectangle2;

    @FXML
    private Circle circle;



   public void firstRectangleDown(){
       y=rectangle1.getLayoutY();
       if(y>=300){
           y=300;
       }
       rectangle1.setLayoutY(y+=15);
   }
    public void firstRectangleUp(){
        y=rectangle1.getLayoutY();
        if(y<=0){
            y=0;
        }
        rectangle1.setLayoutY(y-=15);
    }
    public void secondRectangleUp(){
        x=rectangle2.getLayoutY();
        if(x<=0){
            x=0;
        }
        rectangle2.setLayoutY(x-=15);
    }
    public void secondRectangleDown(){
        x=rectangle2.getLayoutY();
        if(x>=300){
            x=300;
        }
        rectangle2.setLayoutY(x+=15);
    }
}
