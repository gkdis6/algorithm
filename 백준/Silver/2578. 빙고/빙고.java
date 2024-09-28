import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int count = 0;
    static int[][] map;
    static boolean[][] checked;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException{
        map = new int[5][5];
        checked = new boolean[5][5];
        for(int i = 0; i<5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<5; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i<5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<5; j++){
                int cur = Integer.parseInt(st.nextToken());
                Check(cur);
                if(BingoCheck()) return;
            }
        }
    }

    private static void Check(int cur) {
        for(int k = 0; k<5; k++){
            for(int l = 0; l<5; l++){
                if(map[k][l] == cur){
                    checked[k][l] = true;
                    count++;
                    return;
                }
            }
        }
    }

    public static boolean BingoCheck() {
        int bingo_count = 0;
        int rvertical_count = 0, lvertical_count = 0;
        for(int i = 0; i < 5; i++) {
            int vertical_count = 0;
            int horizon_count = 0;
            for(int j = 0; j < 5; j++) {
                if(checked[i][j]) vertical_count++;
                if(checked[j][i]) horizon_count++;
            }
            if(checked[i][i]) rvertical_count++;
            if(checked[i][4-i]) lvertical_count++;
            if(vertical_count == 5) bingo_count++;
            if(horizon_count == 5) bingo_count++;
        }
        if(rvertical_count == 5) bingo_count++;
        if(lvertical_count == 5) bingo_count++;

        if(bingo_count >= 3) {
            System.out.println(count);
            return true;
        }
        return false;
    }
}