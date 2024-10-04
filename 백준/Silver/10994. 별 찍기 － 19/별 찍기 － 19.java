import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n,m;
    static boolean[][] list;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        m = 4*n-3;

        list = new boolean[m][m];
        for(int i=0;i<=m/2;i+=2){
            square(i);
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                if(list[i][j]) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static void square(int l) {
        for(int i=l; i<m-l; i++) {
            list[i][l] = true;
            list[l][i] = true;
            list[i][m-1-l] = true;
            list[m-1-l][i] = true;
        }
    }
}