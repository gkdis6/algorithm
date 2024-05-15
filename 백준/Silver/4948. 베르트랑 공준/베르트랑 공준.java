import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
//        st = new StringTokenizer(br.readLine());
        int n;
//        int m = Integer.parseInt(st.nextToken());
        while((n = Integer.parseInt(br.readLine())) != 0){
            System.out.println(findPrime(n));
        }
    }

    private static int findPrime(int n) {
        int count = 0;
        for(int i = n+1; i<=2*n; i++){
            if(i == 1) continue;
            for(int j = 2; j<=Math.sqrt(i); j++) {
                if(i%j == 0) {
                    count--;
                    break;
                }
            }
            count++;
        }
        return count;
    }
}

