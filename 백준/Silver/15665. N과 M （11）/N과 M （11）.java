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
        isVisited = new boolean[n];

        String[] nInput = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            nArray[i] = (Integer.parseInt(nInput[i]));
        }

        Arrays.sort(nArray);
        recur(0, 0);

        bw.flush();
        bw.close();
    }

    public static void recur(int len, int compare) throws IOException {
        if(len == m) {
            for(int a : array) {
                bw.write(a + " ");
            }
            bw.write("\n");
        } else {
            int prev = 0;
            for(int i=0; i<n; i++) {
                if(/*!isVisited[i] &&*/ prev != nArray[i] /*&& nArray[i] >= compare*/){
                    isVisited[i] = true;
                    prev = nArray[i];
                    array[len] = nArray[i];
                    recur(len + 1, nArray[i]);

                    isVisited[i] = false;
                }

            }
        }
    }
}