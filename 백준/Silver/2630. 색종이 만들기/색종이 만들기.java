import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    static boolean[][] square;
    static int white = 0, blue = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        square = new boolean[n][n];
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++)
            square[i][j] = Integer.parseInt(st.nextToken()) == 1;
        }
        part(0, 0, n);

        System.out.println(white);
        System.out.println(blue);
    }

    private static void part(int x, int y, int size){

        if(colorSame(x, y, size)){
            if(square[x][y]){
                blue++;
            }else{
                white++;
            }
            return;
        }
        int newSize = size / 2;
        part(x, y, newSize);
        part(x, y + newSize, newSize);
        part(x + newSize, y, newSize);
        part(x + newSize, y + newSize, newSize);
    }

    private static boolean colorSame(int x, int y, int size){
        boolean color = square[x][y];

        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(square[i][j] != color){
                    return false;
                }
            }
        }
        return true;
    }

}