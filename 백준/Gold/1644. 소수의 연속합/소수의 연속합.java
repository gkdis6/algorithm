import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        
        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for(int i = 2; i * i <= N; i++) {
            if(isPrime[i]) {
                for(int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        List<Integer> primes = new ArrayList<>();
        for(int i = 2; i <= N; i++) {
            if(isPrime[i]) {
                primes.add(i);
            }
        }
        
        int count = 0;
        int left = 0;
        int sum = 0;
        
        for(int right = 0; right < primes.size(); right++) {
            sum += primes.get(right);
            
            while(sum > N && left <= right) {
                sum -= primes.get(left);
                left++;
            }
            
            if(sum == N) {
                count++;
            }
        }
        
        System.out.println(count);
    }
}