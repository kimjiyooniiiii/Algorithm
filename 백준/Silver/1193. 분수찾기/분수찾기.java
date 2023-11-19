import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(br.readLine());
        int n = 1;
        int step = 1;
        int up = 1; //분자
        int down = 1;   //분모

        while(x != step) {
            if (x != step) {
                down += 1;
                step++;
            }
            for (int i = 0; i < n; i++) {
                if (x == step) {
                    break;
                } else {
                    up += 1;
                    down -= 1;
                    step++;
                }
            }
            if (x != step) {
                up += 1;
                step++;
            }
            for (int i = 0; i < n + 1; i++) {
                if (x == step) {
                    break;
                } else {
                    up -= 1;
                    down += 1;
                    step++;
                }
            }
            n += 2;
        }

        bw.write(up + "/" + down);

        bw.flush();
        bw.close();
    }
}