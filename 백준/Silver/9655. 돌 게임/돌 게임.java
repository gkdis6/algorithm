import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        if(n%2 == 0) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }
    }
}