import java.io.*;

public class Main {

    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n, k = 0;
    public static int[][] list = new int[10001][4];
    public static Long count = 0L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        list[1][1] = 1;
        list[2][1] = 1;
        list[2][2] = 1;
        list[3][1] = 1;
        list[3][2] = 1;
        list[3][3] = 1;

        for(int i=4; i<list.length; i++) {
            list[i][1] = list[i-1][1];
            list[i][2] = list[i-2][1] + list[i-2][2];
            list[i][3] = list[i-3][1] + list[i-3][2] + list[i-3][3];
        }

        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(list[n][1] + list[n][2] + list[n][3]);
        }
        bw.close();
    }
}