package Search;

public class DFS {
	public void recursiveDFS(int[][] graph, boolean[] visited, int root) {
		// 방문 처리
		visited[root] = true;
		// 방문 노드 출력
		System.out.print(root + " -> ");
		// 방문한 노드에 인접한 노드 찾기
		for (int node : graph[root]) {
			// 인접한 노드가 방문한 적이 없다면 DFS 수행
			if(!visited[node]) {
				recursiveDFS(graph, visited, node);
			}
		}

	}
}
