import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count5 = n / 5;
        int totalCount = -1; // 거슬러 줄 수 없는 경우를 대비해 -1로 초기화

        while (count5 >= 0) {
            int remaining = n - count5 * 5;
            if (remaining % 2 == 0) {
                int count2 = remaining / 2;
                totalCount = count5 + count2;
                break; // 최소 개수를 찾았으므로 반복 종료
            }
            count5--; // 5원짜리 개수를 줄여서 다시 시도
        }

        System.out.println(totalCount);
    }
}
