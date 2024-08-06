package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Playlist {
    public static void main(String[] args){
        FastReader fastReader = new FastReader();
        int n = fastReader.nextInt();
        //int count = 0;
        List<Integer> arr = new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(fastReader.nextInt());
        }
        int start = 0,end = 0;
        int currlen  = 0,result = 0;
        HashSet<Integer> s = new HashSet<>();
        while (end < n) {
            if(!s.contains(arr.get(end))){
                s.add(arr.get(end));
                currlen++;
                end++;
            }else{
                s.remove(arr.get(start));
                start++;
                currlen--;
            }
            result = Math.max(currlen, result);
        }
        System.out.println(result);
        // int start = 0,index = 0;
        // int result = 0;
        // HashMap<Integer,Integer> map = new HashMap<>();
        // while (index <n) {
        //     if(!map.containsKey(arr.get(index))){
        //         map.put(arr.get(index), index);
        //     }else{
        //         if(map.get(arr.get(index)) >= start){
        //             start = map.get(arr.get(start)) + 1;
        //         }
                
        //         map.put(arr.get(index), index);
        //     }
        //     index++;
        //     result = Math.max(result, index - start); 
        // }  
        // //result = Math.max(result, index - start);
        // System.out.println(result);
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
