package DataStructure;

import java.util.Scanner;

public class P1546_AVG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long max = 0;
        long sum = 0;
        double avg = 0;

        for (int i = 0; i < N; i++) {
            int temp = sc.nextInt();
            if (temp > max) max = temp;
            sum = sum + temp;
        }
        avg = sum * 100.0 / max / N;

        System.out.println(avg);
    }
}
