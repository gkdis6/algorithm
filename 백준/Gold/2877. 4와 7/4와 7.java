import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        n = n+1;
        while(n != 0){
            sb.append(n%2);
            n /= 2;
        }
        StringBuilder result = new StringBuilder();
        for(int i=sb.toString().length()-2;i>=0;i--){
            if(sb.charAt(i) == '0') result.append(4);
            else result.append(7);
        }
        System.out.println(result);

    }
}



//1 4(0)    1+1
//2 7(1)    10+1
//3 44(00)  11+1
//4 47(01)  100+1
//5 74(10)  101+1
//6 77
//444
//447
//474
//477
//744
//747
//774
//777
