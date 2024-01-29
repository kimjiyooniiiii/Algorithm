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

        int i = first.length-1;
        while(i > 0 && first[i-1] > first[i]) i--;
        if(i == 0) {
            bw.write("-1");
            bw.flush();
            bw.close();
            return;
        }

        int j = first.length-1;
        while(first[i-1] > first[j]) j--;

        swap(first, i-1, j);

        j = first.length-1;
        while(i < j) {
            swap(first, i, j);
            i++; j--;
        }

        for(int a : first) {
            bw.write(a + " ");
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