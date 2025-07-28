import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            char[][] grid = new char[N][M];
            for (int i = 0; i < N; i++) {
                grid[i] = br.readLine().toCharArray();
            }
            
            int[] broken = new int[N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (grid[i][j] == 'x') {
                        broken[i] |= (1 << j);
                    }
                }
            }
            
            List<Integer> validMasks = getValidMasks(M);
            
            int[][] dp = new int[N][validMasks.size()];
            
            for (int j = 0; j < validMasks.size(); j++) {
                int mask = validMasks.get(j);
                if ((mask & broken[0]) == 0) {
                    dp[0][j] = Integer.bitCount(mask);
                } else {
                    dp[0][j] = -1;
                }
            }
            
            for (int i = 1; i < N; i++) {
                for (int j = 0; j < validMasks.size(); j++) {
                    int currentMask = validMasks.get(j);
                    if ((currentMask & broken[i]) != 0) {
                        dp[i][j] = -1;
                        continue;
                    }
                    
                    dp[i][j] = -1;
                    for (int k = 0; k < validMasks.size(); k++) {
                        int prevMask = validMasks.get(k);
                        if (dp[i-1][k] == -1) continue;
                        
                        if (isCompatible(prevMask, currentMask)) {
                            dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + Integer.bitCount(currentMask));
                        }
                    }
                }
            }
            
            int answer = 0;
            for (int j = 0; j < validMasks.size(); j++) {
                if (dp[N-1][j] != -1) {
                    answer = Math.max(answer, dp[N-1][j]);
                }
            }
            
            System.out.println(answer);
        }
    }
    
    static List<Integer> getValidMasks(int M) {
        List<Integer> masks = new ArrayList<>();
        for (int mask = 0; mask < (1 << M); mask++) {
            boolean valid = true;
            for (int i = 0; i < M - 1; i++) {
                if (((mask >> i) & 1) == 1 && ((mask >> (i + 1)) & 1) == 1) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                masks.add(mask);
            }
        }
        return masks;
    }
    
    static boolean isCompatible(int prevMask, int currentMask) {
        for (int i = 0; i < 10; i++) {
            if (((currentMask >> i) & 1) == 1) {
                if (i > 0 && ((prevMask >> (i - 1)) & 1) == 1) {
                    return false;
                }
                if (i < 9 && ((prevMask >> (i + 1)) & 1) == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}