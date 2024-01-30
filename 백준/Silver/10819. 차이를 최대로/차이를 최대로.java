import java.io.*;

public class Main {

    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int[] result;
    public static int[] numArray;
    public static boolean[] isVisited;
    public static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        numArray = new int[n];
        result = new int[n];
        isVisited = new boolean[n];

        String[] input = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            numArray[i] = Integer.parseInt(input[i]);
        }

        recur(n, 0);

        bw.write(max + "");
        bw.flush();
        bw.close();
    }

    public static void recur(int n, int count) throws IOException {
        if(count == n) {
            int sum = 0;
            int i = result.length-1;
            while(i > 0){
                sum += Math.abs(result[i] - result[i-1]);
                i--;
            }
            max = Math.max(max, sum);
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