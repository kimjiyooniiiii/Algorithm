import java.io.*;

public class Main {

    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n, k = 0;
    public static int[][] list = new int[1001][1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        list[1][1] = 1;
        list[2][1] = 1;
        list[2][2] = 1;
        list[3][1] = 1;
        list[3][2] = 2;
        list[3][3] = 1;

        for(int i=4; i<list.length; i++) {
            for(int j=1; j<1000; j++) {
                //long a = (list[i-3][j] + list[i-2][j]);
                int a = (list[i-3][j] + list[i-2][j])% 1000000009;
                list[i][j+1] = (a + list[i-1][j]) % 1000000009;
            }
        }

        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            String[] s = br.readLine().split(" ");
            System.out.println(list[Integer.parseInt(s[0])][Integer.parseInt(s[1])]);
        }
        bw.close();
    }
}