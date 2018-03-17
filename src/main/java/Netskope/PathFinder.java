package Netskope;

import java.io.*;
import java.util.*;

public class PathFinder {

    /**
     * Tests the method parseFile with an example test-case.
     * This method is completely for your own testing and is NOT
     * called/used while grading your answer.
     */
    public static void main(String[] args)
            throws FileNotFoundException, IOException {
        String filename = "input_1.txt";
        if (args.length > 0) {
        	filename = args[0];
        }
        
        List<String> answer = parseFile(filename);
        System.out.println(answer);
    }
    
    static List<String> parseFile(String filename)
    		throws FileNotFoundException, IOException {
    	/*
    	 *  Don't modify this function
    	 */
        BufferedReader input = new BufferedReader(new FileReader(filename));
        List<String> allLines = new ArrayList<String>();
        String line;
        while ((line = input.readLine()) != null) {
        	allLines.add(line);
        }
        input.close();

        return parseLines(allLines);    	
    }

    /**
     * Represent Node in the graph.
     */
    private static class Node {
        String name;
        List<String> connection = new ArrayList<String>();

        public Node(String name) {
            this.name = name;
        }

        public void connect(String connect) {
            for(String neighbor: connect.split(" "))
                connection.add(neighbor);

        }
    }

    /**
     * Graph based on Node, and nodeMap
     */
   private static class Graph {
        /**
         * Map of nodes, with name as the key
         */
        private Map<String, Node> nodeMap = new HashMap<String, Node>();

        public Graph() {}

        /**
         * Add a node to the graph with the connections
         * @param nodeName - name of node
         * @param connections - connection
         */
        public void put(String nodeName, String connections) {
            if (!nodeMap.containsKey(nodeName))
                nodeMap.put(nodeName, new Node(nodeName));
            nodeMap.get(nodeName).connect(connections.trim());
        }

        /**
         * Get a node of the graph with the name key
         * @param nodeName
         * @return
         */
        public Node get(String nodeName) {
            return nodeMap.get(nodeName);
        }

        /**
         * Check if the a node exists with a given name/key
         * @param nodeName
         * @return
         */
        public boolean contains(String nodeName) {
            return nodeMap.containsKey(nodeName);
        }

    }

    /**
     * TraversalPath through a graph
     */
    private static class TraversalPath {
        Node node;
        List<String> path = new ArrayList<String>();

        /**
         * TraversalPath to traverse from a existing traversal to neighbouring Node n
         * @param t
         * @param n
         */
        public TraversalPath(TraversalPath t, Node n) {
            this.node = n;
            path = new ArrayList<String>(t.path);
            path.add(n.name);
        }

        /**
         * Start a new Traversal from Node n
         * @param n
         */
        public TraversalPath(Node n) {
            node = n;
            path.add(n.name);
        }

        /**
         * Return try if nodeName has been visited by this TraversalPath
         * @param nodeName
         * @return
         */
        public boolean hasVisited(String nodeName) {
            return path.contains(nodeName);
        }

        /**
         * Get path ie. if we traversed from node A to B to C to D return value is "ABCD"
         * @return
         */
        public String getPath() {
            StringBuffer pathString = new StringBuffer();

            for(String p: path) {
                pathString.append(p);
            }
            return pathString.toString();
        }

    }

    static List<String> parseLines(List<String> lines) {
        Graph graph = new Graph();

        // need at least 2 lines to have meaningful paths
        if (lines.size() < 2)
            return new ArrayList<String>();

        ListIterator<String> it = lines.listIterator();
        String[] startEnd = it.next().split(" ");
        String start = startEnd[0];
        String end = startEnd[1];

        // must have start & end node names in the first line
        if (startEnd.length != 2)
            return new ArrayList<String>();

        while (it.hasNext()) {
            String[] nodeGraph = it.next().split(":");
            graph.put(nodeGraph[0].trim(), nodeGraph[1].trim());
        }

    	return getPaths(graph, start, end);
    }

    /**
     *
     * Return all the possible paths from the start node to the end node. The paths should not contains cycles.
     * The paths can be output in any order. If there are no possible paths, return an empty list.
     * E.g. the path "start from node A, travel to node C, travel to node D, end at node F" would
     * be represented by the string  "ACDF".
     *
     * Implemented iteratively - no recursion. Using DFS
     *
     * @param graph
     * @param start
     * @param end
     * @return a list of paths wth all cycles excluded
     */
    static List<String> getPaths(Graph graph, String start, String end) {
        // traversal contains all possible paths as we explore graph from 'start' node
        Stack<TraversalPath> traversal = new Stack<TraversalPath>();
        traversal.push(new TraversalPath(graph.get(start)));

        // A completed path to 'end' is added to this collection
        List<String> paths = new ArrayList<String>();

        while (!traversal.isEmpty()) {
           TraversalPath cur = traversal.pop();

           // Explore all connection of cur.node
           for (String neighbor: cur.node.connection) {

               // drop cur if a loop detected
               if (cur.hasVisited(neighbor))
                   continue;

               // add to 'paths' if at the end
               if (neighbor.equals(end))
                   paths.add(cur.getPath() + end);

               // Update traversal for this node
               else if (graph.contains(neighbor))
                    traversal.add(new TraversalPath(cur, graph.get(neighbor)));
           }
        }

        return paths;
    }
}