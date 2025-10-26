public class OBST {
    public static void main(String[] args) {
        int n = 4;
        int[] keys = {10, 20, 30, 40};
        double[] p = {0.1, 0.2, 0.4, 0.3};
        double[] q = {0.05, 0.1, 0.05, 0.05, 0.1};

        double[][] w = new double[n + 2][n + 1];
        double[][] e = new double[n + 2][n + 1];
        int[][] r = new int[n + 2][n + 1];

        for (int i = 1; i <= n + 1; i++) {
            e[i][i - 1] = q[i - 1];
            w[i][i - 1] = q[i - 1];
        }

        for (int l = 1; l <= n; l++) {
            for (int i = 1; i <= n - l + 1; i++) {
                int j = i + l - 1;
                e[i][j] = Double.MAX_VALUE;
                w[i][j] = w[i][j - 1] + p[j - 1] + q[j];
                for (int k = i; k <= j; k++) {
                    double cost = e[i][k - 1] + e[k + 1][j] + w[i][j];
                    if (cost < e[i][j]) {
                        e[i][j] = cost;
                        r[i][j] = k;
                    }
                }
            }
        }
        System.out.printf("Minimum expected cost: %.4f\n", e[1][n]);
    }
}