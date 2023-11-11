import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long [][] array = new long[91][2];     // 90자릿수, 요소는 0과 1

        array[1][0] = 0L;
        array[1][1] = 1L;

        for(int i=2; i<array.length; i++) {
            for(int j=0; j<array[i].length; j++) {
                if(j == 1) {
                    array[i][j] = array[i-1][0];
                }
                else{
                    array[i][j] = array[i-1][0] + array[i-1][1];
                }
            }
        }

       /* for(int i=1; i<array.length; i++) {
            for(int j=0; j<array[i].length; j++) {
                bw.write(array[i][j] + " ");
                bw.flush();
            }
            bw.write("\n");
            bw.flush();
        }*/

        int n = Integer.parseInt(br.readLine());

        bw.write((array[n][0] + array[n][1]) + "");
        bw.flush();
        /*array[2][0] = array[1][0] + array[1][1];    //1
        array[2][1] = array[1][0];  //0

        array[3][0] = array[2][0] + array[2][1];    //1
        array[3][1] = array[2][0];  //1*/

        bw.close();
    }
}