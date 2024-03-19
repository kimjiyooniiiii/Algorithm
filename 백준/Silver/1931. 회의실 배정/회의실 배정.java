import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());

        int[][] array = new int[size][2];

        for(int i=0; i<size; i++) {
            String[] input = br.readLine().split(" ");
            array[i][0] = Integer.parseInt(input[0]);
            array[i][1] = Integer.parseInt(input[1]);
        }

        Arrays.sort(array, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]){
                    return a[1]-b[1];
                }else{
                    return a[0]-b[0];
                }
            }
        });

        for(int i=0; i<size; i++) {
        //    System.out.println(array[i][0] + " " + array[i][1]);
        }

        int endTime = array[0][1];
        int result = 0;
        for(int i=1; i<size; i++){
            // 시간이 겹칠때
            if(array[i][0] < endTime){
                endTime = Math.min(endTime,array[i][1]);
            }else{
                endTime = array[i][1];
                result++;
            }
        }
        System.out.println(result+1);
    }
}
