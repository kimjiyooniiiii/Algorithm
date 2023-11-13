import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String[] numberLine = br.readLine().split(" ");
        int[] count = new int[numberLine.length];

        for(int i=0; i<count.length; i++) {
            if(i==0){
                count[i] = 1;
            }else{
                int max = 0;
                for(int j=0; j<i; j++){
                    if(Integer.parseInt(numberLine[j]) < Integer.parseInt(numberLine[i])
                            && count[j] > max){
                        max = count[j];
                    }
                }
                count[i] = max + 1;
            }

        }

        int max = 0;
        int maxIndex = 0;
        for(int i=0; i<count.length; i++){
            if(count[i] > max){
                max = count[i];
                maxIndex = i;
            }
        }

        String result = numberLine[maxIndex];

        int decrease = max-1;

        for(int i=maxIndex-1; i>=0; i--){
            if(count[i] == decrease){
                result = numberLine[i] + " " + result;
                decrease--;
            }
        }

        bw.write(max + "\n" + result);
        bw.flush();
        bw.close();
    }
}