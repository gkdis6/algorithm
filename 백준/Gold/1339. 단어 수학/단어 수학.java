import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        
        for(int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }
        
        int[] weight = new int[26];
        
        for(String word : words) {
            int power = 1;
            for(int i = word.length() - 1; i >= 0; i--) {
                char ch = word.charAt(i);
                weight[ch - 'A'] += power;
                power *= 10;
            }
        }
        
        Integer[] indices = new Integer[26];
        for(int i = 0; i < 26; i++) {
            indices[i] = i;
        }
        
        Arrays.sort(indices, (a, b) -> weight[b] - weight[a]);
        
        int[] digitMap = new int[26];
        int digit = 9;
        for(int i = 0; i < 26; i++) {
            if(weight[indices[i]] > 0) {
                digitMap[indices[i]] = digit--;
            }
        }
        
        int result = 0;
        for(String word : words) {
            int num = 0;
            for(char ch : word.toCharArray()) {
                num = num * 10 + digitMap[ch - 'A'];
            }
            result += num;
        }
        
        System.out.println(result);
    }
}