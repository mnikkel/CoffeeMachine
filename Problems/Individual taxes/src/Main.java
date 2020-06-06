import java.util.*;

public class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] incomes = new int[n];
        int[] rates = new int[n];

        for (int i = 0; i < n; i++) {
            incomes[i] = scan.nextInt();
        }

        for (int i = 0; i < n; i++) {
            rates[i] = scan.nextInt();
        }

        int max = 0;
        int company = -1;
        for (int i = 0; i < n; i++) {
            int tax = incomes[i] * rates[i];
            if (tax > max) {
                max = tax;
                company = i;
            }
        }

        System.out.println(company + 1);

    }
}