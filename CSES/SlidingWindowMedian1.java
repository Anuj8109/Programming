package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SlidingWindowMedian1 {
    public static void main(String[] args){
        FastReader fs = new FastReader();
        int n = fs.nextInt();
        int k = fs.nextInt();
        int[] elements = new int[n];
        for(int i=0;i<n;i++){
            elements[i] = fs.nextInt();
        }

        PriorityQueue<Integer> leftPQ = new PriorityQueue<>((a,b) -> (elements[a] == elements[b] ? a - b :  Integer.compare(elements[b], elements[a])));
        PriorityQueue<Integer> rightPQ = new PriorityQueue<>((a,b) -> (elements[a] == elements[b] ? a - b : Integer.compare(elements[a], elements[b])));
        //boolean isOdd = (k & 1) > 0;
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<k;i++){
            rightPQ.add(i);
            // if(rightPQ.size() > leftPQ.size()){
            //     leftPQ.add(rightPQ.poll());
            // }
        }
        while (rightPQ.size() > leftPQ.size()) {
            leftPQ.add(rightPQ.poll());
        }
        int rsize = rightPQ.size();
        int lsize = leftPQ.size();
        result.add(elements[leftPQ.peek()]);

        for(int i=k;i<n;i++){
            //remove
            if(elements[leftPQ.peek()] == elements[i - k] && 
                !rightPQ.isEmpty() && 
                elements[rightPQ.peek()] == elements[i - k]){
                if(rightPQ.peek() < leftPQ.peek()){
                    rsize--;
                }else{
                    lsize--;
                }
            }
            else if(elements[leftPQ.peek()] >= elements[i-k]){
                lsize--;
            }else{
                rsize--;
            }
            while (!leftPQ.isEmpty() && leftPQ.peek() <= i - k) {
                leftPQ.poll();
            }

            while (!rightPQ.isEmpty() && rightPQ.peek() <= i - k) {
                rightPQ.poll();
            }
            //add
            if(!rightPQ.isEmpty() && elements[i] >= elements[rightPQ.peek()]){
                rightPQ.add(i);
                rsize++;
            }else{
                leftPQ.add(i);
                lsize++;
            }
            // if(lsize > rsize){
            //     leftPQ.add(i);
            //     lsize++;
            // }else{
            //     rightPQ.add(i);
            //     rsize++;
            // }
            
            
            //rebalance
            while (rsize > lsize) {
                if(rightPQ.peek() <= i - k){
                    rightPQ.poll();
                    continue;
                }
                leftPQ.add(rightPQ.poll());
                lsize++;
                rsize--;
            }

            while (lsize - rsize > 1) {
                if(leftPQ.peek() <= i - k){
                    leftPQ.poll();
                    continue;
                }
                rightPQ.add(leftPQ.poll());
                rsize++;
                lsize--;
            }
            while(leftPQ.peek() <= i - k){
                leftPQ.poll();
            }
            result.add(elements[leftPQ.peek()]);
        }
        StringBuilder sb = new StringBuilder();
        for(int i:result){
            sb.append(" " + i);
        }
        System.out.println(sb.toString().substring(1));
    }
        static class FastReader { BufferedReader br; StringTokenizer st; public FastReader() { br = new BufferedReader( new InputStreamReader(System.in)); } String next() { while (st == null || !st.hasMoreElements()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { e.printStackTrace(); } } return st.nextToken(); } int nextInt() { return Integer.parseInt(next()); } long nextLong() { return Long.parseLong(next()); } double nextDouble() { return Double.parseDouble(next()); } String nextLine() { String str = ""; try { if(st.hasMoreTokens()){ str = st.nextToken("\n"); } else{ str = br.readLine(); } } catch (IOException e) { e.printStackTrace(); } return str; } }

}
