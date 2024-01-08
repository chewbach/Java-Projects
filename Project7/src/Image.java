public class Image extends ObjectType implements Visual, Non_playable {
    private String imageName;
    private String dimensionInfo;
    private String imageInfo;

    public Image(String imageName, String dimensionInfo, String imageInfo) {
        this.imageName = imageName;
        this.dimensionInfo = dimensionInfo;
        this.imageInfo = imageInfo;
    }

    public String getDimensionInfo() {
        return dimensionInfo;
    }

    public String getImageInfo() {
        return imageInfo;
    }

    public String getImageName() {
        return imageName;
    }

    @Override
    public void info() {
        System.out.println(imageName + ", " + dimensionInfo + ", " + imageInfo);
    }
}
