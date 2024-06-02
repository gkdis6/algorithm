import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int m1 = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n1][m1];
        for(int i = 0; i<n1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m1; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int n2 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());

        int[][] arr2 = new int[n2][m2];
        int[][] result = new int[n1][m2];

        for(int i = 0; i<n2; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m2; j++){
                arr2[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i<n1; i++){
            for(int j = 0; j<m2; j++){
                for(int k = 0; k <n2; k++){
                    result[i][j] += arr[i][k] * arr2[k][j];
                }
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }

    }
}
