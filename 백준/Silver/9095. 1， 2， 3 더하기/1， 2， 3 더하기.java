import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = Integer.parseInt(br.readLine());
        int[] countArray = new int[12];

        for(int i=1; i<countArray.length; i++) {
            if(i<=2) {
                countArray[i] = i;
            }else if(i==3){
                countArray[i] = 4;
            }else{
                countArray[i] = countArray[i-3] + countArray[i-2] + countArray[i-1];
            }
        }

        for(int i=0; i<test; i++) {
            int tCase = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(countArray[tCase]) + "\n");
            bw.flush();
        }
        bw.close();
    }
}