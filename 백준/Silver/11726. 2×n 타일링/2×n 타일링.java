import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int number = Integer.parseInt(br.readLine());
        int[] countArray = new int[number+1];

        for(int i=1; i<=number; i++){
            if(i<=2){
                countArray[i] = i;
            }else{
                countArray[i] = (countArray[i-1] + countArray[i-2]) % 10007;
            }
        }

        bw.write(String.valueOf(countArray[number]));
        bw.flush();
        bw.close();
    }
}