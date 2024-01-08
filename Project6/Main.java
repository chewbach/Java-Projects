package hw8;

public class Main {

    public static void main(String[] args) {


        CSE222Map Map = new CSE222Map("hw8/map01.txt",500,500);
        CSE222Graph Graph = new CSE222Graph(Map);
        CSE222Dijkstra Dijkstra = new CSE222Dijkstra(Graph);
        CSE222BFS BFS= new CSE222BFS (Graph);
        Map.convertPNG();
        //Map.drawLine(Dijkstra);
        Map.drawLine(BFS);




        //Map.writePath(Dijkstra);
        //Map.writePath(BFS);

        System.out.println("Dijkstra Path: "+ Dijkstra.length);
        System.out.println("BFS Path: "+ BFS.length);
    }

}
