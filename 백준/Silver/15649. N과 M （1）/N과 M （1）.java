import java.io.*;

public class Main {

    public static int n, m;
    public static int[] numArray;
    public static boolean[] isUsed;
    public static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        // 1부터 n까지의 수로 길이가 m인 수열을 만들어라

        numArray = new int[m];
        isUsed = new boolean[n+1];

        recur(0);
        bw.close();
    }

    public static void recur(int count) throws IOException {
        if(count == m) {
            for(int i=0; i<m-1; i++) {
                bw.write(numArray[i] + " ");
                bw.flush();
            }
            bw.write(numArray[m-1] + "\n");
            bw.flush();
        }else{
            for(int i=1; i<=n; i++){
                if(!isUsed[i]){
                    isUsed[i] = true;
                    numArray[count] = i;
                    recur(count+1);
                    isUsed[i] = false;
                }
            }
        }
    }


}