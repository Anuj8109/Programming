package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Labyrinth {
    public static class Pair {
        public StringBuilder currPath;
        public int x;
        public int y;

        public Pair(StringBuilder currPath, int x, int y) {
            this.currPath = currPath;
            this.x = x;
            this.y = y;
        }

    }

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
        Queue<Pair> q = new LinkedList<Pair>();
        StringBuilder sb = new StringBuilder();
        q.add(new Pair(sb, startX, startY));
        int[] dir = new int[] { 0, 1, 0, -1, 0 };
        char[] dirVar = new char[] {'R', 'D', 'L','U' };
        if (startX == endX && startY == endY) {
            System.out.println("");
            return;
        }
        Boolean[][] visited = new Boolean[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(visited[i], false);
        }
        //System.out.println("End" + endX +  " " + endY);
        //int count = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int j = 0; j < len; j++) {
               // count++;
                Pair curr = q.poll();
                if (curr.x == endX && curr.y == endY) {
                    System.out.println(curr.currPath.toString());
                    return;
                }
                for (int i = 0; i < 4; i++) {
                    int x = curr.x + dir[i];
                    int y = curr.y + dir[i + 1];
                    if (x == endX && y == endY) {
                        curr.currPath.append(dirVar[i]);
                        StringBuilder output = new StringBuilder();
                        output.append("YES\n");
                        output.append(curr.currPath.length() + "\n");
                        output.append(curr.currPath);
                        System.out.println(output.toString());
                        return;
                    }
                    if(x >= 0 && y >= 0 && x < n && y < m && room[x][y] == '.' && !visited[x][y]){
                        visited[x][y] = true;
                        StringBuilder path = new StringBuilder(curr.currPath);
                        path.append(dirVar[i]);
                        q.add(new Pair(path, x, y));
                    }
                    
                }
            }
            
        }
        System.out.println("NO");
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
