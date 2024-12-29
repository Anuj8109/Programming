package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Monsters {
    public static void main(String[] args){
        FastReader fs = new FastReader();
        int n = fs.nextInt();
        int m = fs.nextInt();
        int[][] grid = new int[n][m];
        Queue<int[]> monster = new LinkedList<>();
        int endX = 0,endY = 0;
        int startX = 0, startY = 0;
        for(int i=0;i<n;i++){
            String str = fs.next();
            for(int j=0;j<str.length();j++){
                if(str.charAt(j) == '#' || str.charAt(j) == 'M' || str.charAt(j) == 'A'){
                    grid[i][j] = 1;
                }else{
                    grid[i][j] = 0;
                }
                if(str.charAt(j) == 'M'){
                    monster.add(new int[]{i,j});
                }
                if(str.charAt(j) == 'A'){
                    startX = i; startY = j;
                }
            }
        }

        if(startX == 0 || startX == n - 1 || startY == 0 || startY == m - 1){
            System.out.println("YES\n" + "0");
            return;
        }
        int[][] distance = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(distance[i], -1);
        }
        distance[startX][startY] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX,startY});
        int count = 0;
        int[] dir = new int[] { 0, 1, 0, -1, 0 };
        char[] dirVar = new char[] {'L', 'U', 'R','D' };
        boolean isPath = false;

        while (!q.isEmpty() && !isPath) {
            int len = monster.size();
            for(int i=0;i<len && !isPath;i++){
                int[] curr = monster.poll();
                int monX = curr[0];
                int monY = curr[1];
                for(int j=0;j<4;j++){
                    int dx = monX + dir[j];
                    int dy = monY + dir[j + 1];
                    if(dx >= 0 && dy >= 0 && dx < n && dy < m && grid[dx][dy] == 0){
                        grid[dx][dy] = 1;
                        monster.add(new int[]{dx,dy});
                    }
                }
            }
            len = q.size();
            count++;
            for(int i=0;i<len && !isPath;i++){
                int[] curr = q.poll();
                int currX = curr[0];
                int currY = curr[1];
                for(int j=0;j<4;j++){
                    int dx = currX + dir[j];
                    int dy = currY + dir[j + 1];
                    if(dx >= 0 && dy >= 0 && dx < n && dy < m && grid[dx][dy] == 0){
                        grid[dx][dy] = 1;
                        q.add(new int[]{dx,dy});
                        distance[dx][dy] = count;
                        if(dx == 0 || dy == 0 || dx == n-1 || dy == m-1){
                            endX = dx;
                            endY = dy;
                            isPath = true;
                            break;
                        }
                        // if(dx == endX && dy == endY){
                        //     isPath = false;
                        //     break;
                        // }
                        
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        
        if(isPath){
            sb.append("YES\n");
            sb.append(distance[endX][endY] + "\n");
            count = distance[endX][endY];
            int currX = endX, currY = endY;
            StringBuilder path = new StringBuilder();
            while(count > 0){
                count--;
                for(int i=0;i<4;i++){
                    int dx = currX + dir[i];
                    int dy = currY + dir[i + 1];
                    if(dx >= 0 && dy >= 0 && dx < n && dy < m && distance[dx][dy] == count){
                        path.append(dirVar[i]);
                        currX = dx;
                        currY = dy;
                        break;
                    }
                }
            }
            sb.append(path.reverse());
            System.out.println(sb.toString());
        }else{
            System.out.println("NO");
        }
    }

    static class FastReader { BufferedReader br; StringTokenizer st; public FastReader() { br = new BufferedReader( new InputStreamReader(System.in)); } String next() { while (st == null || !st.hasMoreElements()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { e.printStackTrace(); } } return st.nextToken(); } int nextInt() { return Integer.parseInt(next()); } long nextLong() { return Long.parseLong(next()); } double nextDouble() { return Double.parseDouble(next()); } String nextLine() { String str = ""; try { if(st.hasMoreTokens()){ str = st.nextToken("\n"); } else{ str = br.readLine(); } } catch (IOException e) { e.printStackTrace(); } return str; } }

}
