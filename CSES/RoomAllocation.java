package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class RoomAllocation {
    public static void main(String[] args){
        FastReader fastReader = new FastReader();
        int n = fastReader.nextInt();
        int[][] times = new int[n][3];

        for(int i=0;i<n;i++){
            times[i][0] = fastReader.nextInt();
            times[i][1] = fastReader.nextInt();
            times[i][2] = i;
        }
        Comparator<int[]> comp = (a,b) -> a[0] - b[0];
        Arrays.sort(times,comp);

        int roomCount = 0;
        int[] result = new int[n];
        PriorityQueue<int[]> endPQ = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for(int i=0;i<n;i++){
            int room = times[i][2];
            int endTime = times[i][1];
            if(!endPQ.isEmpty() && endPQ.peek()[0] < times[i][0]){
                int avail = endPQ.poll()[1];
                result[room] = avail;
                endPQ.add(new int[]{endTime, avail});
            }else{
                roomCount++;
                result[room] = roomCount;
                endPQ.add(new int[]{endTime, roomCount});
            }
            // if(!endPQ.isEmpty() && times[endPQ.peek()][1] < times[startPQ.peek()][0]){
            //     int x = result[endPQ.poll()];
            //     int r = startPQ.poll();
            //     result[r] = x;
            //     endPQ.add(r);
            // }else{
            //     roomCount++;
            //     int pp = startPQ.poll();
            //     //int r = startPQ.poll();
            //     result[pp] = roomCount;
            //     endPQ.add(pp);
            // }
            // while (!endPQ.isEmpty() && times[endPQ.peek()][1] < times[startPQ.peek()][0]) {
            //     availableRooms.add(result[endPQ.poll()]);
            // }
            // int room = startPQ.poll();
            // if(availableRooms.isEmpty()){
            //     roomCount++;
            //     result[room] = roomCount;
            //     endPQ.add(room);
            // }else{
            //     result[room] = availableRooms.poll();
            //     endPQ.add(room);
            // }
        }
        StringBuffer sb = new StringBuffer();
        //System.out.println(roomCount);
        sb.append(roomCount + "\n");
        for(int i=0;i<n;i++){
            sb.append( result[i] + " ");
        }
        System.out.println(sb.toString().substring(0,sb.toString().length() - 1));
        
    }

    static class FastReader { BufferedReader br; StringTokenizer st; public FastReader() { br = new BufferedReader( new InputStreamReader(System.in)); } String next() { while (st == null || !st.hasMoreElements()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { e.printStackTrace(); } } return st.nextToken(); } int nextInt() { return Integer.parseInt(next()); } long nextLong() { return Long.parseLong(next()); } double nextDouble() { return Double.parseDouble(next()); } String nextLine() { String str = ""; try { if(st.hasMoreTokens()){ str = st.nextToken("\n"); } else{ str = br.readLine(); } } catch (IOException e) { e.printStackTrace(); } return str; } }

}
