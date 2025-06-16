import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] fib = new int[100];
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        fib[0] = 1;
        fib[1] = 1;
        fib[2] = 2;

        int pre = 0;
        int result = 1;
        for(int i = 0; i < m; i++) {
            int vip = Integer.parseInt(br.readLine());
            result *= pibonachi(vip - 1 - pre); 
            pre = vip;

        }
        result *= pibonachi(n - pre);
        System.out.println(result);
    }

    private static int pibonachi(int i) {
        if(fib[i] == 0) {
            fib[i] = pibonachi(i-1) + pibonachi(i-2);
        }
        return fib[i];
    }
}