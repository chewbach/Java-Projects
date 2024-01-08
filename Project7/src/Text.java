public class Text extends ObjectType implements NonVisual, Non_playable {
    private String textName;
    private String textInfo;

    public Text(String textName, String textInfo) {
        this.textName = textName;
        this.textInfo = textInfo;
    }

    public String getTextName() {
        return textName;
    }

    public String getTextInfo() {
        return textInfo;
    }

    @Override
    public void info() {
        System.out.println(textName + ", " + textInfo);
    }
}
