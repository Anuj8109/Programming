package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class MovieFestival {
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

    public static void main(String[] arg){
        FastReader s = new FastReader();
        int n = s.nextInt();
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0] = s.nextInt();
            arr[i][1] = s.nextInt();
        }
        Arrays.sort(arr,new Comparator<int[]>() {
            @Override
            public int compare(final int[] a,final int[] b){
                if(a[1] == b[1]) return a[0] - b[0];
                return a[0] - b[0];
            }
        });
        //System.out.println(arr[0][0]);
        int result = 1;
        int endTime = arr[0][1];
        for(int i=1;i<n;i++){
            //System.out.println(arr[]);
            if(arr[i][0] >= endTime){
                result++;
                endTime = arr[i][1];
            }else{
                endTime = Math.min(endTime, arr[i][1]);
            }
        }
        System.out.println(result);
    }
}
