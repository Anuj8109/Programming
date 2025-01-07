package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RoadConstruction {
    static int maximum = 1;
    public static class DSU {
        int[] size;
        int[] parent;
        int totalComponent;
        public DSU(int n){
            size = new int[n];
            parent = new int[n];
            for(int i=0;i<n;i++) parent[i] = i;
            Arrays.fill(size, 1);
            totalComponent = n;
        }

        public int findParent(int index){
            if(parent[index] == index) return index;
            return parent[index] = findParent(parent[index]);
        }
        
        public void union(int a, int b){
            int p = findParent(a);
            int q = findParent(b);
            if(p != q){
                if(size[p] < size[q]){
                    size[q] += size[p];
                    maximum = Math.max(maximum, size[q]);
                    parent[p] = q;
                }else{
                    size[p] += size[q];
                    maximum = Math.max(maximum, size[p]);
                    parent[q] = p;
                }
                totalComponent--;
            }
        }
    }
    public static void main(String[] args){
        FastReader fs = new FastReader();
        int n = fs.nextInt();
        int m = fs.nextInt();
        StringBuilder sb = new StringBuilder();
        DSU dsu = new DSU(n);
        while (m-->0) {
            int p = fs.nextInt() - 1;
            int q = fs.nextInt() - 1;
            dsu.union(p, q);
            sb.append(dsu.totalComponent + " " + maximum + "\n");
        }
        System.out.println(sb.toString());
    }
    static class FastReader { BufferedReader br; StringTokenizer st; public FastReader() { br = new BufferedReader( new InputStreamReader(System.in)); } String next() { while (st == null || !st.hasMoreElements()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { e.printStackTrace(); } } return st.nextToken(); } int nextInt() { return Integer.parseInt(next()); } long nextLong() { return Long.parseLong(next()); } double nextDouble() { return Double.parseDouble(next()); } String nextLine() { String str = ""; try { if(st.hasMoreTokens()){ str = st.nextToken("\n"); } else{ str = br.readLine(); } } catch (IOException e) { e.printStackTrace(); } return str; } }

}
