import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] nums = new int[n][n];
        for (var i = 0; i < n; i++) {
            for (var j = 0; j < n; j++) {
                nums[i][j] = scan.nextInt();
            }
        }

        boolean symmetric = true;
        for (var i = 0; i < n; i++) {
            for (var j = 0; j < n; j++) {
                if (nums[i][j] != nums[j][i]) {
                    symmetric = false;
                    break;
                }
            }
        }
        var msg = symmetric ? "YES" : "NO";
        System.out.println(msg);

    }
}