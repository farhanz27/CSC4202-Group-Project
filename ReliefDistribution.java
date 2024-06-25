import java.util.*;

public class ReliefDistribution {

    public static void main(String[] args) {
        CityGraph cityGraph = new CityGraph();
        cityGraph.addEdge("Warehouse", "A", 5);
        cityGraph.addEdge("Warehouse", "B", 10);
        cityGraph.addEdge("Warehouse", "C", 8);
        cityGraph.addEdge("A", "B", 3);
        cityGraph.addEdge("B", "C", 2);
        cityGraph.addEdge("C", "D", 4);
        cityGraph.addEdge("C", "E", 5);
        cityGraph.addEdge("D", "E", 1);

        String startNode = "Warehouse";
        List<Route> mst = getMinimumSpanningTree(cityGraph, startNode);

        System.out.println("Minimum Spanning Tree (MST) edges:");
        for (Route route : mst) {
            System.out.println(route.source + " - " + route.destination + " with weight " + route.weight);
        }

        int totalWeight = mst.stream().mapToInt(route -> route.weight).sum();
        System.out.println("Total distance (time) to supply all zones: " + totalWeight);
    }

    private static List<Route> getMinimumSpanningTree(CityGraph cityGraph, String start) {
        List<Route> mst = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        PriorityQueue<Route> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

        visited.add(start);
        priorityQueue.addAll(cityGraph.getNeighbors(start));

        while (!priorityQueue.isEmpty()) {
            Route route = priorityQueue.poll();
            if (visited.contains(route.destination)) {
                continue;
            }
            visited.add(route.destination);
            mst.add(route);

            for (Route neighbor : cityGraph.getNeighbors(route.destination)) {
                if (!visited.contains(neighbor.destination)) {
                    priorityQueue.add(neighbor);
                }
            }
        }

        return mst;
    }
}

class CityGraph {
    private final Map<String, List<Route>> adjList = new HashMap<>();

    public void addEdge(String source, String destination, int weight) {
        adjList.putIfAbsent(source, new ArrayList<>());
        adjList.putIfAbsent(destination, new ArrayList<>());
        adjList.get(source).add(new Route(source, destination, weight));
        adjList.get(destination).add(new Route(destination, source, weight)); // For undirected graph
    }

    public List<Route> getNeighbors(String zone) {
        return adjList.get(zone);
    }

    public Set<String> getZones() {
        return adjList.keySet();
    }
}

class Route {
    String source;
    String destination;
    int weight;

    Route(String source, String destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}
