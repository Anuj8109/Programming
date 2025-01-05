package CSES.String;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class WordCombinations {
    public static class TrieNode {
        TrieNode[] next;
        boolean isEnd;
        TrieNode(){
            next = new TrieNode[26];
            isEnd = false;
        }
        
    }
    public static class Trie{
        public static TrieNode root;

        public Trie(){
            root = new TrieNode();
        }

        public static void addWord(String word){
            TrieNode temp = root;
            for(int i:word.toCharArray()){
                if(temp.next[i - 'a'] == null) temp.next[i - 'a'] = new TrieNode();
                temp = temp.next[i - 'a'];
            }
            temp.isEnd = true;
        }

    }
    static int mod = 1_000_000_000 + 7;
    static HashMap<Integer,Long> dp = new HashMap<>();
    static long dfs(String s, Trie root,int index){
        if(index == s.length()){
            return 1;
        }
        if(dp.containsKey(index)) return dp.get(index);
        int i = index;
        TrieNode temp = root.root;
        long result = 0;
        while (i < s.length()) {
            if(temp.next[s.charAt(i) - 'a'] ==null) break;
            temp = temp.next[s.charAt(i) - 'a'];
            if(temp.isEnd) result = (result + dfs(s, root, i + 1))%mod;
            i++;
        }
        dp.put(index, result%mod);
        return dp.get(index);
    }
    public static void main(String[] args){
        FastReader fs = new FastReader();
        String s = fs.next();
        int k = fs.nextInt();
        Trie trie = new Trie();
        while (k-->0) {
            trie.addWord(fs.next());
        }
        System.out.println(dfs(s,trie,0));

    }
    static class FastReader { BufferedReader br; StringTokenizer st; public FastReader() { br = new BufferedReader( new InputStreamReader(System.in)); } String next() { while (st == null || !st.hasMoreElements()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { e.printStackTrace(); } } return st.nextToken(); } int nextInt() { return Integer.parseInt(next()); } long nextLong() { return Long.parseLong(next()); } double nextDouble() { return Double.parseDouble(next()); } String nextLine() { String str = ""; try { if(st.hasMoreTokens()){ str = st.nextToken("\n"); } else{ str = br.readLine(); } } catch (IOException e) { e.printStackTrace(); } return str; } }

}
