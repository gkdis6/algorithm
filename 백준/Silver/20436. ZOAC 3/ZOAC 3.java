import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n;
    static HashMap<Character, Key> leftMap = new HashMap<>();
    static HashMap<Character, Key> rightMap = new HashMap<>();

    public static void main(String[] args) throws IOException{
        char[][] qwertyLeft = new char[3][5];
        char[][] qwertyRight = new char[3][5];
        qwertyLeft[0] = "qwert".toCharArray();
        qwertyLeft[1] = "asdfg".toCharArray();
        qwertyLeft[2] = "zxcv".toCharArray();
        qwertyRight[0] = "yuiop".toCharArray();
        qwertyRight[1] = "hjkl".toCharArray();
        qwertyRight[2] = "bnm".toCharArray();

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < qwertyLeft[i].length; j++){
                leftMap.put(qwertyLeft[i][j], new Key(i, j));
            }
            for(int j = 0; j < qwertyRight[i].length; j++){
                rightMap.put(qwertyRight[i][j], new Key(i, j+ qwertyLeft[i].length));
            }
        }

        st = new StringTokenizer(br.readLine());
        Key left = leftMap.get(st.nextToken().charAt(0));
        Key right = rightMap.get(st.nextToken().charAt(0));

        String input = br.readLine();
        int time = 0;
        for (int i = 0; i < input.length(); i++) {
            Character c = input.charAt(i);
            if (leftMap.containsKey(c)) {
                Key dir_L = leftMap.get(c);
                time += Math.abs(left.x - dir_L.x) + Math.abs(left.y - dir_L.y) + 1;
                left = dir_L;
            } else if (rightMap.containsKey(c)) {
                Key dir_R = rightMap.get(c);
                time += Math.abs(right.x - dir_R.x) + Math.abs(right.y - dir_R.y) + 1;
                right = dir_R;
            }
        }

        System.out.println(time);
    }

    public static class Key {
        int x, y;
        Key(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

}

