import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int[][] array;
    public static int n;
    public static Queue<String> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        bw.write((int)Math.pow(2,n)-1 + "\n");
        recur(n,1,2,3);

        bw.flush();
        bw.close();
    }

    public static void recur(int n, int from, int temp, int to) throws IOException {
        if(n==1){
            bw.write(from + " " + to);
            bw.write("\n");
        }else{
            recur(n-1, from, to, temp);
            bw.write(from + " " + to);
            bw.write("\n");
            recur(n-1, temp, from, to);
        }
    }
}