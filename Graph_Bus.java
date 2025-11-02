import java.util.*;

public class Graph_Bus {

    class Vertex {
        HashMap<String, Integer> nbrs = new HashMap<>();
    }

    HashMap<String, Vertex> vtces = new HashMap<>();

    public void addStop(String name) {
        if (!vtces.containsKey(name)) vtces.put(name, new Vertex());
    }

    public void addRoute(String src, String dst, int dist) {
        if (!vtces.containsKey(src) || !vtces.containsKey(dst)) return;
        vtces.get(src).nbrs.put(dst,dist);
        vtces.get(dst).nbrs.put(src,dist);
    }

    // Create a simplified demo network (you can expand it)
    public void Create_Nagpur_Bus_Map() {
        addStop("Sitabuldi");
        addStop("Nagpur Railway Station");
        addStop("Zero Mile");
        addStop("Kasturchand Park");
        addStop("Sadar");
        addStop("Cotton Market");
        addStop("Haldwani Complex");
        addStop("Civil Lines");
        addStop("Temple Chowk");
        addStop("Jail Road");
        addStop("Wardha Road Junction");
        addStop("Dharampeth");
        addStop("Lakadganj");
        addStop("Mayo Hospital");
        addStop("Orange City Hospital");
        addStop("IGMC_Hospital");
        addStop("Shankar Nagar");
        addStop("Ambazari");
        addStop("Bharat Nagar");
        addStop("IT Park");
        addStop("Automotive Square");
        addStop("Sonegaon");
        addStop("Airport");
        addStop("MIHAN");
        addStop("Butibori");
        addStop("Koradi");
        addStop("Gittikhadan");
        addStop("Hingna");
        addStop("Kamptee");
        addStop("Reshim Bagh");
        addStop("Ramdaspeth");
        addStop("Sitabuldi Bus Stand");
        addStop("Mankapur");
        addStop("Gandhibagh");
        addStop("Bhonsala");
        addStop("Sakchi");
        addStop("Nandanvan");
        addStop("Mankapur Square");
        addStop("Civil Hospital");
        addStop("Rashtrabhasha Bhavan");
         addStop("Rashtrabhasha Bhavan");
        addStop("Gaddigodam Square");
        addStop("Kamptee Road");
        addStop("Jaitala");
        addStop("Wardhaman Nagar");
        addStop("Rachana Ring Road");
        addStop("Bansi Nagar");
        addStop("Lokmanya Nagar");
        addStop("Govind Nagar");
        addStop("Sakharam Nagar");
        addStop("Mankapur Bus Stand");
        addStop("Civil Lines Bus Stand");
        addStop("IT Hub");
        addStop("Wockhardt Hosp");
        addStop("Orange City Mall");
        addStop("Sadasivpet");
        addStop("Fule Market");

        // (same addRoute section)
        addRoute("Sitabuldi", "Nagpur Railway Station", 2);
        addRoute("Sitabuldi", "Zero Mile", 1);
        addRoute("Zero Mile", "Kasturchand Park", 1);
         addRoute("Kasturchand Park", "Cotton Market", 1);
        addRoute("Cotton Market", "Sadar", 2);
        addRoute("Sadar", "Haldwani Complex", 2);

        addRoute("Sitabuldi", "Dharampeth", 3);
        addRoute("Dharampeth", "Lakadganj", 1);
        addRoute("Lakadganj", "Mayo Hospital", 1);
        addRoute("Mayo Hospital", "IGMC_Hospital", 2);
        addRoute("IGMC_Hospital", "Orange City Hospital", 2);

        addRoute("Dharampeth", "Shankar Nagar", 2);
        addRoute("Shankar Nagar", "Ambazari", 3);
        addRoute("Ambazari", "Bharat Nagar", 2);
        addRoute("Bharat Nagar", "IT Park", 3);
        addRoute("IT Park", "Automotive Square", 4);
        addRoute("Automotive Square", "Kamptee", 7);

        addRoute("Sonegaon", "Airport", 3);
        addRoute("Nagpur Railway Station", "Reshim Bagh", 3);
        addRoute("Reshim Bagh", "Ramdaspeth", 2);
        addRoute("Ramdaspeth", "Sitabuldi Bus Stand", 2);
         addRoute("IT Park", "MIHAN", 10);
        addRoute("MIHAN", "Butibori", 18);
        addRoute("Butibori", "Hingna", 12);
        addRoute("Hingna", "Kamptee", 15);
        addRoute("Koradi", "Gittikhadan", 6);
        addRoute("Koradi", "Butibori", 9);
        addRoute("Nagpur Railway Station", "Mankapur", 3);
        addRoute("Mankapur", "Gandhibagh", 2);
        addRoute("Gandhibagh", "Mankapur Square", 2);
        addRoute("Mankapur Square", "Bhonsala", 4);
        addRoute("Zero Mile", "Civil Lines", 2);
        addRoute("Civil Lines", "Civil Lines Bus Stand", 1);
        addRoute("Civil Lines", "Rashtrabhasha Bhavan", 2);
        addRoute("Rashtrabhasha Bhavan", "Gaddigodam Square", 3);
        addRoute("Gaddigodam Square", "Kamptee Road", 4);
        addRoute("Kamptee Road", "Jaitala", 6);
        addRoute("Jaitala", "Wardhaman Nagar", 5);
        addRoute("Shankar Nagar", "Rachana Ring Road", 4);
        addRoute("Rachana Ring Road", "Bansi Nagar", 3);
        addRoute("Bansi Nagar", "Lokmanya Nagar", 2);
        addRoute("Lokmanya Nagar", "Govind Nagar", 3);
        addRoute("Govind Nagar", "Sakharam Nagar", 2);
        addRoute("Sitabuldi", "Reshim Bagh", 3);
        addRoute("Zero Mile", "Nagpur Railway Station", 1);
        addRoute("Sadar", "Automotive Square", 6);
        addRoute("Ambazari", "Automotive Square", 6);
        addRoute("Airport", "Automotive Square", 8);
        addRoute("Airport", "Nagpur Railway Station", 7);
        addRoute("Orange City Mall", "Kasturchand Park", 2);
        addRoute("Orange City Mall", "IT Hub", 4);
        addRoute("Wockhardt Hosp", "Ramdaspeth", 2);
        addRoute("Wockhardt Hosp", "Mayo Hospital", 3);
        addRoute("MIHAN", "Airport", 6);
         addRoute("MIHAN", "Gittikhadan", 7);
        addRoute("Sadar", "Mankapur", 4);
        addRoute("Butibori", "Kamptee", 20);
        addRoute("Kamptee", "Kamptee Road", 3);
        addRoute("Fule Market", "Cotton Market", 2);
        addRoute("Fule Market", "Sadar", 3);
        addRoute("Haldwani Complex", "Cotton Market", 2);
        addRoute("Civil Hospital", "Mayo Hospital", 1);
        addRoute("Wardha Road Junction", "Reshim Bagh", 3);
        addRoute("Gaddigodam Square", "Automotive Square", 5);
        addRoute("Sitabuldi Bus Stand", "Sitabuldi", 1);
        addRoute("Mankapur Bus Stand", "Mankapur", 1);
        addRoute("IT Hub", "IT Park", 1);
        addRoute("Orange City Mall", "Zero Mile", 2);
        addRoute("Kasturchand Park", "Rashtrabhasha Bhavan", 2);
    }

    public HashMap<String, Vertex> getVertices() {
        return vtces;
    }
}
