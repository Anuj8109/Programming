package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.*;

public class StickLengths {
    public static void main(String[] args){
        FastReader fastReader = new FastReader();
        int n = fastReader.nextInt();
        List<Integer> arr = new ArrayList<>();
        Long postSum = 0L;
        for(int i=0;i<n;i++){
            arr.add(fastReader.nextInt());
            postSum += arr.get(i);
        }
        Collections.sort(arr);
        Long result = Long.MAX_VALUE;
        Long preSum = 0L;
        for(int i=0;i<n;i++){
            postSum -= arr.get(i);
            //System.out.println(preSum + " " + postSum);
            Long p1 = Math.abs(postSum - (n - i - 1)*(new Long(arr.get(i))));
            Long p2 = Math.abs(preSum - (i) * (new Long(arr.get(i))));
            //System.out.println(p1 + " " + p2);
            result = Math.min(result,p1 + p2);
           //Long.int(p1 + p2);
            preSum += arr.get(i);

        }
        System.out.println(result);
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
