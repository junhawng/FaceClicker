import java.util.ArrayList;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public abstract class World extends Pane{
	AnimationTimer timer;
	private Animate animate = new Animate();
	Text time = new Text("Time Elapsed: " + 000000);
	long timeStarted = System.currentTimeMillis();
	long timePassed;
	public World(){
//		timer = new AnimationTimer(){
//			private long n = 100_000_000;
//			private long last = 0;
//			
//			@Override
//			public void handle(long now) {
//				if (now - last >= n) {
//				act(now);
//				for(Actor a: getObjects(Actor.class)){
//					if(a.getWorld() != null) a.act(now);
//				}
//			}
//		};
//		}
	}
	
	
	public void act(long now){
		
	}
	
	public void add(Actor actor){
		this.getChildren().add(actor);
	}
	
	public void remove(Actor actor){
		this.getChildren().remove(actor);
	}
	
	public <A extends Actor>java.util.List<A> getObjects(java.lang.Class<A> cls){
    	return getObjects(cls);
    	
    }
	public void start(){
		timer.start();
	}
	
	public void stop(){
		timer.stop();
	}
	private class Animate extends AnimationTimer {
		private long n = 100_000_000;
		private long last = 0;

		@Override
		public void handle(long now) {
			if (now - last >= n) {
				timePassed = (System.currentTimeMillis() - timeStarted) / 1000;
				time.setText("Time Elapsed: " + timePassed);
				last = now;
			}
		}
	}
}
