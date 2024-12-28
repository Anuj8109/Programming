package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class MoneySums {
    public static void main(String[] args){
        FastReader fs = new FastReader();
        int n = fs.nextInt();
        int[] coins = new int[n];
        int totalSum = 0;
        for(int i=0;i<n;i++){
            coins[i] = fs.nextInt();
            totalSum +=  coins[i];
        }
        boolean[] prevSums = new boolean[totalSum + 1];
        ///TreeSet<Integer> prevSums = new TreeSet<>();
        prevSums[0] = true;
        for(int coin:coins){
            boolean[] currSums = prevSums.clone();
            // TreeSet<Integer> currSums = new TreeSet<>(prevSums);
            for(int i=0;i<=totalSum;i++){
                if(prevSums[i]) currSums[i + coin] = true;
            }
            prevSums = currSums;
        }
        //prevSums.remove(0);
        //System.out.println(prevSums.size());
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i=1;i<=totalSum;i++){
            if(prevSums[i]){
                count++;
                sb.append(" " + i);
            }
        }
        System.out.println(count);
        System.out.println(sb.toString().substring(1));
    }
    static class FastReader { BufferedReader br; StringTokenizer st; public FastReader() { br = new BufferedReader( new InputStreamReader(System.in)); } String next() { while (st == null || !st.hasMoreElements()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { e.printStackTrace(); } } return st.nextToken(); } int nextInt() { return Integer.parseInt(next()); } long nextLong() { return Long.parseLong(next()); } double nextDouble() { return Double.parseDouble(next()); } String nextLine() { String str = ""; try { if(st.hasMoreTokens()){ str = st.nextToken("\n"); } else{ str = br.readLine(); } } catch (IOException e) { e.printStackTrace(); } return str; } }

}
