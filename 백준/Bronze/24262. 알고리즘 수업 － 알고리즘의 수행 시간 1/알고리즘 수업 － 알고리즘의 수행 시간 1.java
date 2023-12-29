import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static BigInteger count = new BigInteger("2");
    public static List<String> list = new ArrayList<>();
    public static int i;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int n = Integer.parseInt(s);
        bw.write(1 + "\n" + "0" + "\n");
        bw.flush();
        bw.close();
    }

}