import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String [] arrayInput = br.readLine().split(" ");
        int[] sumList = new int[n];

        for(int current=0; current<arrayInput.length; current++){
            int number = Integer.parseInt(arrayInput[current]);
            if(current == 0){
                sumList[current] = number;
            }else{
                int prevSum = sumList[current-1] + number;

                if(prevSum < number){
                    sumList[current] = number;
                }else{
                    sumList[current] = prevSum;
                }
            }

        }

        int max = -1000;
        for(int current=0; current<arrayInput.length; current++){
            if(max < sumList[current]){
                max = sumList[current];
            }
        }
        bw.write(max+"");
        bw.flush();
        bw.close();
    }
}