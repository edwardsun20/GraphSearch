import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Observable;
import java.util.Queue;

/**
 *  @author Josh Hug
 */

public class MazeCycles extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */

    public MazeCycles(Maze m) {
        super(m);
    }

    private boolean cycleFound = false;
    private int cyclePoint = 0;
    private boolean draw = true;

    @Override
    public void solve() {
        //distTo[0] = 0;
        edgeTo[0] = 0;
        dfs(0, 0);
        // TODO: Your code here!
    }

    private void dfs(int v, int from) {
        marked[v] = true;
        announce();

        if (cycleFound) {
            return;
        }

        for (int w : maze.adj(v)) {
            if (!marked[w]) {
 //               edgeTo[w] = v;
                //distTo[w] = distTo[v] + 1;
                announce();
                dfs(w, v);
                if (cycleFound) {
                    if (cyclePoint == w ) {
                        draw = false;
                    }
                    if (draw)
                        edgeTo[w] = v;
                    announce();
                    return;
                }
            } else if (w != from){
                cyclePoint = w;
                if (draw)
                    edgeTo[w] = v;
                announce();
                cycleFound = true;
                return;
            }
        }
    }



//        HashMap<Integer, Integer> visited = new HashMap<>();
//
//        Queue<Integer> q = new ArrayDeque<Integer>();
//        for (int v = 0; v < maze.N() * maze.N(); v++){ //loop through all nodes in Maze
//            distTo[v] = Integer.MAX_VALUE;
//        }
//        marked[0] = true;
//        announce();
//
//        distTo[0] = 0;
//        q.add(0); //add 0, starting point to Queue
//
//        while (! q.isEmpty()) {
//            int a = q.remove();
//            for (int w : maze.adj(a)) {
//                if (!marked[w]) {
//                    edgeTo[w] = a;
//                    distTo[w] = distTo[a] + 1; // +1 for every level
//                    marked[w] = true;
//                    q.add(w);
//                    v++; //v is layers of BFS tree
//                    if ( ! visited.containsKey(w)) {
//                        visited.put(w, w);
//                    } else {
//                        announce(); // if it's already in visited, add it to the things to display
//                    }
//                }
//            }
//        }

}