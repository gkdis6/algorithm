import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int up = a*d + c*b;
        int down = d*b;

        int comm = gcd(up,down);
        up = up/comm;
        down = down/comm;

        System.out.println(up + " " + down);

    }

    private static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}