import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] arr;
    static int[] cnt = new int[3];

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];
        for(int i = 1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        part(1, 1, n);
        System.out.println(cnt[0]);
        System.out.println(cnt[1]);
        System.out.println(cnt[2]);
    }

    private static void part(int x, int y, int size){
        if(colorSame(x, y, size)){
            if(arr[x][y] == -1) cnt[0]++;
            else if(arr[x][y] == 0) cnt[1]++;
            else cnt[2]++;
            return;
        }
        int newSize = size / 3;
        part(x, y, newSize);
        part(x, y + newSize, newSize);
        part(x, y + 2*newSize, newSize);
        part(x + newSize, y, newSize);
        part(x + newSize, y + newSize, newSize);
        part(x + newSize, y + 2*newSize, newSize);
        part(x + 2*newSize, y, newSize);
        part(x + 2*newSize, y + newSize, newSize);
        part(x + 2*newSize, y + 2*newSize, newSize);
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