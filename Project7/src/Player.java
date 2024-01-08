import java.util.ArrayList;
import java.util.List;

public class Player extends Observer{
	//Pointer on the currentplaying object
    private Playable playingNow;
	//Pointer on the last video object
    private Playable previousVideo = null;
	//Pointer on the last audio object
    private Playable previousAudio = null;
	//list of objects to play by this player
    private List<ObjectType> playList = new ArrayList<>();

	//Gets the current playing object 
	//if the object is nlkl then return the first objectb of the list
    public Playable currently_playing(){
        if(playingNow == null){
            playingNow = (Playable) playList.get(0);
        }
        return playingNow;
    }

	//prints the list of media in the list
    public void show_list(){
        playList.forEach(i -> ((Playable)i).info());
    }

	//this method removes an object from the media list
    public boolean remove(ObjectType toRemove){
        playList.remove(toRemove);
        if(previousVideo != null && previousVideo.equals(toRemove)){
            previousVideo = null;
        }
        if(previousAudio != null && previousAudio.equals(toRemove)){
            previousAudio = null;
        }
        if(playingNow.equals(toRemove)){
            return true;
        }

        return false;
    }

	//moves to next media based on type given in the parameter
    public void next(ObjectType obj){
        if(playList.isEmpty()){
            System.out.println("List is empty. Cannot go next!");
            return;
        }

		//searchn for elements after the index of the current element
		//if the current element is null then start over from the list
        for (int i = getIndexOfCurrent(); i < playList.size(); i++) {
            ObjectType type = playList.get(i);
			//audio is to add
            if(type instanceof Audio && obj instanceof Audio){
				//if the current media is audio or video then set previous accordingly
                if(playingNow instanceof Audio){
                    previousAudio = playingNow;
                }
                else if(playingNow instanceof Video){
                    previousVideo = playingNow;
                }
                playingNow = (Playable) playList.get(i);
            }
            else if(type instanceof Video && obj instanceof Video){
                if(playingNow instanceof Audio){
                    previousAudio = playingNow;
                }
                else if(playingNow instanceof Video){
                    previousVideo = playingNow;
                }
                playingNow = (Playable) playList.get(i);
            }
        }
    }

	//Gets the next index of current object
	//or 0 if the first index is null
    private int getIndexOfCurrent(){
        int index = 0;
        for(ObjectType type : playList){
            if(type.equals(playingNow)){
                return index + 1;
            }
            index++;
        }

        return 0;
    }

    public void previous(ObjectType prev){
        Playable temp = playingNow;
        if(prev instanceof Audio){
            playingNow = previousAudio;
        }
        else if(prev instanceof Video){
            playingNow = previousVideo;
        }

        if(temp instanceof Audio){
            previousAudio = temp;
        } else if (temp instanceof Video) {
            previousVideo = temp;
        }
    }

    public List<ObjectType> getPlayList() {
        return playList;
    }

    public Playable getPlayingNow() {
        return playingNow;
    }

    public Playable getPreviousAudio() {
        return previousAudio;
    }

    public Playable getPreviousVideo() {
        return previousVideo;
    }

    @Override
    public void update(ObjectType playOrViewObject) {
        playList.add(playOrViewObject);
    }
}
