import java.io.*;

public class Main {

    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] first = new int[input.length];

        for(int i=0; i<input.length; i++) {
            first[i] = Integer.parseInt(input[i]);
        }

        // 오름차순의 시작을 찾음
        int i = first.length-1;
        while(i > 0 && first[i-1] < first[i]) i--;

        int j = first.length-1;
        if(i == 0) bw.write("-1");
        else {
            while(first[i-1] < first[j]) j--;
            swap(first, i-1, j);

            j = first.length-1;
            while(i < j){
                swap(first, i, j);
                i++; j--;
            }

            for(int f : first){
                bw.write(f + " ");
            }
        }

        bw.flush();
        bw.close();
    }

    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

}