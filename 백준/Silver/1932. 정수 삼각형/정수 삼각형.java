import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] triangle = new int[N][N];
		int[][] dp = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++) {
				triangle[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = triangle[0][0];
		int max = dp[0][0];
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0) dp[i][j] = dp[i - 1][j] + triangle[i][j];
				else if (j == N - 1) dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
				else dp[i][j] = Math.max(dp[i - 1][j - 1] + triangle[i][j] , dp[i - 1][j] + triangle[i][j]); 
				
				if (i == N - 1) max = Math.max(max, dp[i][j]);
			}
		}
		
		System.out.println(max);
	}
}