import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }

        int min = nums[0];
        for (int num : nums) {
            min = num < min ? num : min;
        }

        System.out.println(min);
    }
}