package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ForestQueries {
    public static void main(String[] args){
        FastReader fastReader = new FastReader();
        int n = fastReader.nextInt();
        int q = fastReader.nextInt();
        int[][] presum = new int[n + 1][n + 1];
        for(int i=1;i<=n;i++){
            String s = fastReader.next();
            for(int j=1;j<=s.length();j++){
                presum[i][j] =  presum[i-1][j] + presum[i][j-1] - presum[i - 1][j - 1] + (s.charAt(j - 1) == '*' ? 1 : 0);
                // if(((Character)s.charAt(j - 1)).equals('*')){
                //     presum[i][j]++;
                // }
                
            }
        }
        PrintWriter out = new PrintWriter(System.out);
        while(q -->0){
             int x1 = fastReader.nextInt();
             int y1 = fastReader.nextInt();
             int x2 = fastReader.nextInt();
             int y2 = fastReader.nextInt();
             int res = presum[x2][y2] + presum[x1-1][y1 - 1] - presum[x2][y1 - 1] - presum[x1 - 1][y2];
             out.print(res);
             out.print("\n");
        }
        out.flush();
        
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
