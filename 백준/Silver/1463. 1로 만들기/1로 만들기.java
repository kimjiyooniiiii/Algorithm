import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int number = Integer.parseInt(br.readLine());
        int[] countArray = new int[number+1];

        //2일때 부터 숫자를 넣음
        for(int i=2; i<=number; i++){
            //경우의 수를 나누어 제일 작은 것으로 리셋
            //배열의 수는 이미 최솟값
            //1을 뺄때
            countArray[i] = countArray[i-1]+1;

            //2로 나눌때
            if(i%2 == 0){
                countArray[i] = Math.min(countArray[i], countArray[i/2]+1);
            }
            //3으로 나눌때
            if(i%3 == 0) {
                countArray[i] = Math.min(countArray[i], countArray[i/3]+1);
            }
        }

        bw.write(String.valueOf(countArray[number]));
        bw.flush();
        bw.close();
    }
}