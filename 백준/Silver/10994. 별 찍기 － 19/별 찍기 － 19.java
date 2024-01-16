import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static BufferedWriter bw;
    public static String[][] array;
    public static List<String> result = new ArrayList<>();
    public static boolean[] visited;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        int size = 4*n-3;
        array = new String[size][size];

        firstRecur(n, 0);

        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                bw.write(array[i][j] + "");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static void firstRecur(int n, int count) {
        int size = 4*n-3;

        if(n == 1){
            array[count][count] = "*";
        }else{
            start(size, count);
            firstRecur(n-1, count+2);
        }
    }

    public static void start(int n, int count) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i>=1 && i<n-1 && j>=1 && j<n-1) {
                    array[i+count][j+count] = " ";
                }else{
                    array[i+count][j+count] = "*";
                }

            }
        }
    }

}