package practice.dijkstra;

public class ShorttestPath {

	int V=9;
	public void dijkstra(int graph[][],int src) {
		int dist[] = new int[V];
		boolean sptSet[] = new boolean[V];
		
		for(int i=0;i<V;i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}
		
		dist[src]=0;
		
		for(int count=0;count<V;count++) {
			int u = minDistance(dist,sptSet);
			
			sptSet[u] = true;
			
			for(int i=0;i<V;i++) {
				if(!sptSet[i] && graph[u][i] != 0 && 
						dist[u] != Integer.MAX_VALUE &&
						dist[u]+graph[u][i] < dist[i] ) {
					dist[i] = dist[u]+graph[u][i];
				}
			}
		}
		printSolution(dist, V);
	}
	void printSolution(int dist[], int n) 
    { 
        System.out.println("Vertex   Distance from Source"); 
        for (int i = 0; i < V; i++) 
            System.out.println(i+" tt "+dist[i]); 
    } 
	public int minDistance(int dist[],boolean sptSet[]) {
		int min=Integer.MAX_VALUE,minIndex=-1;
		for(int i=0;i<V;i++) {
			if(sptSet[i] == false && dist[i]<=min) {
				min = dist[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
	public static void main(String[] args) {
		int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0}, 
            {4, 0, 8, 0, 0, 0, 0, 11, 0}, 
            {0, 8, 0, 7, 0, 4, 0, 0, 2}, 
            {0, 0, 7, 0, 9, 14, 0, 0, 0}, 
            {0, 0, 0, 9, 0, 10, 0, 0, 0}, 
            {0, 0, 4, 14, 10, 0, 2, 0, 0}, 
            {0, 0, 0, 0, 0, 2, 0, 1, 6}, 
            {8, 11, 0, 0, 0, 0, 1, 0, 7}, 
            {0, 0, 2, 0, 0, 0, 6, 7, 0} 
           }; 
		ShorttestPath t = new ShorttestPath();
        t.dijkstra(graph, 0); 
	}
}
