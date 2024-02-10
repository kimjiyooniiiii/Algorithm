import java.io.*;

public class Main {

    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n, max = 0;

    public static long[][] result;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        result = new long[100001][4];
        result[1][1] = 1;
        result[2][2] = 1;
        result[3][1] = 1;
        result[3][2] = 1;
        result[3][3] = 1;

        for(int i=4; i<=100000; i++) {
            result[i][1] = (result[i-1][2] + result[i-1][3])%1000000009;
            result[i][2] = (result[i-2][1] + result[i-2][3])%1000000009;
            result[i][3] = (result[i-3][1] + result[i-3][2])%1000000009;
        }

        for(int j=0; j<t; j++) {
            n = Integer.parseInt(br.readLine());
            bw.write((result[n][1] + result[n][2] + result[n][3])%1000000009 + "\n");
            bw.flush();
        }

        bw.close();
    }

}