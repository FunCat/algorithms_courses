package graphs;

import graphs.utils.Edge;
import graphs.utils.UndirectedGraph;
import graphs.utils.Vertex;

public class DFS {
    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph(7);
        graph.addEdge(new Edge(new Vertex(0), new Vertex(1)));
        graph.addEdge(new Edge(new Vertex(0), new Vertex(2)));
        graph.addEdge(new Edge(new Vertex(1), new Vertex(2)));
        graph.addEdge(new Edge(new Vertex(2), new Vertex(5)));
        graph.addEdge(new Edge(new Vertex(2), new Vertex(6)));
        graph.addEdge(new Edge(new Vertex(1), new Vertex(3)));
        graph.addEdge(new Edge(new Vertex(1), new Vertex(4)));
        graph.dfs(new Vertex(0));
    }
}
