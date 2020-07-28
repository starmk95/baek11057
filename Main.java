import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mod = 10007;
        int[][] A = new int[n][10]; // A[i][j] = 길이가 i이고 마지막 숫자가 j인 오르막수의 개수
        // Bottom-Up 방식
        // 점화식 : A[i][j] = A[i-1][0] + A[i-1][1] + ... A[i-1][j]
        for (int i=0;i<10;i++) A[0][i] = 1;
        for (int i=1;i<n;i++) {
            for (int j=0;j<10;j++) {
                for (int l=0;l<=j;l++) {
                    A[i][j] += A[i-1][j-l];
                    A[i][j] %= mod;
                }
            }
        }
        int temp = A[n-1][0];
        for (int i=1;i<10;i++) {
            temp += A[n-1][i];
            temp %= mod;
        }
        System.out.println(temp);
    }
}
