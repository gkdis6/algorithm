import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n;

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(br.readLine());

        int a = n,b = n;
        int count_a = 0, count_b = 0;
        int first = 0, second = 0, third = 0, cur = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 14; i++){
            cur = Integer.parseInt(st.nextToken());
            if(cur <= a) {
                count_a += a/cur;
                a %= cur;
            }

            if(first < second && second < third && i > 2){
                count_b += b/cur;
                b %= cur;
            } else if(second < first && third < second && i > 2){
                b += count_b * cur;
                count_b = 0;
            }
            third = second;
            second = first;
            first = cur;
        }

        a += count_a * cur;
        b += count_b * cur;

        if(a < b){
            System.out.println("TIMING");
        } else if (a > b) {
            System.out.println("BNP");
        }else{
            System.out.println("SAMESAME");
        }

    }
}