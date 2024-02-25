package DataStructure;

import java.util.Scanner;

/**
 * 첫째 줄에 숫자의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄에 숫자 N개가 공백없이 주어진다.
 * 숫자의 개수를 N에 int형으로 입력 받기
 * 숫자 N개를 sNum에 String형으로 입력 받기
 * sNum을 toCharArray 이용해서 char[] 형 배열로 바꾸기
 * sum 변수 선언 및 초기화 하기
 * for(cNum의 길이 만큼)
 * {
 * sum에 숫자 누적시키기
 * }
 * sum 춝력하기
 */
public class P11720_SUM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String sNum = sc.next();
        char[] cNum = sNum.toCharArray();
        int sum = 0;
        for (int i = 0; i < cNum.length; i++) {
            sum += cNum[i] - '0';
        }
        System.out.print(sum);
    }
}
