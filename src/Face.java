import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
public class Face extends Actor{
	
	private double x, y;
	private double speed, direction;
	private boolean rage = false;
	private String img = "";
	public Face(String imageFileName){
		img = imageFileName; 
		x = this.getXValue();
		y = this.getYValue();
		System.out.println(x+  "," + y);
		this.rage = false; 
	}
	
	public Face(String imageFileName, boolean rage){
		img = imageFileName;
		this.rage = rage;
	}
	
	@Override
	public void act(long now){
		if(rage){
			
		}else{
			
		}
	}
	
	public String getImgName(){
		return img;
	}
	
	public void setImgName(String imgName){
		img = imgName;
	}
	
	public double getSpeed(){
		return speed;
	}
	public double getDirection(){
		return direction;
	}
	public void setSpeed(double in){
		speed = in;
	}
	public void setDirection(double in){
		direction = in; 
	}
	public double getXValue(){
		return x;
	}
	
	public double getYValue(){
		return y;
	}
	
	public void setXValue(double dx){
		this.x = dx;
	}
	
	public void setYValue(double dy){
		this.y = dy;
	}
	public boolean getRage(){
		return rage; 
	}
	public void setRage(){
		rage = !rage; 
	}
}

	
