package CSES;
import java.util.Scanner;

public class DiceCombinations {
    static final int mod = 1_000_000_000 + 7;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n  = scanner.nextInt();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=6;j++){
                if(i - j >= 0) dp[i] = (dp[i] + dp[i - j]) % mod;
                else break;
                //System.out.println(dp[i] + " " + i);
            }
        }
        System.out.println(dp[n]);
    }
}
