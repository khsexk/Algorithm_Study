package Model;

public class Graph {
    private int v; // 정점의 개수
    
    public Graph(int v){
        this.v = v;
    }

    public void addEdge(Vertex s, Vertex d){
        s.adList.add(d);
        d.adList.add(s);
    }
}
