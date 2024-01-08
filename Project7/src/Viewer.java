import java.util.ArrayList;
import java.util.List;

public class Viewer extends Observer{
    private Non_playable visualViewingNow;
    private Non_playable previousText;
    private Non_playable previousImage;

    private List<ObjectType> playList = new ArrayList<>();

    public boolean remove(ObjectType toRemove){
        playList.remove(toRemove);
        if(previousImage != null && previousImage.equals(toRemove)){
            previousImage = null;
        }
        if(previousText != null && previousText.equals(toRemove)){
            previousText = null;
        }
        if(visualViewingNow == null || visualViewingNow.equals(toRemove)){
            return true;
        }

        return false;
    }

    private int getIndexOfCurrent(){
        int index = 0;
        for(ObjectType type : playList){
            if(type.equals(visualViewingNow)){
                return index + 1;
            }
            index++;
        }

        return 0;
    }

    public void next(ObjectType obj){
        if(playList.isEmpty()){
            System.out.println("List is empty. Cannot go next!");
            return;
        }

        for (int i = getIndexOfCurrent(); i < playList.size(); i++) {
            ObjectType type = playList.get(i);
            if(type instanceof Text && obj instanceof Text){
                if(visualViewingNow instanceof Text){
                    previousText = visualViewingNow;
                }
                else if(visualViewingNow instanceof Image){
                    previousImage = visualViewingNow;
                }
                visualViewingNow = (Non_playable) playList.get(i);
                break;
            }
            else if(type instanceof Image
                    && obj instanceof Image){
                if(visualViewingNow instanceof Text){
                    previousText = visualViewingNow;
                }
                else if(visualViewingNow instanceof Image){
                    previousImage = visualViewingNow;
                }
                visualViewingNow = (Non_playable) playList.get(i);
                break;
            }
        }
    }

    public void previous(ObjectType prev){
        Non_playable temp = visualViewingNow;
        if(prev instanceof Text){
            visualViewingNow = previousText;
        }
        else if(prev instanceof Image){
            visualViewingNow = previousImage;
        }

        if(temp instanceof Image){
            previousImage = temp;
        } else if (temp instanceof Text) {
            previousText = temp;
        }
    }

    public void show_list(){
        playList.forEach(i -> ((Non_playable)i).info());
    }

    public Non_playable currently_viewing(){
        if(visualViewingNow == null){
            visualViewingNow = (Non_playable) playList.get(0);
        }
        return visualViewingNow;
    }

    public List<ObjectType> getPlayList() {
        return playList;
    }

    public Non_playable getPreviousImage() {
        return previousImage;
    }

    public Non_playable getPreviousText() {
        return previousText;
    }

    public Non_playable getVisualViewingNow() {
        return visualViewingNow;
    }

    @Override
    public void update(ObjectType playOrViewObject) {
        playList.add(playOrViewObject);
    }
}
