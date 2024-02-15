import java.io.*;
import java.util.List;

public class Main {

    public static BufferedWriter bw;
    public static String[][] array;
    public static List<String> result;
    public static boolean[] visited;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        bw.write((a*b) + "");
        bw.flush();
        bw.close();
    }

}