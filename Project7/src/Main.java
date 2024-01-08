public class Main {
    public static void main(String[] args) {
        Dataset ds = new Dataset();

        Player p1 = new Player();
        Player p2 = new Player();

        Viewer v1 = new Viewer();
        Viewer v2 = new Viewer();

        ds.register(p1);
        //ds.register(p2);
        ds.register(v1);
        //ds.register(v2);

        ds.add(new Image("imagename1", "2D", "other info1"));
        ds.add(new Image("imagename2", "3D", "other info2"));
        ds.add(new Image("imagename3", "2D", "other info3"));
        ds.add(new Image("imagename4", "3D", "other info4"));
        ds.add(new Image("imagename5", "4D", "other info5"));
        ds.add(new Audio("audioname1", "4.1", "other info1"));
        ds.add(new Audio("audioname2", "3.7", "other info2"));
        ds.add(new Audio("audioname3", "5.2", "other info3"));
        ds.add(new Video("videoname1", "6.8", "other info1"));
        ds.add(new Video("videoname2", "7.3", "other info2"));
        ds.add(new Video("videoname3", "9.4", "other info3"));
        ds.add(new Text("textname1", "other info1"));
        ds.add(new Text("textname2", "other info2"));
        ds.add(new Text("textname3", "other info3"));

        System.out.println("Objects in p1: " + p1.getPlayList().size());
        System.out.println("Objects in v1: " + v1.getPlayList().size());

        Playable po = p1.currently_playing();
        po.info();
        ds.remove((ObjectType) po);

        Non_playable np = v1.currently_viewing();
        np.info();
        ds.remove((ObjectType) np);

        System.out.println("Objects in p1: " + p1.getPlayList().size());
        System.out.println("Objects in v1: " + v1.getPlayList().size());

        //Get next text media
        v1.next(new Text(null, null));
        np = v1.currently_viewing();
        np.info();
        //go to next image
        v1.next(new Text(null, null));
        np = v1.currently_viewing();
        np.info();
        v1.next(new Text(null, null));
        np = v1.currently_viewing();
        np.info();
        v1.getPreviousImage().info();
        v1.getPreviousText().info();
    }
}
