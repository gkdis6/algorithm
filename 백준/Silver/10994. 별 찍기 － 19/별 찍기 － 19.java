import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n,m;
    static String[][] list;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        m = 4*n-3;

        list = new String[m][m];
        for(int i=0;i<m;i++){
            Arrays.fill(list[i]," ");
        }
        for(int i=0;i<=m/2;i+=2){
            square(i);
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                System.out.print(list[i][j]);
            }
            System.out.println();
        }
    }

    private static void square(int l) {
        for(int i=l; i<m-l; i++) {
            list[i][l] = list[l][i] = list[i][m-1-l] = list[m-1-l][i] = "*";
        }
    }
}