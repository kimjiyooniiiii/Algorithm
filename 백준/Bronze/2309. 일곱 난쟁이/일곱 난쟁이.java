import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] tallArray = new int[9];
        int sum = 0;
        int false1 = 0;
        int false2 = 0;

        for(int i=0; i<9; i++) {
            tallArray[i] = Integer.parseInt(br.readLine());
            sum += tallArray[i];
        }
        Arrays.sort(tallArray);

        boolean isFinish = false;

        for(int i=0; i<9; i++) {
            for(int j=i+1; j<9; j++){
                if(sum - (tallArray[i] + tallArray[j]) == 100){
                    false1 = tallArray[i];
                    false2 = tallArray[j];
                    isFinish = true;
                    break;
                }
            }
            if(isFinish){
                break;
            }
        }

        for(int i=0; i<9; i++){
            if(tallArray[i] != false1 && tallArray[i] != false2){
                bw.write(tallArray[i] + "\n");
            }
        }
        bw.flush();
        bw.close();
    }

}