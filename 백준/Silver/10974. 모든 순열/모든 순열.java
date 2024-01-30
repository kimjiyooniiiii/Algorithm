import java.io.*;

public class Main {

    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int[] result;
    public static int[] numArray;
    public static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        numArray = new int[n];
        result = new int[n];
        isVisited = new boolean[n];

        for(int i=0; i<n; i++) {
            numArray[i] = i+1;
        }

        recur(n, 0);

        bw.flush();
        bw.close();
    }

    public static void recur(int n, int count) throws IOException {
        if(count == n) {
            for(int r : result){
                bw.write(r + " ");
            }
            bw.write("\n");
        } else {
            for(int i=0; i<n; i++) {
                if(!isVisited[i]){
                    isVisited[i] = true;
                    result[count] = numArray[i];

                    recur(n, count+1);
                    isVisited[i] = false;
                }
            }
        }
    }

}