package UnsolveCEES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class MissingCoinSum {
    
    public static void main(String[] arg){
        FastReader fastReader = new FastReader();
        int n = fastReader.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = fastReader.nextInt();
        }
        Arrays.sort(arr);

        int num = 1;
        HashSet<Integer> prev = new HashSet<>();
        prev.add(0);
        for(int i=0;i<n;i++){
            HashSet<Integer> s = new HashSet<>(prev);
            for(int x:prev){
                s.add(x + arr[i]);
            }
           // System.out.println(s.size());
            prev = s;
        }
        while (prev.contains(num)) {
            num++;
        }
        System.out.println(num);
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
