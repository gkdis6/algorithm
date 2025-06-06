import java.io.*;

class Main {
	public static StringBuilder sb = new StringBuilder();
	public static int M;

	public static void hanoi(int N, char from, char to, char rest) {
		if (N == 1) {
			move(from, to);
			return;
		}

		hanoi(N - 1, from, rest, to);
		hanoi(1, from, to, rest);
		hanoi(N - 1, rest, to, from);
	}

	public static void dHanoi(int N, char from, char to, char rest1, char rest2) {
		if (N == 1) {
			move(from, to);
			return;
		} else if (N == 2) {
			move(from, rest2);
			move(from, to);
			move(rest2, to);
			return;
		}

		hanoi(N - 2, from, rest1, rest2);  // 1. (N - 2)개를 D가 아닌 기둥으로 옮기기
		move(from, rest2);  // 2. 두 번째로 큰 원판을 D가 아닌 비어있는 기둥으로 옮기기
		move(from, to);	  // 3. 가장 큰 원판을 D로 옮기기
		move(rest2, to);  // 4. 두 번째로 큰 원판을 D로 옮기기
		dHanoi(N - 2, rest1, to, from, rest2);	
	}

	public static void move(char from, char to) {
		sb.append(from).append(' ').append(to).append('\n');
		M++;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dHanoi(N, 'A', 'D', 'B', 'C');
		System.out.println(M);
		System.out.println(sb);
		br.close();
	}
}