import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n;
    static boolean flag = false;
    static boolean[][] checked;
    static String[][] result;
    static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        checked = new boolean[n][n];
        result = new String[n][n];
        for(int i = 0; i<n; i++){
            char[] ch = br.readLine().toCharArray();
            for(int j = 0; j<n; j++){
                if(ch[j] == '*')
                    checked[i][j] = true;
            }
        }

        FindMine();
        for(int i = 0; i<n; i++){
            Arrays.stream(result[i]).forEach(System.out::print);
            System.out.println();
        }
    }

    private static void FindMine() throws IOException {
        for(int i = 0; i<n; i++){
            char[] ch = br.readLine().toCharArray();
            for(int j = 0; j<n; j++){
                if(ch[j] == 'x') {
                    Check(i,j);
                }
                else result[i][j] = String.valueOf(ch[j]);
            }
        }
        if(flag) CheckMine();
    }

    private static void CheckMine() {
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(checked[i][j]) {
                    result[i][j] = "*";
                }
            }
        }
    }

    private static void Check(int i, int j) {
        if(checked[i][j]) {
            flag = true;
            return;
        }
        int count = 0;
        for(int k = 0; k<8; k++){
            if(i + dy[k] >= 0 && i + dy[k] < n && j + dx[k] >= 0 && j + dx[k] < n && checked[i+dy[k]][j+dx[k]]) {
                count++;
            }
        }
        result[i][j] = String.valueOf(count);
    }

}