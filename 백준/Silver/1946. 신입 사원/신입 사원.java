import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = Integer.parseInt(br.readLine());
        for(int t=0; t<test; t++){
            int size = Integer.parseInt(br.readLine());

            int[][] array = new int[size][2];

            for(int i=0; i<size; i++) {
                String[] input = br.readLine().split(" ");
                array[i][0] = Integer.parseInt(input[0]);
                array[i][1] = Integer.parseInt(input[1]);
            }

            Arrays.sort(array,new Comparator<int[]>(){
                @Override
                public int compare(int[] a, int[] b){
                    return a[0]-b[0];
                }
            });

            int count = 1;
            int score = array[0][1];

            for(int i=1; i<size; i++) {
                if(array[i][1] < score){
                    count++;
                    score = array[i][1];
                }
            }
            System.out.println(count);
        }

    }
}
