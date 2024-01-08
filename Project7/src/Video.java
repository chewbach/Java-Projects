public class Video extends ObjectType implements Playable, Visual{
    private String videoName;
    private String videoDuration;
    private String videoInfo;

    public Video(String videoName, String videoDuration, String videoInfo) {
        this.videoName = videoName;
        this.videoDuration = videoDuration;
        this.videoInfo = videoInfo;
    }

    public String getVideoName() {
        return videoName;
    }

    public String getVideoDuration() {
        return videoDuration;
    }

    public String getVideoInfo() {
        return videoInfo;
    }

    @Override
    public void info() {
        System.out.println(videoName + ", " + videoDuration + ", " + videoInfo);
    }
}
