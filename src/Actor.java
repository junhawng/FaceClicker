import java.util.ArrayList;

public abstract class Actor extends javafx.scene.image.ImageView{
    
    public Actor(){
        
    }
    
    public abstract void act(long now);
    
    public double getHeight(){
        return getFitHeight();
        
    }
    
    public double getWidth(){
        return getFitWidth();
        
    }
        
    public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
        
        ArrayList<A> list = new ArrayList<A>();

        for(int i = 0; i < getWorld().getObjects(cls).size(); i++){
            if(getWorld().getObjects(cls).get(i).equals(this)){
                list.add(getWorld().getObjects(cls).get(i));
            }
        }
        
        return list;
        
    }
    
    public <A extends Actor> A getOneIntersectingObject(java.lang.Class<A> cls){

        for(int i = 0; i < getWorld().getObjects(cls).size(); i++){
            if(getWorld().getObjects(cls).get(i).equals(this)){
                return getWorld().getObjects(cls).get(i);
            }
        }
        return null;
        
    }

    public World getWorld(){
        return (World)getParent();
        
    }
    
    public void move(double dx, double dy){
        setX(dx);
        setY(dy);
    }
    
}