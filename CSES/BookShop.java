package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BookShop {
    // static HashMap<Integer,HashMap<Integer,Integer>> dp = new HashMap<>();
    // public static int maximumPages(int index, int totalPrice,int[] prices, int[] pages){
    //     if(index == prices.length) return 0;
    //     dp.putIfAbsent(index, new HashMap<>());
    //     HashMap<Integer,Integer> curr = dp.get(index);
    //     if(curr.containsKey(totalPrice)) return curr.get(totalPrice);
    //     int skip = maximumPages(index + 1, totalPrice, prices, pages);
    //     int take = 0;
    //     if(totalPrice >= prices[index]){
    //         take = maximumPages(index + 1, totalPrice - prices[index], prices, pages) + pages[index];
    //     }
    //     curr.put(totalPrice, Math.max(skip, take));
    //     return curr.get(totalPrice);
    // }
    public static void main(String[] args){
        FastReader fs = new FastReader();
        int n = fs.nextInt();
        int total = fs.nextInt();
        int[] prices = new int[n];
        int[] pages = new int[n];
        for(int i=0;i<n;i++){
            prices[i] = fs.nextInt();
        }

        for(int i=0;i<n;i++){
            pages[i] = fs.nextInt();
        }
        //HashMap<Integer,Integer> dp = new HashMap<>();
        int[] prev = new int[total + 1];
        prev[0] = 0;
        //dp.put(total, 0);
        //Iterative DP
        int result = 0;
        for(int i=0;i<n;i++){
            int[] curr = prev.clone();
            for(int j=prices[i];j<=total;j++){
                curr[j] = Math.max(curr[j], pages[i] + prev[j - prices[i]]);
            }
            prev = curr;
            //HashMap<Integer,Integer> curr = new HashMap<>(dp);
            // for(int left:dp.keySet()){
            //     if(left >= prices[i]){
            //         int l = left - prices[i];
            //         int maxi = Math.max(dp.getOrDefault(l,0) + pages[i], dp.getOrDefault(left, 0));
            //         curr.put(l, maxi);
            //         result = Math.max(result, maxi);
            //         //curr.put(left - prices[i], dp.getOrDefault(left - prices[i], 0) + )
            //     }
            // }
            //dp = curr;
        }
        System.out.println(prev[total]);
        return;
        //System.out.println(maximumPages(0, total, prices, pages));

    }

    static class FastReader { BufferedReader br; StringTokenizer st; public FastReader() { br = new BufferedReader( new InputStreamReader(System.in)); } String next() { while (st == null || !st.hasMoreElements()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { e.printStackTrace(); } } return st.nextToken(); } int nextInt() { return Integer.parseInt(next()); } long nextLong() { return Long.parseLong(next()); } double nextDouble() { return Double.parseDouble(next()); } String nextLine() { String str = ""; try { if(st.hasMoreTokens()){ str = st.nextToken("\n"); } else{ str = br.readLine(); } } catch (IOException e) { e.printStackTrace(); } return str; } }

}
