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
        isVisited = new boolean[n];
        array = new int[m];

        recur(0, 0);

        bw.close();
    }

    public static void recur(int count, int current) throws IOException {
        if(count == m) {
            for(int a : array) {
                bw.write(a + " ");
                bw.flush();
            }
            bw.write("\n");
            bw.flush();
        } else{
            for(int i=0; i<n; i++) {
                if(!isVisited[i] && (i+1) > current) {
                    isVisited[i] = true;
                    array[count] = i+1;
                    recur(count+1, i+1);
                    isVisited[i] = false;
                }
            }
        }
    }

}