import java.io.*;

public class Main {

    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int[][] list = new int[101][10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int j=1; j<=9; j++) {
            list[1][j] = 1;
        }

        for(int i=2; i<list.length; i++) {
            list[i][0] = list[i-1][1];
            for(int j=1; j<=8; j++) {
                list[i][j] = (list[i-1][j-1] + list[i-1][j+1]) % 1000000000;
            }
            list[i][9] = list[i-1][8];
        }

        int input = Integer.parseInt(br.readLine());
        int result = 0;
        for(int i=0; i<10; i++) {
            result  = (result + list[input][i]) % 1000000000;
        }
        System.out.println(result);
        bw.close();
    }
}