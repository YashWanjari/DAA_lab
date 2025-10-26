import java.util.*;
public class LCS
{
    public static void print(String A, String B, int[][] l, char[][] dir) {
        int m = A.length();
        int n = B.length();

        System.out.println("Matrix :");
        System.out.print("         ");
        for (int j = 0; j < n; j++) {
            System.out.print("  " + B.charAt(j) + "  ");
        }
        System.out.println();

        for (int i = 0; i <= m; i++) {
            if (i == 0)
                System.out.print("   ");
            else
                System.out.print(" " + A.charAt(i - 1) + " ");

            for (int j = 0; j <= n; j++) {
                String val = String.valueOf(l[i][j]);
                char arrow = dir[i][j];

                if (i == 0 || j == 0) {
                    System.out.printf("%3s   ", val);
                } else {
                    System.out.printf("%2s%s  ", val, arrow);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    //Task - 1
    public static String lcs(String A, String B) {
        int m = A.length();
        int n = B.length();

        int[][] l = new int[m + 1][n + 1];
        char[][] dir = new char[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    l[i][j] = 0;
                    dir[i][j] = ' ';
                } else if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    l[i][j] = l[i - 1][j - 1] + 1;
                    dir[i][j] = 'd';
                } else {
                    if (l[i - 1][j] >= l[i][j - 1]) {
                        l[i][j] = l[i - 1][j];
                        dir[i][j] = 'u';
                    } else {
                        l[i][j] = l[i][j - 1];
                        dir[i][j] = 'h';
                    }
                }
            }
        }

        print(A, B, l, dir);

        int index = l[m][n];
        char[] lcsArr = new char[index];
        int i = m, j = n;

        while (i > 0 && j > 0) {
            if (A.charAt(i - 1) == B.charAt(j - 1)) {
                lcsArr[index - 1] = A.charAt(i - 1);
                i--;
                j--;
                index--;
            } else if (l[i - 1][j] >= l[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return new String(lcsArr);
    }
    //TASK-2
    public static String lrs(String S) {
        int n = S.length();

        int[][] l = new int[n + 1][n + 1];
        char[][] dir = new char[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    l[i][j] = 0;
                    dir[i][j] = ' ';
                } else if (S.charAt(i - 1) == S.charAt(j - 1) && i != j) {
                    l[i][j] = l[i - 1][j - 1] + 1;
                    dir[i][j] = 'd';
                } else {
                    if (l[i - 1][j] >= l[i][j - 1]) {
                        l[i][j] = l[i - 1][j];
                        dir[i][j] = 'u';
                    } else {
                        l[i][j] = l[i][j - 1];
                        dir[i][j] = 'h';
                    }
                }
            }
        }

        System.out.println("Longest Repeating Subsequence DP Matrix:");
        print(S, S, l, dir);

        int index = l[n][n];
        char[] lrsArr = new char[index];
        int i = n, j = n;

        while (i > 0 && j > 0) {
            if (S.charAt(i - 1) == S.charAt(j - 1) && i != j) {
                lrsArr[index - 1] = S.charAt(i - 1);
                i--;
                j--;
                index--;
            } else if (l[i - 1][j] >= l[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return new String(lrsArr);
    }

    public static void main(String[] args) {
        String A = "AGCCCTAAGGGCTACCTAGCTT";
        String B = "GACAGCCTACAAGCGTTAGCTTG";

        System.out.println("TASK-1: ");
        String lcsStr = lcs(A,B);
        System.out.println("Length of LCS: " + lcsStr.length());
        System.out.println("LCS sequence: " + lcsStr);
       
        System.out.println();

        System.out.println("TASK-2: Longest Repeating Subsequence of A");
        String lrsStr = lrs(A);
        System.out.println("Length of LRS: " + lrsStr.length());
        System.out.println("LRS sequence: " + lrsStr);
    }
}
