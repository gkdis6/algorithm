# RPG

https://www.acmicpc.net/problem/1315

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.*;
 
public class Main {

    static int n;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());

        Quest[] arr = new Quest[n];
        int[][] solve = new int[1001][1001];
        boolean[][] possible = new boolean[1001][1001];
        int[][] left = new int[1001][1001];

        for(int i = 0; i<n; i++){
            String[] cur = br.readLine().split(" ");
            
            Quest quest = new Quest(Integer.parseInt(cur[0]), Integer.parseInt(cur[1]), Integer.parseInt(cur[2]));
            arr[i] = quest;
        }

        for(int i = 1; i<=1000; i++){ //10
            for(int j = 1; j<=1000; j++){ //20
                int point = 0;
                for(int k = 0; k<n; k++){
                    if(arr[k].Str <= i || arr[k].Int <= j){ //2+1+1+5+1 = 9
                        point += arr[k].Bonus;
                        solve[i][j] += 1; //5
                    }
                }

                left[i][j] = point - i - j + 2; //힘1 지1 -28 + 9

                if(i == 1 && j == 1) possible[i][j] = true;
                else if(possible[i-1][j] && left[i-1][j] > 0 && i-1 > 0) possible[i][j] = true;
                else if(possible[i][j-1] && left[i][j-1] > 0 && j-1 > 0) possible[i][j] = true;
            }
        }
        
        int ans = 0;
        for(int i = 0; i<=1000; i++){
            for(int j = 0; j<=1000; j++){
                if(possible[i][j]) ans = Math.max(ans, solve[i][j]);
            }
        }
        System.out.println(ans);
        return;
    }

    static public class Quest{
        int Str, Int, Bonus;
        Quest(int Str, int Int, int Bonus){
            this.Str = Str;
            this.Int = Int;
            this.Bonus = Bonus;
        }
    }
}
```

