import java.util.ArrayDeque;
import java.util.Observable;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *  @author Josh Hug
 */

public class MazeBreadthFirstPaths extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private int s;
    private int t;
    private boolean targetFound = false;
    private Maze maze;

    public MazeBreadthFirstPaths(Maze m, int sourceX, int sourceY, int targetX, int targetY) {
        super(m);
        maze = m;
        s = maze.xyTo1D(sourceX, sourceY);
        t = maze.xyTo1D(targetX, targetY);
        distTo[s] = 0;
        edgeTo[s] = s;
    }

    /** Conducts a breadth first search of the maze starting at the source. */

    //single source bfs
    private void bfs() {
        Queue<Integer> q = new ArrayDeque<Integer>();
        for (int v = 0; v < maze.N() * maze.N(); v++){ //loop through all nodes in Maze
            distTo[v] = Integer.MAX_VALUE;
        }
        marked[s] = true;
        announce();
        if (v == t) {
            targetFound = true;
        }
        if (targetFound) {
            return;
        }

        distTo[s] = 0;
        q.add(s); //add s to Queue

        while (! q.isEmpty()) {
            int a = q.remove();
            for (int w : maze.adj(a)) {
                if (!marked[w]) {
                    edgeTo[w] = a;
                    distTo[w] = distTo[a] + 1; // +1 for every level
                    marked[w] = true;
                    q.add(w);
                    announce();

                    v++; //v is layers of BFS tree
                    System.out.println(v + " " + t);
                    if (w == t) {
                        System.out.println("hi2");
                        return;
                    }
                }
            }
        }
    }
    int v = 0;

    @Override
    public void solve() {
        bfs();
    }
}

