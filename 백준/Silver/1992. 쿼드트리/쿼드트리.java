import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static char[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        arr = new char[n+1][n+1];
        for(int i = 1; i<=n; i++) {
            char[] line = br.readLine().toCharArray();
            for(int j = 1; j<=n; j++){
                arr[i][j] = line[j-1];
            }
        }
        part(1, 1, n);
        System.out.println(sb);
    }

    private static void part(int x, int y, int size){
        if(colorSame(x, y, size)){
            if(arr[x][y] == '0') sb.append("0");
            else sb.append("1");
            return;
        }
        int newSize = size / 2;
        sb.append("(");
        part(x, y, newSize);
        part(x, y + newSize, newSize);
        part(x + newSize, y, newSize);
        part(x + newSize, y + newSize, newSize);
        sb.append(")");
    }

    private static boolean colorSame(int x, int y, int size){
        int ptr = arr[x][y];

        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(arr[i][j] != ptr){
                    return false;
                }
            }
        }
        return true;
    }
}