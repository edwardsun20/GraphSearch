import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class GraphTest {

    @Test
    public void test1() {
        Graph g1 = new Graph(8);
        g1.addEdge(0, 1, 2);
        g1.addEdge(0, 2, 5);
        g1.addEdge(0, 3, 3);
        g1.addEdge(0, 6, 7);
        g1.addEdge(1, 3, 5);

        g1.addEdge(3, 6, 3);
        g1.addEdge(2, 4, 2);
        g1.addEdge(1, 4, 3);
        g1.addEdge(3, 4, 4);
        g1.addEdge(3, 7, 6);

        g1.addEdge(6, 7, 1);
        g1.addEdge(4, 7, 2);
        g1.addEdge(2, 5, 2);
        g1.addEdge(4, 5, 1);

        int [] expected = {0, 2, 5, 3, 5, 6, 6, 7};
        assertArrayEquals(expected, g1.dijkstras(0));
    }

    @Test
    public void test2() {
        Graph g1 = new Graph(5);
        g1.addEdge(0, 1, 1);
        g1.addEdge(0, 2, 4);
        g1.addEdge(0, 4, 1);
        g1.addEdge(1, 2, 1);
        g1.addEdge(2, 0, 1);
        g1.addEdge(2, 3, 1);
        g1.addEdge(4, 3, 3);

        int[] expected = {0, 1, 2, 3, 1};
        assertArrayEquals(expected, g1.dijkstras(0));
    }

    @Test
    public void test3() {
        Graph g2 = new Graph(5);
        g2.addEdge(0, 1, 1);
        g2.addEdge(0, 2, 1);
        g2.addEdge(2, 0, 1);
        g2.addEdge(0, 4, 1);
        g2.addEdge(1, 2, 1);
        g2.addEdge(2, 3, 1);
        g2.addEdge(4, 3, 1);

        int [] expected2 = {0, 1, 1, 2, 1};
        assertArrayEquals(expected2, g2.dijkstras(0));
    }

    public static void main(String[] args) {
        System.exit(ucb.junit.textui.runClasses(GraphTest.class));
    }
}
