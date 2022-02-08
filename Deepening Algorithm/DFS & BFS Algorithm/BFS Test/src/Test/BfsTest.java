package Test;

import Model.Graph;
import Model.Vertex;
import Search.BFS;

public class BfsTest {
	public static void main(String[] args) {
		Vertex v1 = new Vertex('A');
        Vertex v2 = new Vertex('B');
        Vertex v3 = new Vertex('C');
        Vertex v4 = new Vertex('D');
        Vertex v5 = new Vertex('E');
        Vertex v6 = new Vertex('F');
        Vertex v7 = new Vertex('G');
        Vertex v8 = new Vertex('H');

        Graph graph = new Graph(8);
        graph.addEdge(v1, v2); // A - B 연결
        graph.addEdge(v1, v3); // A - C 연결
        graph.addEdge(v2, v4); // B - D 연결
        graph.addEdge(v2, v5); // B - E 연결
        graph.addEdge(v3, v6); // C - F 연결
        graph.addEdge(v3, v7); // C - G 연결
        graph.addEdge(v5, v6); // E - F 연결
        graph.addEdge(v5, v8); // E - H 연결
        graph.addEdge(v6, v7); // F - G 연결

        BFS bfs = new BFS();
        
        bfs.bfs(v1);

	}

}
