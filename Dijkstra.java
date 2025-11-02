import java.util.*;

public class Dijkstra {

    static class Pair implements Comparable<Pair> {
        String vertex;
        int cost;
        List<String> path;

        Pair(String v, int c, List<String> p) {
            vertex = v;
            cost = c;
            path = new ArrayList<>(p);
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    public static void findShortestPath(Graph_Bus graph, String source, String destination) {
        if (!graph.vtces.containsKey(source) || !graph.vtces.containsKey(destination)) {
            System.out.println("\n Invalid stop name entered!");
            return;
        }

        HashMap<String, Integer> dist = new HashMap<>();
        HashMap<String, Boolean> visited = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (String v : graph.vtces.keySet()) {
            dist.put(v, Integer.MAX_VALUE);
            visited.put(v, false);
        }

        dist.put(source, 0);
        pq.add(new Pair(source, 0, Arrays.asList(source)));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            if (visited.get(current.vertex)) continue;
            visited.put(current.vertex, true);

            if (current.vertex.equals(destination)) {
                displayResult(current);
                return;
            }

            Graph_Bus.Vertex vtx = graph.vtces.get(current.vertex);
            for (String nbr : vtx.nbrs.keySet()) {
                int newCost = current.cost + vtx.nbrs.get(nbr);
                if (newCost < dist.get(nbr)) {
                    dist.put(nbr, newCost);
                    List<String> newPath = new ArrayList<>(current.path);
                    newPath.add(nbr);
                    pq.add(new Pair(nbr, newCost, newPath));
                }
            }
        }

        // If no route found
        System.out.println("\n No valid route found between " + source + " and " + destination + ".");
        System.out.println("Please check if both stops are connected or spelled correctly.");
    }

    private static void displayResult(Pair result) {
        int distance = result.cost;

        if (distance == Integer.MAX_VALUE || result.path.isEmpty()) {
            System.out.println("\n No valid route found.");
            return;
        }

        double fare = calculateFare(distance);
        double speed = 24.0; // average city bus speed (km/h)
        int minutes = (int) Math.ceil((distance / speed) * 60);

        System.out.println("\n Shortest Route Found!");
        System.out.println(" Path: " + String.join(" → ", result.path));
        System.out.println(" Total Distance: " + distance + " km");
        System.out.printf(" Estimated Fare: ₹%.2f%n", fare);
        System.out.println(" Estimated Time: " + minutes + " minutes");
    }

    private static double calculateFare(int dist) {
        double fare;
        if (dist <= 2) fare = 12;
        else if (dist <= 4) fare = 15;
        else if (dist <= 6) fare = 20;
        else if (dist <= 10) fare = 28;
        else if (dist <= 16) fare = 38;
        else if (dist <= 22) fare = 48;
        else fare = 50 + (dist - 22) * 2;
        return Math.round(fare * 100.0) / 100.0;
    }
}
