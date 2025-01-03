package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FerrisWheel {
    
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
    private static int countNum(List<Integer> arr,int x){
        Collections.sort(arr);
        int i = 0, j= arr.size() - 1;
        int count = 0;
        while (i <= j) {
            int sum = arr.get(i) + arr.get(j);

            count++;
            j--;
            if(x >= sum){
                i++;    
            }
            //else 
            
        }
        return count;
    }
    public static void main(String[] args){
        FastReader s = new FastReader();

        int n = s.nextInt();
        int x = s.nextInt();
        List<Integer> weights = new ArrayList<>();
        for(int i=0;i<n;i++){
            weights.add(s.nextInt());
        }
        Collections.sort(weights);
        int start = 0,end = n -1;
        int result = 0;
        while(start <= end){
            int sum = weights.get(start) + weights.get(end);
            result++;
            end--;
            if(x >= sum) start++;
        }
        System.out.println(result);
        // int[] arr = new int[n];
        // int[] dep = new int[n];

        // for(int i=0;i<n;i++){
        //     arr[i] = s.nextInt();
        //     dep[i] = s.nextInt();
        // }
        // Arrays.sort(arr);
        // Arrays.sort(dep);
        // int i = 0;
        // int j = 0;
        // int result = 0;
        // while(i < n && j < n){
        //     if(arr[i] <= dep[j]){
        //         i++;
        //         result = Math.max(result, i - j);
        //     }else{
        //         j++;
        //     }
        // }
        // System.out.println(result);
    }
}
