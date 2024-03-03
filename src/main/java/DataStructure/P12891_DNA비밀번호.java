package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12891_DNA비밀번호 {
    static int myArr[];
    static int checkArr[];
    static int checkSecret;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int Result = 0;
        checkArr = new int[4];
        myArr = new int[4];
        char A[] = new char[S];

        checkSecret = 0; // 몇 개의 문자가 충족했는지 판단하는 변수

        A = bf.readLine().toCharArray(); // 전체 문자열
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken()); // A, C, G, T 몇 번 등장해야 하는지 입력 받기
            if (checkArr[i] == 0) { // 등장하지 않아도 되는 문자열이므로 1개 조건 덜 만족해도 됨
                checkSecret++;
            }
        }

        for (int i = 0; i < P; i++) { // 부분 문자열 처음 받을 때 세팅
            Add(A[i]);
        }
        if (checkSecret == 4) Result++;

        // 슬라이딩윈도우
        for (int i = P; i < S; i++) {
            int j = i - P;
            Add(A[i]);
            Remove(A[j]);
            if (checkSecret == 4) Result++;
        }
        System.out.println(Result);
        bf.close();
    }

    private static void Remove(char c) {
        switch (c) {
            case 'A':
                if (myArr[0] == checkArr[0]) checkSecret--;
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1] == checkArr[1]) checkSecret--;
                myArr[1]--;
                break;
            case 'G':
                if (myArr[2] == checkArr[2]) checkSecret--;
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == checkArr[3]) checkSecret--;
                myArr[3]--;
                break;
        }
    }

    private static void Add(char c) {
        switch (c) {
            case 'A':
                myArr[0]++;
                if (myArr[0] == checkArr[0]) checkSecret++;
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1]) checkSecret++;
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2]) checkSecret++;
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3]) checkSecret++;
                break;
        }
    }
}
