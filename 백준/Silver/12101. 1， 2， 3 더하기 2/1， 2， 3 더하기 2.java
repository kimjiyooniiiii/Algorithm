import java.io.*;

public class Main {

    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n, k = 0;
    public static int[] array;
    public static Long count = 0L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input  = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);

        array = new int[n];
        recur(0,0);

        if(count < 2147483648L){
            System.out.println("-1");
        }
        bw.flush();
        bw.close();
    }

    public static void recur(int sum, int position) {
        if(sum == n){
            count++;
            if(k == count){
                for(int i=0; i<position-1; i++) {
                    System.out.print(array[i] + "+");
                }
                System.out.print(array[position-1] + "\n");
                count = 2147483648L;
            }
        } else {
            for(int i=1; i<=3; i++) {
                if(sum+i <= n){
                    array[position] = i;
                    recur(sum + i, position + 1);
                } else {
                    break;
                }
            }
        }
    }
}