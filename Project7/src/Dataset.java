import java.util.ArrayList;
import java.util.List;

public class Dataset {
	//list of media objects text,image,video, etc...
    private List<ObjectType> objects = new ArrayList<>();
	//list of observers: Viewer and Player
    private List<Observer> observers = new ArrayList<>();


    public void register(Observer observerObject){
        //adds observer to list
        observers.add(observerObject);
    }

    public void add(ObjectType objectToAdd){
        //adds the media to the list
        objects.add(objectToAdd);

        for(Observer observer : observers){
            //sends media to player object if its playable
            if(observer instanceof Player && (objectToAdd instanceof Playable)){
                observer.update(objectToAdd);
            }
            //sends media to viewer object if its non playable
            if(observer instanceof Viewer && (objectToAdd instanceof Non_playable)){
                observer.update(objectToAdd);
            }
        }
    }


    public void remove_observer(Observer obj){
        observers.remove(obj);
    }

    public void remove(ObjectType objectToRemove){
        //remove a media from the dataset
        for(Observer observer : observers){
            if(observer instanceof Player){
                //returns true if the removal removed the current playing object
                boolean flag = ((Player) observer).remove(objectToRemove);
                if(flag){
                    //moves to next
                    ((Player)observer).next(objects.get(0));
                }
            }
            else if(observer instanceof Viewer){
				//flags becomes true if removed object is also the current
                boolean flag = ((Viewer)observer).remove(objectToRemove);
                if(flag){
                    ((Viewer)observer).next(objects.get(0));
                }
            }
        }
        objects.remove(objectToRemove);
    }



}
