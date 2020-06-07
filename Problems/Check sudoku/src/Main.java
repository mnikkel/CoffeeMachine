import java.util.*;

public class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        int[][] table = new int[n * n][n * n];

        for (int i = 0; i < n * n; i++) {
            var split = scan.nextLine().split(" ");
            for (int j = 0; j < n * n; j++) {
                table[i][j] = Integer.parseInt(split[j]);
            }
        }
        boolean valid = tableCheck(table, n);
        if (valid) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
    static boolean tableCheck(int[][] table, int n) {
        for (int[] row : table) {
            boolean validRow = rowCheck(row);
            if (!validRow) {
                return false;
            }
        }

        int[][] columns = new int[n*n][n*n];
        for (int i = 0; i < n*n; i++) {
            for (int j = 0; j < n*n; j++) {
                columns[i][j] = table[j][i];
            }
        }

        for (int[] row : columns) {
            boolean validRow = rowCheck(row);
            if (!validRow) {
                return false;
            }
        }
        int[][] boxes = new int[n*n][n*n];
        for (var i = 0; i < n*n; i++) {
            var x = (i * n) % (n*n);
            var y = ((i * n) / (n*n)) * n;
            var pos = 0;
            for (int q = y; q < y + n; q++) {
                for (int r = x; r < x + n; r++) {
                    boxes[i][pos] = table[q][r];
                    pos++;
                }
            }
        }
        for (int[] row : boxes) {
            boolean validRow = rowCheck(row);
            if (!validRow) {
                return false;
            }
        }
        return true;
    }

    static boolean rowCheck(int[] row) {
        for (var i = 0; i < row.length; i++) {
            if (row[i] < 1 || row[i] > row.length) {
                return false;
            }
            for (var j = i + 1; j < row.length; j++) {
                if (row[i] == row[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}