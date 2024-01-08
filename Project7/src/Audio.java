public class Audio extends ObjectType implements Playable, NonVisual{
    private String audioName;
    private String durationInfo;
    private String audioInfo;

    public Audio(String audioName, String durationInfo, String audioInfo) {
        this.audioName = audioName;
        this.durationInfo = durationInfo;
        this.audioInfo = audioInfo;
    }

    public String getAudioName() {
        return audioName;
    }

    public String getDurationInfo() {
        return durationInfo;
    }

    public String getAudioInfo() {
        return audioInfo;
    }

    @Override
    public void info() {
        System.out.println(audioName + ", " + durationInfo + ", " + audioInfo);
    }
}
