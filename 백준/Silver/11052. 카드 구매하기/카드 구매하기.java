import java.io.*;

public class Main {

    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n, max = 0;

    public static int[][] matrix;

    public static int[] price;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        price = new int[n+1];
        dp = new int[n+1];

        String[] input = br.readLine().split(" ");
        for(int i=1; i<=n; i++) {
            price[i] = Integer.parseInt(input[i-1]);
        }

        for(int i=0; i<=n; i++) {
            for(int j=0; j<i; j++) {
                dp[i] = Math.max(dp[i], dp[j] + price[i-j]);
            }
        }

            bw.write(dp[n] + "");

        bw.flush();
        bw.close();
    }
}