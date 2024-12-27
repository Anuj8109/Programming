package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EditDistance {
    
    public static void main(String[] angs){
        FastReader fs = new FastReader();
        String s1 = fs.next();
        String s2 = fs.next();
        int len1 = s1.length();
        int len2 = s2.length();
        int[] prev = new int[len2 + 1];

        for(int i=1;i<=len2;i++){
            prev[i] = i;
        }
        for(int i=1;i<=len1;i++){
            int[] curr = new int[len2 + 1];
            Arrays.fill(curr, len1 + 1);
            curr[0] = i;
            for(int j=1;j<=len2;j++){
                curr[j] = Math.min(curr[j - 1],prev[j]) + 1;
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    curr[j] = Math.min(curr[j], prev[j - 1]);
                }else{
                    curr[j] = Math.min(curr[j], prev[j - 1] + 1);
                }
            }
            // for(int x:curr){
            //     System.out.print(x + " ");
            // }
            // System.out.println();
            prev = curr;
        }
        System.out.println(prev[len2]);

    }
    static class FastReader { BufferedReader br; StringTokenizer st; public FastReader() { br = new BufferedReader( new InputStreamReader(System.in)); } String next() { while (st == null || !st.hasMoreElements()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { e.printStackTrace(); } } return st.nextToken(); } int nextInt() { return Integer.parseInt(next()); } long nextLong() { return Long.parseLong(next()); } double nextDouble() { return Double.parseDouble(next()); } String nextLine() { String str = ""; try { if(st.hasMoreTokens()){ str = st.nextToken("\n"); } else{ str = br.readLine(); } } catch (IOException e) { e.printStackTrace(); } return str; } }

}
