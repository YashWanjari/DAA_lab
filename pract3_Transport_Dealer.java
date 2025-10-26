class Box {

    int weight;

    int profit;

    double ratio;

 

    Box(int w, int p) {

        this.weight = w;

        this.profit = p;

        this.ratio = (double) p / w;

    }

}

 

public class TransportDealer {

    static double knapsack(List<Box> boxes, int capacity) {

        double totalProfit = 0.0;

        for (int i = 0; i < boxes.size(); i++) {

            Box box = boxes.get(i);

            if (capacity <= 0) break;

 

            if (box.weight == 0) {

                totalProfit += box.profit;

            } else if (box.weight <= capacity) {

                totalProfit += box.profit;

                capacity -= box.weight;

            } else {

                totalProfit += box.profit * ((double) capacity / box.weight);

                capacity = 0;

            }

        }

        return totalProfit;

    }

 

    public static void main(String[] args) {

        int capacity = 850;

        int[] weights = {7,0,30,22,80,94,11,81,70,64,59,18,0,36,3,8,15,42,9,0,42,47,52,32,26,48,55,6,29,84,2,4,18,56,7,29,93,44,71,3,86,66,31,65,0,79,20,65,52,13};

        int[] profits = {360,83,59,130,431,67,230,52,93,125,670,892,600,38,48,147,78,256,63,17,120,164,432,35,92,110,22,42,50,323,514,28,87,73,78,15,26,78,210,36,85,189,274,43,33,10,19,389,276,312};

 

        List<Box> boxes = new ArrayList<>();

        for (int i = 0; i < weights.length; i++) {

            boxes.add(new Box(weights[i], profits[i]));

        }

        long start,end;

        double profit;

 

        // Profit/Weight Ratio

        List<Box> ratioList = new ArrayList<>(boxes);

        ratioList.sort((a, b) -> Double.compare(b.ratio, a.ratio));

        start = System.nanoTime();

        profit = knapsack(ratioList, capacity);

        end = System.nanoTime();

        System.out.println("Profit/weight ratio - profit: " + profit);

        System.out.println("Time: " + (end - start) + " nanosecs\n");

 

        // Maximum Profit

        List<Box> maxProfitList = new ArrayList<>(boxes);

        maxProfitList.sort((a, b) -> b.profit - a.profit);

        start = System.nanoTime();

        profit = knapsack(maxProfitList, capacity);

        end = System.nanoTime();

        System.out.println("Maximum profit - profit: " + profit);

        System.out.println("Time: " + (end - start) + " nanosecs\n");

 

 

        // Minimum Weight

        List<Box> minWeightList = new ArrayList<>(boxes);

        minWeightList.sort(Comparator.comparingInt(b -> b.weight));

        start = System.nanoTime();

        profit = knapsack(minWeightList, capacity);

        end = System.nanoTime();

        System.out.println("Minimum weight - profit: " + profit);

        System.out.println("Time: " + (end - start) + " nanosecs");

    }

}