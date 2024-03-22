import java.io.*;

public class Main {


    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] condition = br.readLine().split(" ");
        int count = Integer.parseInt(condition[0]);
        int days = Integer.parseInt(condition[1]);

        int[] array = new int[count];
        String[] inputDay = br.readLine().split(" ");
        for(int i=0; i<count; i++){
            array[i] = Integer.parseInt(inputDay[i]);
        }
        int max = 0;
        for(int i=0; i<days; i++){
            max += array[i];
        }

        int sum = max;
        for(int i=days; i<count; i++){
            sum -= array[i-days];
            sum += array[i];

            max = Math.max(max,sum);
        }

        System.out.println(max);
    }
}
