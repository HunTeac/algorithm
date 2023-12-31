import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited; // 방문 체크
	static String[] arr; // A 배열
	static String[] p; // 순열
	static String A;
	static String B;
	static int max; // 최댓값
	static boolean chk; // 가능 여부
	
	// 순열 알고리즘
	static void permutation(int idx, int len) {
		if (chk) return;
		if (idx == len) {
			if (p[0].equals("0")) return;
			String tmp = "";
			for (String s : p) tmp += s;
			if (Integer.parseInt(tmp) < Integer.parseInt(B)) {
				chk = true;
				max = Integer.parseInt(tmp); // B보다 작은 수 중 최댓값
			}
			return;
		}
		
		for (int i = 0; i < len; i++) {
			if (visited[i]) continue;
			visited[i] = true; // 원소 선택
			p[idx] = arr[i];
			permutation(idx + 1, len);
			visited[i] = false; // 원소 선택 X
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = st.nextToken();		
		B = st.nextToken();	
		
		if (A.length() > B.length()) {
			System.out.println(-1);
			return;
		}

		arr = A.split("");
		visited = new boolean[A.length()];
		p = new String[A.length()];
		
		// 내림차순 정렬
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.charAt(0) - o1.charAt(0);
			}
		});
		
		chk = false;
		
		permutation(0, p.length);
		
		if (chk) System.out.println(max); // 가능한 경우
		else System.out.println(-1); // 불가능한 경우
	}
}