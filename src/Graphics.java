import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Graphics extends Application {
	BorderPane borderPane = new BorderPane();
	ToolBar toolbar = new ToolBar();
	private final double boxWidth = 150;
	private final double boxHeight = 300;
	Group root = new Group();
	Scene scene = new Scene(root, 400, 500);
	Score score = new Score(0);
	Text generation = new Text("Score: " + score.getScore());
	private Animate animate = new Animate();
	private ImageView img = new ImageView();
	Face face;
	Bounds bounds = borderPane.getBoundsInLocal();
	double dx = 5;
	double dy = 5;

	public static void main(String[] args) {
		launch(args);
	}

	public Parent createContent() {
		// top
		HBox top = new HBox();
		top.getChildren().add(generation);
		borderPane.setTop(top);
		// face
		face = new Face("normalFace.png");
		EventHandler myMouseEvent = new myMouseEvent();
		img.setImage(new Image(face.getImgName()));
		img.setOnMousePressed(myMouseEvent);
		borderPane.setCenter(img);

		borderPane.setPrefSize(700, 900);
		return borderPane;
	}

	private void moveImg(ImageView img, double x, double y) {
		borderPane.getChildren().remove(img);
		face.setXValue(x);
		face.setYValue(y);
		img.setX(face.getXValue());
		img.setY(face.getYValue());
		borderPane.getChildren().add(img);

	}
	
	private void setRandomDx(){
		dx = (int)(Math.random()*20);
	}
	
	private void setRandomDy(){
		dy = (int)(Math.random()*20);
	}

//	private void directionMove(ImageView img, double speed, double direction) {
//		dx = face.getXValue() + Math.cos(direction * (Math.PI / 180)) * speed;
//		dy = face.getYValue() + Math.sin(direction * (Math.PI / 180)) * speed;
//		moveImg(img, dx, dy);
//
//	}
	
	private void speedImg(ImageView img, double dx, double dy){
		borderPane.getChildren().remove(img);
		face.setXValue(face.getXValue() + dx);
		face.setYValue(face.getYValue() + dy);
		img.setX(face.getXValue());
		img.setY(face.getYValue());
		borderPane.getChildren().add(img);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Face Clicker");
		stage.setResizable(false);
		stage.setScene(new Scene(createContent()));
		stage.show();

	}

	class myMouseEvent implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent e) {
			if (e.getButton() == MouseButton.PRIMARY) {
				score.addScore(1, 1);
				generation.setText("Score: " + score.getScore());
				System.out.println(face.getXValue());
//				if(Math.random()*5 == 1){
//					face.setRage();
//				}
//				if(face.getRage()){
					setRandomDx();
					setRandomDy();
//				}
				animate.start();
				
			}
		}

	}

	private class Animate extends AnimationTimer {
		private long n = 100_000_000;
		private long last = 0;

		@Override
		public void handle(long now) {
			if (now - last >= n) {
				// what happens when animation happens
				if (img.getBoundsInLocal().getWidth()/2 + face.getXValue() >= scene.getWidth()){
					dx = -dx;		
				}
				if (face.getXValue() - img.getBoundsInLocal().getWidth()/2  <= (-1)*scene.getWidth()){
					dx = - dx;
				}
				if (img.getBoundsInLocal().getHeight()/2 + face.getYValue() >= scene.getHeight()){
					dy = -dy;		
				}
				if (face.getYValue() - img.getBoundsInLocal().getHeight()/2  <= (-1)*scene.getHeight()){
					dy = - dy;
				}
				speedImg(img, dx, dy);
				
			}
		}
	}

}