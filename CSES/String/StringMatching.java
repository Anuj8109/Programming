package CSES.String;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StringMatching {
    private static void prefix_function(String s,int[] lps){
        lps[0] = 0;
        int i = 1;
        int len = 0;
        while(i < s.length()){
            while(len > 0 && s.charAt(i) != s.charAt(len)){
                len = lps[len-1];
            }
            if(s.charAt(i) == s.charAt(len)){
                len++;
            }
            lps[i] = len;
            i++;
        }
    }

    public static void main(String[] args){
        FastReader fastReader = new FastReader();
        String text = fastReader.next();
        String pattern = fastReader.next();
        int[] lps = new int[pattern.length()];
        prefix_function(pattern, lps);
        int i = 0 ,j =0;
        int count = 0;
        while(i < text.length()){
            if(text.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }else{
                if(j != 0){
                    j = lps[j-1];
                }else i++;
            }
            if(j == pattern.length()){
                //System.out.println(i - pattern.length());
                j=lps[j-1];
                count++;
            }
        }
        System.out.println(count);
        
        //System.out.println(Arrays.toString(lps));
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
