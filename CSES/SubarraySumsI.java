package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SubarraySumsI {

    public static void main(String[] args){
        FastReader fs = new FastReader();
        int n = fs.nextInt();
        int x = fs.nextInt();
        int[] elements = new int[n];
        
        for(int i=0;i<n;i++){
            elements[i] = fs.nextInt();
        }
        int start = 0;
        int curr = 0;
        long sum = 0;
        int result = 0;
        while(curr < n){
            sum += elements[curr++];
            while(sum > x){
                sum -= elements[start++];
            }
            if(sum == x) result++;
        }
        System.out.println(result);
    }
    static class FastReader { BufferedReader br; StringTokenizer st; public FastReader() { br = new BufferedReader( new InputStreamReader(System.in)); } String next() { while (st == null || !st.hasMoreElements()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { e.printStackTrace(); } } return st.nextToken(); } int nextInt() { return Integer.parseInt(next()); } long nextLong() { return Long.parseLong(next()); } double nextDouble() { return Double.parseDouble(next()); } String nextLine() { String str = ""; try { if(st.hasMoreTokens()){ str = st.nextToken("\n"); } else{ str = br.readLine(); } } catch (IOException e) { e.printStackTrace(); } return str; } }

    
}


