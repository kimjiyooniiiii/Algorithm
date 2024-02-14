import java.io.*;

public class Main {

    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n, k = 0;
    public static Long[] dp = new Long[1000000];
    public static Long count = 0L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp[0] = 1L;
        dp[1] = 2L;
        dp[2] = 4L;

        for(int i=3; i<dp.length; i++){
            dp[i] = (dp[i-3] + dp[i-2] + dp[i-1]) % 1000000009;
        }

        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(dp[n-1] + "\n");
            bw.flush();
        }
        bw.close();
    }

}