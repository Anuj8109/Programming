import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Codeforce {
    
    public static void main(String arg[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] primeMul = new int[n + 1];
        for(int i=2;i<=n;i++){
            if(primeMul[i] == 0){
                for(int j=i*2;j<=n;j+=i){
                    primeMul[j]++;
                }
                
            }  
        }
        int result = 0;
        for(int i=4;i<=n;i++){
          
            if(primeMul[i] == 2){
                 //System.out.println(i);;
                result += 1;
            }
        }
        System.out.println(result);
    }



    
}
