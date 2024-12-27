package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ArrayDescription {
    public static void main(String[] args){
        FastReader fs = new FastReader();
        int n = fs.nextInt();
        int m = fs.nextInt();
        int[] arrays = new int[n];
        for(int i=0;i<n;i++){
            arrays[i] = fs.nextInt();
        }

        long[] prev = new long[m + 1];
        int mod = 1_000_000_000 + 7;
        //Arrays.fill(prev, 1);
        if(arrays[0] >= 1 && arrays[0] <= m){
            prev[arrays[0]] = 1;
        }else{
            Arrays.fill(prev, 1);
            prev[0] = 0;
        }

        for(int i=1;i<n;i++){
            long[] curr = new long[m + 1];
            
            if(arrays[i] >= 1 && arrays[i] <= m){
                curr[arrays[i]] = prev[arrays[i]];
                if(arrays[i] - 1 > 0) curr[arrays[i]] += prev[arrays[i] - 1];
                if(arrays[i] + 1 <= m) curr[arrays[i]] += prev[arrays[i] + 1];
                curr[arrays[i]] = curr[arrays[i]] % mod;
            }else{
                for(int j=1;j<=m;j++){
                    curr[j] = prev[j];
                    if(j > 1) curr[j] += prev[j-1];
                    if(j + 1 <= m) curr[j] += prev[j+1];
                    curr[j] = curr[j] % mod;
                }
            }
            prev = curr;
        }

        Long result = 0l;
        for(long t:prev){
            result = (result + t)%mod;
        }
        System.out.println(result);

    }
        static class FastReader { BufferedReader br; StringTokenizer st; public FastReader() { br = new BufferedReader( new InputStreamReader(System.in)); } String next() { while (st == null || !st.hasMoreElements()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { e.printStackTrace(); } } return st.nextToken(); } int nextInt() { return Integer.parseInt(next()); } long nextLong() { return Long.parseLong(next()); } double nextDouble() { return Double.parseDouble(next()); } String nextLine() { String str = ""; try { if(st.hasMoreTokens()){ str = st.nextToken("\n"); } else{ str = br.readLine(); } } catch (IOException e) { e.printStackTrace(); } return str; } }

}
