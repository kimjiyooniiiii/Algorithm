import java.io.*;

public class Main {

    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n, m;
    public static boolean[] isVisited;
    public static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        array = new int[m];

        recur(0);
        bw.flush();
        bw.close();
    }

    public static void recur(int count) throws IOException {
        if(count == m) {
            for(int a : array) {
                bw.write(a + " ");
            }
            bw.write("\n");

        } else{
            for(int i=0; i<n; i++) {
                    array[count] = i+1;
                    recur(count+1);
            }
        }
    }

}