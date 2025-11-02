import java.util.*;

public class PrimMST {

    static class Pair implements Comparable<Pair> {
        String vname;
        String path;
        int cost;

        Pair(String v, String p, int c) {
            vname = v;
            path = p;
            cost = c;
        }

        public int compareTo(Pair o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void minimumRoadCost(Graph_Bus graph) {
        HashMap<String, Graph_Bus.Vertex> vtces = graph.getVertices();
        if (vtces.isEmpty()) return;

        HashSet<String> visited = new HashSet<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        String start = vtces.keySet().iterator().next();

        pq.add(new Pair(start, start, 0));
        int totalCost = 0;
        ArrayList<String> mstEdges = new ArrayList<>();

        while (!pq.isEmpty()) {
            Pair rp = pq.poll();
            if (visited.contains(rp.vname)) continue;

            visited.add(rp.vname);
            totalCost += rp.cost;
            if (!rp.path.equals(rp.vname))
                mstEdges.add(rp.path + " - " + rp.vname + " (" + rp.cost + " km)");

            for (String nbr : vtces.get(rp.vname).nbrs.keySet()) {
                if (!visited.contains(nbr)) {
                    pq.add(new Pair(nbr, rp.vname, vtces.get(rp.vname).nbrs.get(nbr)));
                }
            }
        }

        System.out.println("\n🏗️ Minimum Road Cost Network (Prim’s MST):");
        for (String edge : mstEdges)
            System.out.println("   • " + edge);
        System.out.println(" Total Road Distance: " + totalCost + " km\n");
    }
}
