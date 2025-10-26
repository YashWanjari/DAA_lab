import java.util.*;
class Activity {
    int start, finish, profit;
    String name;

    Activity(int s, int f, int p, String n) {
        start = s;
        finish = f;
        profit = p;
        name = n;
    }
}

public class ActivitySelection {
    static void sortByFinishTime(Activity[] activities) {
        for (int i = 0; i < activities.length - 1; i++) {
            for (int j = 0; j < activities.length - i - 1; j++) {
                if (activities[j].finish > activities[j + 1].finish) {
                    Activity temp = activities[j];
                    activities[j] = activities[j + 1];
                    activities[j + 1] = temp;
                }
            }
        }
    }
   
    static void sortByStartTime(Activity[] activities) {
        for (int i = 0; i < activities.length - 1; i++) {
            for (int j = 0; j < activities.length - i - 1; j++) {
                if (activities[j].start > activities[j + 1].start) {
                    Activity temp = activities[j];
                    activities[j] = activities[j + 1];
                    activities[j + 1] = temp;
                }
            }
        }
    }

    static void printSelection(Activity[] activities) {
        int totalProfit=0;
        System.out.println("Selected Activities:");

        System.out.println("Activity " + activities[0].name +
                ", Start: " + activities[0].start +
                ", Finish: " + activities[0].finish +
                ", Profit: " + activities[0].profit);
        totalProfit += activities[0].profit;
        int lastFinishTime = activities[0].finish;

        for (int i = 1; i < activities.length; i++) {
            if (activities[i].start >= lastFinishTime) {
                System.out.println("Activity: " + activities[i].name);
                totalProfit += activities[i].profit;
                lastFinishTime = activities[i].finish;
            }
        }
        System.out.println("Total Profit: " + totalProfit);
    }

    static void activitySelection(Activity[] activities) {
        sortByFinishTime(activities);
        printSelection(activities);

        sortByStartTime(activities);
        printSelection(activities);
    }

    public static void main(String args[]) {
        Activity[] activities = {
            new Activity(1, 4, 10, "A1"),
            new Activity(3, 5, 15, "A2"),
            new Activity(0, 6, 14, "A3"),
            new Activity(5, 7, 12, "A4"),
            new Activity(3, 9, 20, "A5"),
            new Activity(5, 9, 30, "A6"),
            new Activity(6, 10, 32, "A7"),
            new Activity(8, 11, 28, "A8"),
            new Activity(8, 12, 30, "A9"),
            new Activity(2, 14, 40, "A10"),
            new Activity(12, 16, 45, "A11")
        };
        activitySelection(activities);
    }
}
