import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Queue<Integer> que;

    public static void main(String[] args) throws IOException{

        String str;
        while((str = br.readLine()) != null){
            int n = Integer.parseInt(str);
            System.out.println(printKan(n));
        }
    }

    private static String printKan(int a){
        if(a == 0) return "-";
        else return printKan(a-1) + printNa(a-1) + printKan(a-1);
    }

    private static String printNa(int a){
        StringBuilder sb = new StringBuilder();
        a = (int) Math.pow(3,a);
        while(a-- > 0){
            sb.append(" ");
        }
        return sb.toString();
    }
}

