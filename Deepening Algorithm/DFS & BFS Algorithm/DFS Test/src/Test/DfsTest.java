package Test;

import Search.DFS;

public class DfsTest {
	static boolean[] vistied = new boolean[9];
	static int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};
	
	public static void main(String[] args) {
		DFS dfs = new DFS();
		dfs.recursiveDFS(graph, vistied, 1);
	}
}
