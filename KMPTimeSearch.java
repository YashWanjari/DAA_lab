import java.util.*;

public class KMPTimeSearch {

    // Builds the LPS (Longest Prefix Suffix) array for the KMP algorithm
    private int[] buildLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int len = 0;
        int i = 1;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    // Searches for a pattern in the given text using KMP algorithm
    public boolean search(String text, String pattern) {
        if (pattern.isEmpty()) return true;

        text = text.toLowerCase();
        pattern = pattern.toLowerCase();

        int[] lps = buildLPS(pattern);
        int i = 0, j = 0;

        while (i < text.length()) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            if (j == pattern.length()) {
                return true; // Pattern found
            } else if (i < text.length() && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }
        return false;
    }

    // Search for bus stops matching user input pattern
    public List<String> searchStops(Graph_Bus graph, String query) {
        List<String> matches = new ArrayList<>();
        for (String stop : graph.getVertices().keySet()) {
            if (search(stop, query)) {
                matches.add(stop);
            }
        }
        return matches;
    }

    // Optional: Suggest next stop to visit based on partial search (time management idea)
    public void suggestStops(Graph_Bus graph, String query) {
        List<String> found = searchStops(graph, query);

        if (found.isEmpty()) {
            System.out.println(" No stops found matching: " + query);
        } else {
            System.out.println("\n Matching Stops:");
            for (String s : found) {
                System.out.println(" - " + s);
            }
        }
    }
}
