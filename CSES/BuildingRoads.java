package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BuildingRoads {
    public static int[] parent;
    public static int[] size;
    public static void init(int n){
        parent = new int[n + 1];
        size = new int[n + 1];
        for(int i=1;i<=n;i++){
            parent[i] = i;
        }
    }

    public static int find(int i){
        if(parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }

    public static void make_pair(int p,int q){
        int parP = find(p);
        int parQ = find(q);
        if(size[parP] > size[parQ]){
            size[parP] += size[parQ];
            parent[parQ] = parent[parP];
        }else{
            size[parQ] += size[parP];
            parent[parP] = parent[parQ];
        }
    }
    public static void main(String[] args) {
        FastReader fastReader = new FastReader();
        int n = fastReader.nextInt();
        int m = fastReader.nextInt();
        init(n);
        for(int i=0;i<m;i++){
            int a = fastReader.nextInt();
            int b = fastReader.nextInt();
            make_pair(a, b);
        }
        int count = 0;
        //List<Integer> result = new ArrayList<>();
        int prev = -1;
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++){
            if(find(i) == i){
                if(prev != -1){
                    sb.append(prev + " " + i + "\n");
                }
                prev = i;
                count++;
            }
        }
        System.out.println(count - 1);
        System.out.println(sb.toString());
        // x
        
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
