import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }

        boolean sorted = true;
        for (int i = 1; i < n; i++) {
            if (array[i] < array[i - 1]) {
                sorted = false;
                break;
            }
        }

        System.out.println(sorted);
    }
}