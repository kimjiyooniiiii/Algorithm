import java.io.*;

public class Main {

    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n, k = 0;
    public static int[][] list = new int[100001][3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        list[1][1] = 1;
        list[2][1] = 1;
        list[2][2] = 1;
        list[3][1] = 2;
        list[3][2] = 2;

        for(int i=4; i<list.length; i++) {
            list[i][1] = (list[i-1][2] + list[i-2][2]) % 1000000009;
            list[i][1] = (list[i][1] + list[i-3][2]) % 1000000009;

            list[i][2] = (list[i-1][1] + list[i-2][1]) % 1000000009;
            list[i][2] = (list[i][2] + list[i-3][1]) % 1000000009;
        }

        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            int a = Integer.parseInt(br.readLine());
            System.out.println(list[a][1] + " " + list[a][2]);
        }
        bw.close();

    }
}