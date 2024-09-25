package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CountingRooms {


    private static void dfs(int[][] room,int x,int y,int n,int m){
        //if(x < 0 || y < 0 || x >=n || y >= m) return ;
        room[x][y] = -1;
        int[] dir = {0,1,0,-1,0};
       // visited[x][y] = true;
        for(int k=0; k < 4; k++){
            int i = x + dir[k];
            int j = y + dir[k + 1];
            if(i >= 0 && j >= 0 && i < n && j < m && room[i][j] == 1)
                dfs(room, i, j, n, m);
            // if(x < n && y < m && x >=0 && y >= 0 && room[x][y] == 1){
            //     dfs(room, i, j, n, m);
            // }
                
        }
    }
    public static void main(String[] args){
        FastReader fastReader = new FastReader();
        int n = fastReader.nextInt();
        int m = fastReader.nextInt();
        int[][] room = new int[n][m];
        for(int i=0;i<n;i++){
            String s = fastReader.next();
            for(int j=0;j<m;j++){
                room[i][j] = s.charAt(j) == '#' ? -1 : 1;
            }
        }
        //Boolean[][] visited = new Boolean[n][m];
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(room[i][j] == 1){
                    ans++;
                    dfs(room, i, j, n, m);
                }
            }
        }
        System.out.println(ans);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                if (st.hasMoreTokens()) {
                    str = st.nextToken("\n");
                } else {
                    str = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}