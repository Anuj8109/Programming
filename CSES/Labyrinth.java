package CSES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Labyrinth {

    public static void main(String[] args) {
        FastReader fastReader = new FastReader();
        int n = fastReader.nextInt();
        int m = fastReader.nextInt();
        char[][] room = new char[n][m];
        int startX = -1, startY = -1;
        int endX = -1, endY = -1;
        for (int i = 0; i < n; i++) {
            String s = fastReader.next();
            for (int j = 0; j < m; j++) {
                if (s.charAt(j) == 'A') {
                    startX = i;
                    startY = j;
                } else if (s.charAt(j) == 'B') {
                    endX = i;
                    endY = j;
                }
                room[i][j] = s.charAt(j);
            }
        }
        
        Queue<int[]> q = new LinkedList<int[]>();
        
        q.add(new int[]{startX,startY,0});
        int[] dir = new int[] { 0, 1, 0, -1, 0 };
        char[] dirVar = new char[] {'L', 'U', 'R','D' };
        if (startX == endX && startY == endY) {
            System.out.println("");
            return;
        }
        int[][] visited = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(visited[i], -1);
        }
        visited[startX][startY] = 0;
        boolean isPath = false;
        while (!q.isEmpty() && !isPath) {
            int len = q.size();
            for (int j = 0; j < len && !isPath; j++) {
                int[] curr = q.poll();
                int currX = curr[0];
                int currY = curr[1];
                int currLen = curr[2];
                for(int i=0;i<4;i++){
                    int dx = currX + dir[i];
                    int dy = currY + dir[i + 1];
                    if(dx == endX && dy == endY){
                        visited[dx][dy] = currLen + 1;
                        isPath = true;
                        break;
                    }
                    else if(dx >= 0 && dy >= 0 && dx < n && dy < m && (room[dx][dy] == '.')){
                        visited[dx][dy] = currLen + 1;
                        q.add(new int[]{dx, dy, currLen + 1});
                        room[dx][dy] = '#';
                    }
                }
            }
        }
        if(!isPath){
            System.out.println("NO");
            return;
        }
        //System.out.println("Path is here");
        StringBuilder sb = new StringBuilder();
        sb.append("YES" + "\n");
        sb.append(visited[endX][endY] + "\n");
        int currX = endX, currY = endY;
        StringBuilder path = new StringBuilder();
        int count = visited[endX][endY];
        while(count > 0){
            count--;
            for(int i=0;i<4;i++){
                int dx = currX + dir[i];
                int dy = currY + dir[i + 1];
                if(dx >= 0 && dy >= 0 && dx < n && dy < m && visited[dx][dy] == count){
                    path.append(dirVar[i]);
                    currX = dx;
                    currY = dy;
                    break;
                }
            }
        }
        sb.append(path.reverse());
        System.out.println(sb.toString());
        // Boolean[][] visited = new Boolean[n][m];

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
