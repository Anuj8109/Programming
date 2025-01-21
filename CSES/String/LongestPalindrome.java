package CSES.String;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        int n = s.length();
        String sRev = new String();
        int maxLen = 0;
        int start = 0;
        for(int i=0;i<n;i++){
            //even length;
            int p = i, q = i + 1;
            while (p >= 0 && q < n && s.charAt(p) == s.charAt(q)) {
                p--;
                q++;
            }
            if(maxLen < (q - p - 1)){
                //System.out.println(i + " " + p + " " + q);
                maxLen = q - p - 1;
                start = p + 1;
            }
            //odd length 
            p = i - 1;
            q = i + 1;
            while (p >= 0 && q < n && s.charAt(p) == s.charAt(q)) {
                p--;
                q++;
            }
            if(maxLen < (q - p - 1)){
                //System.out.println(i + " " + p + " " + q);
                maxLen = q - p - 1;
                start = p + 1;
            }

        }
        return s.substring(start, start + maxLen);
    }
    public static void main(String[] args){
        FastIO fastIO = new FastIO();
        String s = fastIO.next();
        fastIO.print(longestPalindrome(s));
        fastIO.flush();
    }
    static class FastIO extends PrintWriter {private InputStream stream;private byte[] buf=new byte[1<<16];private int curChar,numChars;public FastIO(){this(System.in,System.out);}public FastIO(InputStream i,OutputStream o){super(o);stream=i;}public FastIO(String i,String o) throws IOException{super(new FileWriter(o));stream=new FileInputStream(i);}private int nextByte(){if(numChars==-1)throw new InputMismatchException();if(curChar>=numChars){curChar=0;try{numChars=stream.read(buf);}catch(IOException e){throw new InputMismatchException();}if(numChars==-1)return-1;}return buf[curChar++];}public String next(){int c;do{c=nextByte();}while(c<=' ');StringBuilder res=new StringBuilder();do{res.appendCodePoint(c);c=nextByte();}while(c>' ');return res.toString();}public int nextInt(){int c;do{c=nextByte();}while(c<=' ');int sgn=1;if(c=='-'){sgn=-1;c=nextByte();}int res=0;do{if(c<'0'||c>'9')throw new InputMismatchException();res=10*res+c-'0';c=nextByte();}while(c>' ');return res*sgn;}public double nextDouble(){return Double.parseDouble(next());}}

}
