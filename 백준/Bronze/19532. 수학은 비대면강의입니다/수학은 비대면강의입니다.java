import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] arr;

    public static void main(String[] args) throws IOException{
        arr = new int[2][3];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<=1; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = -999; i< 1000; i++) {
            for(int j = -999; j< 1000; j++) {
                if(arr[0][0] * i + arr[0][1] * j == arr[0][2]) {
                    if(arr[1][0] * i + arr[1][1] * j == arr[1][2]){
                        System.out.println(i + " " + j);
                        return;
                    }
                }
            }
        }
    }
}