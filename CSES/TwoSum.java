package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TwoSum {
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
        Comparator<int[]> com = new Comparator<int[]>() {
            public int compare(final int[] a,final int[] b){
                if(a[0] == b[0]) return a[1] - b[1];
                return a[0] - b[0];
            }
        };
        FastReader fastReader = new FastReader();
        int n = fastReader.nextInt();
        int targetSum = fastReader.nextInt();

        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0] = fastReader.nextInt();
            arr[i][1] = i + 1;
        }
        Arrays.sort(arr, com);
        int i =0,j = arr.length - 1;
        
        while(i < j){
            //System.out.println(arr[i][0] +" " + arr[j][0]);
            int sum = arr[i][0] + arr[j][0];
            if(sum < targetSum) i++;
            else if(sum > targetSum) j--;
            else{
                System.out.println(arr[i][1] + " " + arr[j][1]);
                return;
            }
        }
        if(i >= j) System.out.println("IMPOSSIBLE");
    }
}
