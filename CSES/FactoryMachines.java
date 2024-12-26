package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FactoryMachines {

    static boolean countProduct(int[] times,long availTime,long required){

        long totalCount = 0;
        for(int time:times){
            if(totalCount >= required - (availTime)/time) return true;
            totalCount += (int)(availTime/time);
            //if(totalCount >= required) return true;
        }
        return false;
    }
    public static void main(String[] args){
        FastReader fs = new FastReader();
        int machineCount = fs.nextInt();
        long productCount = fs.nextLong();
        int[] times = new int[machineCount];
        for(int i=0;i<machineCount;i++){
            times[i] = fs.nextInt();
        }
        long start = 0l, end = Long.MAX_VALUE;
        //System.out.println(countProduct(times,7, productCount));
        while (start < end) {
            long mid = start + ((end - start)>>1);
            //System.out.println(mid);
            if(countProduct(times, mid, productCount)){
                //System.out.println(start + " " + end);
                end = mid;
            }else{
                start = mid + 1;
                //System.out.println(mid + " " + start + " " + end);
            }
            //System.out.println(mid + " " + start + " " + end);
        }
        System.out.println(end);

    }

        static class FastReader { BufferedReader br; StringTokenizer st; public FastReader() { br = new BufferedReader( new InputStreamReader(System.in)); } String next() { while (st == null || !st.hasMoreElements()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { e.printStackTrace(); } } return st.nextToken(); } int nextInt() { return Integer.parseInt(next()); } long nextLong() { return Long.parseLong(next()); } double nextDouble() { return Double.parseDouble(next()); } String nextLine() { String str = ""; try { if(st.hasMoreTokens()){ str = st.nextToken("\n"); } else{ str = br.readLine(); } } catch (IOException e) { e.printStackTrace(); } return str; } }

}
