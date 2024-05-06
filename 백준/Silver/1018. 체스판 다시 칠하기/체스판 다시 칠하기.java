import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Character[][] arr;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] count = new int[2];
        int min = Integer.MAX_VALUE;

        arr = new Character[n][m];

        for(int i = 0; i<n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        for(int x = 0; x<n-7; x++){
            for(int y = 0; y<m-7; y++){
                Arrays.fill(count, 0);
                for(int i = 0; i< 8; i++) {
                    for(int j = 0; j< 8; j++) {
                        if(arr[x+i][y+j] == 'B') count[(i+j)%2]++;
                        else count[(i+j+1)%2]++;
                    }
                }
                min = Math.min(min,Math.min(count[0], count[1]));
            }
        }
        System.out.println(min);
    }
}