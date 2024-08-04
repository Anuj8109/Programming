package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class ConcertTickets {
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
        int m = s.nextInt();
        StringBuffer sb = new StringBuffer();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        Map.Entry<Integer, Integer> val;
        for(int i=0;i<n;i++){
            int ele = s.nextInt();
            if(map.containsKey(ele)){
                map.put(ele, map.get(ele) + 1);
            }else{
               
                map.put(ele, 1);
            }
        }
        
        for(int i=0;i<m;i++){
            val = map.lowerEntry(s.nextInt() + 1);
            if(val.getKey() == null) sb.append("-1\n");
            else{
                sb.append(val.getKey() + "\n");
                if(val.getValue() != 1){
                    map.put(val.getKey(), val.getValue() - 1);
                }else{
                    map.remove(val.getKey());
                }
                // int x = map.get(ans) - 1;
                // if(x == 0) map.remove(ans);
                // else map.put(ans, x);
            }
            // if(set.size() == 0){
            //     sb.append("-1\n");
            //     continue;
            // }
            // Integer ans = set.floor(s.nextInt());
            // if(ans == null) sb.append("-1\n");
            // else{
            //     sb.append(ans+"\n");
            //     int x = map.get(ans) - 1;
            //     map.put(ans,x);
            //     if(x == 0) set.remove(ans);
            //     set.remove(ans);
            // }
        }
        System.out.println(sb.toString());

    }
}
