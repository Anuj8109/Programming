package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class StaticRangeSumQueries {
    public static void main(String[] args){
        FastReader fastReader = new FastReader();
        int n = fastReader.nextInt();
        int q = fastReader.nextInt();
        int[] number = new int[n];
        long[] prefixSum = new long[n + 1];
        //System.out.println(prefixSum.length);
        prefixSum[0] = 0l;
        for(int i=0;i<n;i++){
            number[i] = fastReader.nextInt();
            prefixSum[i + 1] = prefixSum[i] + Long.valueOf(number[i]);
        }

        //StringBuilder sb = new StringBuilder();
        PrintWriter out=new PrintWriter(System.out);
        while (q -- > 0) {
            int a = fastReader.nextInt();
            int b = fastReader.nextInt();
            //sb.append(prefixSum[b] - prefixSum[a - 1] + "\n");
            out.print(prefixSum[b] - prefixSum[a - 1] + "\n");
        }
        out.flush();
        //System.out.println(sb.toString());
    }

    static class FastReader { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader( 
                new InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) { 
                try { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException e) { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() { return Integer.parseInt(next()); } 
  
        long nextLong() { return Long.parseLong(next()); } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try { 
                if(st.hasMoreTokens()){ 
                    str = st.nextToken("\n"); 
                } 
                else{ 
                    str = br.readLine(); 
                } 
            } 
            catch (IOException e) { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
}
