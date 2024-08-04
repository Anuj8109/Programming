package CSES;

import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
public class RestaurantCustomers {
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
    
    public static void main(String[] args){
        FastReader s = new FastReader();

        int n = s.nextInt();
        int[] arr = new int[n];
        int[] dep = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = s.nextInt();
            dep[i] = s.nextInt();
        }
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 0;
        int j = 0;
        int result = 0;
        while(i < n && j < n){
            if(arr[i] <= dep[j]){
                i++;
                result = Math.max(result, i - j);
            }else{
                j++;
            }
        }
        System.out.println(result);
    }
    
}
