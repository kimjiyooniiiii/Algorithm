import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] array = br.readLine().split(" ");

        long a = Long.parseLong(array[0] + array[1]);
        long b = Long.parseLong(array[2] + array[3]);

        bw.write(String.valueOf(a+b));
        bw.flush();
        bw.close();
    }
}
