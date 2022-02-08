package Search;

import java.util.LinkedList;
import java.util.Queue;

import Model.Vertex;

public class BFS {
    public void bfs(Vertex root){
        Queue<Vertex> queue = new LinkedList<>();	// 탐색할 node 저장 
        root.visited = true;
        queue.offer(root);	

        StringBuilder sb = new StringBuilder();

        while(!queue.isEmpty()){
            Vertex current = queue.poll();
            sb.append(current.data).append(" ");

            for(Vertex v : current.adList){
                if(!v.visited){
                    queue.offer(v);
                    v.visited = true; // 방문 완료 처리
                }
            }
        }
        System.out.println(sb);
    }
}
