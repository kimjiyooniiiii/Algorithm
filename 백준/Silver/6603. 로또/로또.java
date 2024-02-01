import java.io.*;

public class Main {

    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int k;
    public static int[] s;

    public static int[] result;
    public static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input;
        while(!(input = br.readLine().split(" "))[0].equals("0")) {
            k = Integer.parseInt(input[0]);
            s = new int[k];
            isVisited = new boolean[k];
            result = new int[6];

            for(int i=1; i<input.length; i++) {
                s[i-1] = Integer.parseInt(input[i]);
            }

            recur(0,0);
            bw.write("\n");
            bw.flush();
        }

        bw.close();
    }

    public static void recur(int count, int compare) throws IOException {
        if(count == 6) {
            for(int r : result) {
                bw.write(r + " ");
            }
            bw.write("\n");
        }
        else{
            int before = 0;
            for(int i=0; i<k; i++){
                if(!isVisited[i] && s[i] != before && s[i] > compare){
                    before = s[i];
                    isVisited[i] = true;

                    result[count] = s[i];

                    recur(count+1, s[i]);
                    isVisited[i] = false;
                }
            }
        }
    }

}