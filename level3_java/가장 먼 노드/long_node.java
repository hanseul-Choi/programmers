import java.util.*;

class Solution {
    public class Node {
        ArrayList<Node> adj;
        int v;
        int dir;
        
        Node(int v) {
            this.adj = new ArrayList<>();
            this.v = v;
            this.dir = 0;
        }
    }
    
    public Node[] node;
    public int[] visit; 
    public int max = 1;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        visit = new int[n+1];
        int edge_row = edge.length;
        node = new Node[n+1];
                
        for(int i=0; i<=n; i++) node[i] = new Node(i);
        
        for(int i=0; i<edge_row; i++) {
            node[edge[i][0]].adj.add(node[edge[i][1]]);
            node[edge[i][1]].adj.add(node[edge[i][0]]);
        }  
        
        bfs();
        
        for(int i=1; i<=n; i++) {
            if(max == node[i].dir) answer++;
        }
        
        return answer;
    }
    
    public void bfs() {
        Queue<Node> q = new LinkedList<>();        
        node[1].dir = 1;
        q.add(node[1]);
        
        while(!q.isEmpty()) {
            Node curNode = q.poll();
            
            for(Node adjNode: curNode.adj) {                
                if(adjNode.dir == 0) {
                    adjNode.dir = curNode.dir + 1;
                    if(max < adjNode.dir) max = adjNode.dir;
                    q.add(adjNode);
                }
            }
        }
    }
}