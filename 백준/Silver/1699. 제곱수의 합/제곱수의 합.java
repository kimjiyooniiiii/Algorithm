import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] minArray = new int[n+1];

        for(int i=1; i<n+1; i++) {
            if(Math.sqrt(i) % 1 == 0 ){
                minArray[i] = 1;
            }else{
                int min = n;
                for(int j=1; j<=i/2; j++){
                    int sum = minArray[j] + minArray[i-j];
                    if(min > sum){
                        min = sum;
                    }
                }
                minArray[i] = min;
            }
        }// 코드가 맘에 안드는데 고칠려니 너무 어려워.

            bw.write(minArray[n] + "");

        bw.flush();
        bw.close();
    }

}