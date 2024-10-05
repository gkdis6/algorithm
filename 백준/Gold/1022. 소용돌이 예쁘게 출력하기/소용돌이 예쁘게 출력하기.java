import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int c1, r1, c2, r2, max;
    static int[][] map;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        map = new int[r2-r1+1][c2-c1+1];

        max = 0;
        for(int i=r1; i<=r2; i++) {
            for(int j=c1; j<=c2; j++) {
                map[i-r1][j-c1] = calculate(i,j);
                max = Math.max(max, map[i-r1][j-c1]);
            }
        }

        StringBuilder formatter = new StringBuilder("%");
        formatter.append(String.valueOf(max).length());
        formatter.append("d ");

        for(int i = 0; i<= r2-r1; i++){
            for(int j = 0; j<= c2-c1; j++){
                System.out.printf(formatter.toString(), map[i][j]);
            }
            System.out.println();
        }

    }

    private static int calculate(int row, int column){
        int border = Math.max(Math.abs(row),Math.abs(column));
        int min = (int) Math.pow(2*border-1,2)+1;

        if(row == border){
            return min + 7*border -1 + column;
        }

        if(column == -border){
            return min + 5*border -1 + row;
        }

        if(row == -border){
            return min + 3*border -1 - column;
        }

        return min + border -1 - row;
    }
}

