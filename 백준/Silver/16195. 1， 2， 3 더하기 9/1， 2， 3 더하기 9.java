import java.io.*;

public class Main {

    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n, k = 0;
    public static Long[][] list = new Long[1001][1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<list.length; i++) {
            for(int j=0; j<list[i].length; j++) {
                list[i][j] = 0L;
            }
        }

        list[1][1] = 1L;
        list[2][1] = 1L;
        list[2][2] = 1L;
        list[3][1] = 1L;
        list[3][2] = 2L;
        list[3][3] = 1L;

        for(int i=4; i<list.length; i++) {
            for(int j=1; j<list[i-1].length-1; j++) {
                list[i][j+1] = (list[i][j+1] + list[i-1][j]) % 1000000009;
            }
            for(int j=1; j<list[i-2].length-1; j++) {
                list[i][j+1] = (list[i][j+1] + list[i-2][j]) % 1000000009;
            }
            for(int j=1; j<list[i-3].length-1; j++) {
                list[i][j+1] = (list[i][j+1] + list[i-3][j]) % 1000000009;
            }
        }

        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            Long sum = 0L;
            for(int j=1; j<=m; j++) {
                sum = (sum + list[n][j]) % 1000000009;
            }
            System.out.println(sum);
        }
        bw.close();
    }
}