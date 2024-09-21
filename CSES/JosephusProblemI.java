package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.LinkedHashSet;


public class JosephusProblemI {
    
    public static void main(String[] args){
        FastReader fastReader = new FastReader();
        int n = fastReader.nextInt();
        Set<Integer> prev = new TreeSet<>();
        // for(int i=1;i<=n;i++) s.add(i);

        StringBuilder sb = new StringBuilder();
        // for(int i=2;i<=n;i+=2){
        //     //ans.add(i);
        //     sb.append(i + " ");
        //     //sb.append(" ");
        // }
        for(int i=1;i<=n;i++){
            prev.add(i);
        }
        
        
        
        boolean t = false;
        while (prev.size() != 0) {
            Set<Integer> curr = new TreeSet<>();
            Iterator<Integer> iterator = prev.iterator();
            while (iterator.hasNext()) {
                if(t){
                    sb.append(iterator.next() + " ");
                }else{
                    curr.add(iterator.next());
                }
                t = !t;
            }
            prev = curr;
            Integer.v
           // System.out.println(prev.size() + " " + sb.toString());
            // if(t){
            //     sb.append(iterator.next());
            // }
        }

        System.out.println(sb.toString());
       // System.out.println(ans);
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
