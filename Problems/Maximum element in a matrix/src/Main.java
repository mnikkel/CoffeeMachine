import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final var scan = new Scanner(System.in);
        final var n = scan.nextInt();
        final var m = scan.nextInt();
        int[][] array = new int[n][m];
        for (var i = 0; i < n; i++) {
            for (var j = 0; j < m; j++) {
                array[i][j] = scan.nextInt();
            }
        }
        var max = array[0][0];
        int[] index = {0, 0};
        for (var i = 0; i < n; i++) {
            for (var j = 0; j < m; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                    index[0] = i;
                    index[1] = j;
                }
            }
        }
        System.out.println(index[0] + " " + index[1]);
    }
}