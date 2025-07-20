import java.io.*;
import java.util.*;

class Math_Template {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        // 수학 관련 함수들 테스트
        System.out.println("GCD(12, 18): " + gcd(12, 18));
        System.out.println("LCM(12, 18): " + lcm(12, 18));
        System.out.println("소수 판별(17): " + isPrime(17));
        System.out.println("팩토리얼(5): " + factorial(5));
        System.out.println("거듭제곱(2^10): " + power(2, 10));
        System.out.println("모듈러 거듭제곱(2^10 mod 1000): " + modPower(2, 10, 1000));
        
        // 에라토스테네스의 체
        boolean[] primes = sieveOfEratosthenes(30);
        System.out.print("30 이하 소수: ");
        for (int i = 2; i <= 30; i++) {
            if (primes[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        
        // 순열과 조합
        System.out.println("P(5,3): " + permutation(5, 3));
        System.out.println("C(5,3): " + combination(5, 3));
    }
    
    // 최대공약수 (유클리드 호제법)
    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    
    // 최소공배수
    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
    
    // 소수 판별
    static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    // 에라토스테네스의 체
    static boolean[] sieveOfEratosthenes(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        
        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }
        
        return prime;
    }
    
    // 팩토리얼
    static long factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }
    
    // 거듭제곱
    static long power(long base, int exp) {
        long result = 1;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result *= base;
            }
            base *= base;
            exp /= 2;
        }
        return result;
    }
    
    // 모듈러 거듭제곱
    static long modPower(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        
        return result;
    }
    
    // 순열 nPr
    static long permutation(int n, int r) {
        long result = 1;
        for (int i = n; i > n - r; i--) {
            result *= i;
        }
        return result;
    }
    
    // 조합 nCr
    static long combination(int n, int r) {
        if (r > n - r) r = n - r; // C(n,r) = C(n,n-r)
        
        long result = 1;
        for (int i = 0; i < r; i++) {
            result = result * (n - i) / (i + 1);
        }
        
        return result;
    }
}