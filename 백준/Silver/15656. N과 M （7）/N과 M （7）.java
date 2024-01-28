import java.io.*;
import java.util.Arrays;

public class Main {

    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n, m;
    public static boolean[] isVisited;
    public static int[] array;
    public static int[] nArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        array = new int[m];
        nArray = new int[n];
        //isVisited = new boolean[n];

        String[] nInput = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            nArray[i] = Integer.parseInt(nInput[i]);
        }
        Arrays.sort(nArray);

        recur(0);

        bw.flush();
        bw.close();
    }

    public static void recur(int len) throws IOException {
        if(len == m) {
            for(int a : array) {
                bw.write(a + " ");
            }
            bw.write("\n");
        } else {
            for(int i=0; i<n; i++) {
                array[len] = nArray[i];
                recur(len + 1);
            }
        }
    }


}