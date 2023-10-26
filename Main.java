import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader=new FXMLLoader(this.getClass().getResource("PongGame.fxml"));
        Parent root=loader.load();
        Scene scene=new Scene(root);
        PongGameController controller=loader.getController();

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                                  @Override
                                  public void handle(KeyEvent event) {
                                      Platform.runLater(new Runnable() {
                                          @Override
                                          public void run() {
                                              if (event.getCode().equals(KeyCode.UP)) {
                                                  new Thread(controller::firstRectangleUp).start();
                                              }else if (event.getCode().equals(KeyCode.DOWN)) {
                                                  new Thread(controller::firstRectangleDown).start();
                                              }else if (event.getCode().equals(KeyCode.W)) {
                                                  new Thread(controller::secondRectangleUp).start();
                                              }else if (event.getCode().equals(KeyCode.S)) {
                                                  new Thread(controller::secondRectangleDown).start();
                                              }
                                          }
                                      });


                                  }
                              });
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image(Objects.requireNonNull(this.getClass().getResourceAsStream("images.png"))));
        primaryStage.setTitle("Pong game");
//        primaryStage.setResizable(false);
        primaryStage.show();

    }
}
