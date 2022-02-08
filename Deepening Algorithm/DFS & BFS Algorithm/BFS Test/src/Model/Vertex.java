package Model;

import java.util.LinkedList;

public class Vertex{
    public char data;
    public boolean visited = false; // 정점 방문 여부 (Cycle 방지)

    // 인접 정점 리스트
    public LinkedList<Vertex> adList = new LinkedList<>();
    
    public Vertex(char data){
        this.data = data;
    }
}