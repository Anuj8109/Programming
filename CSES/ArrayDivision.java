package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ArrayDivision {
    static boolean helper(int[] elements, long mid, int k){
        long currSum = 0;
        int count = 1;
        for(int element:elements){
            if(element > mid) return false;
            if(currSum + element > mid){
                count++;
                currSum = element;
            }else{
                currSum += element;
            }
        }
        return count <= k;
    }
    public static void main(String[] args){
        FastReader fs = new FastReader();
        int n = fs.nextInt();
        int k = fs.nextInt();
        int[] elements = new int[n];
        long sum = 0;
        for(int i=0;i<n;i++){
            elements[i] = fs.nextInt();
            sum += elements[i];
        }

        long start = 0, end = sum;

        while(start < end){
            long mid = (start + end)/2;
            if(helper(elements, mid, k)){
                end = mid;
            }else{
                start = mid + 1;
            }
            //System.out.println(start + " " + end);
        }
        System.out.println(end);
    }
    static class FastReader { BufferedReader br; StringTokenizer st; public FastReader() { br = new BufferedReader( new InputStreamReader(System.in)); } String next() { while (st == null || !st.hasMoreElements()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { e.printStackTrace(); } } return st.nextToken(); } int nextInt() { return Integer.parseInt(next()); } long nextLong() { return Long.parseLong(next()); } double nextDouble() { return Double.parseDouble(next()); } String nextLine() { String str = ""; try { if(st.hasMoreTokens()){ str = st.nextToken("\n"); } else{ str = br.readLine(); } } catch (IOException e) { e.printStackTrace(); } return str; } }

}
