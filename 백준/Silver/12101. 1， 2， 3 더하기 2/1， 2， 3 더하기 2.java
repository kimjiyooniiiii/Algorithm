import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n, k = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input  = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);

        ArrayList<String>[] array = new ArrayList[11];
        for(int i=0; i<11; i++) {
            array[i] = new ArrayList<>();
        }
        array[1].add("1");
        array[2].add("1+1");
        array[2].add("2");
        array[3].add("1+1+1");
        array[3].add("1+2");
        array[3].add("2+1");
        array[3].add("3");

        for(int i=4; i<=n; i++) {
            for(int j=1; j<=3; j++) {
                for(String s : array[i-j]){
                    array[i].add(s + "+" + j);
                }
            }
        }

        if(array[n].size() < k) {
            bw.write("-1");
        } else {
            array[n].sort(Comparator.naturalOrder());
            bw.write(array[n].get(k-1));
        }

        bw.flush();
        bw.close();
    }
}