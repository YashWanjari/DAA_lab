import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Graph_Bus graph = new Graph_Bus();
        graph.Create_Nagpur_Bus_Map();
        KMPTimeSearch kmp = new KMPTimeSearch();
        Scanner sc = new Scanner(System.in);

        System.out.println(" Welcome to Nagpur Bus Route System \n");

        int choice;
        do {
            System.out.println("===========================================");
            System.out.println("1️  Find Shortest Route (Dijkstra)");
            System.out.println("2️  Find Minimum Road Cost Network (Prim’s MST)");
            System.out.println("3️  Search Bus Stop by Name (KMP Algorithm)");
            System.out.println("4️  Exit");
            System.out.println("===========================================");
            System.out.print("Enter your choice (1–4): ");

            while (!sc.hasNextInt()) {
                System.out.print(" Please enter a valid number (1–4): ");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1: {
                    System.out.println("\n Available Stops:");
                  

                    System.out.print("\nEnter Source Stop: ");
                    String src = sc.nextLine().trim();

                    System.out.print("Enter Destination Stop: ");
                    String dest = sc.nextLine().trim();

                    if (!graph.getVertices().containsKey(src) || !graph.getVertices().containsKey(dest)) {
                        System.out.println(" Invalid stop name. Please try again.\n");
                    } else {
                        Dijkstra.findShortestPath(graph, src, dest);
                    }
                    break;
                }

                case 2: {
                    System.out.println("\n  Finding Minimum Road Cost Network using Prim’s Algorithm...\n");
                    PrimMST.minimumRoadCost(graph);
                    break;
                }

                case 3: {
                    System.out.print("\n Enter part of stop name to search: ");
                    String pattern = sc.nextLine().trim();
                    kmp.suggestStops(graph, pattern);
                    break;
                }

                case 4:
                    System.out.println("\n Thank you for using Nagpur Bus Route System! Have a safe journey.\n");
                    break;

                default:
                    System.out.println("\n Invalid choice! Please enter a number between 1-4.\n");
                    break;
            }

        } while (choice != 4);

        sc.close();
    }
}
