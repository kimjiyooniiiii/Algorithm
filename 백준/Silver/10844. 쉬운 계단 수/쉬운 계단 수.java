import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] array = new int[101][10];

        for(int j=1; j<array[1].length; j++) {
            array[1][j] = 1;
        }

        for(int i=2; i<array.length; i++) {
            for(int j=0; j<array[i].length; j++) {
                if(j == 0){
                    array[i][j] = array[i-1][j+1];
                }
                else if(j == 9){
                    array[i][j] = array[i-1][j-1];
                }
                else{
                    array[i][j] = (array[i-1][j-1] + array[i-1][j+1]) % 1000000000;
                }
            }
        }

        int test = Integer.parseInt(br.readLine());
        int result = 0;

        for(int j=0; j<array[test].length; j++) {
            result = (result + array[test][j]) % 1000000000;
        }
        bw.write(result + "");
        bw.flush();

        bw.close();
    }
}