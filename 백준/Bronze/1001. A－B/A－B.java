import java.io.*;
import java.util.List;

public class Main {

    public static BufferedWriter bw;
    public static String[][] array;
    public static List<String> result;
    public static boolean[] visited;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*n = Integer.parseInt(br.readLine());
        array = new String[n][n];

        firstRecur(0,0,n);

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                bw.write(array[i][j] + "");
            }
            bw.write("\n");
        }*/

        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        bw.write((a-b) + "");
        bw.flush();
        bw.close();
    }

    /*public static void firstRecur(int rowEnd, int columnEnd, int size) throws IOException {
        if(size == 1) {
            array[rowEnd-1][columnEnd-1] = "*";
        }else{
            firstRecur(size/3,size/3, size/3); // 9개 영역중 첫번째 영역
            firstRecur(size/3,size/3*2, size/3);
            firstRecur(size/3,size, size/3);
            firstRecur(size/3*2,size/3, size/3);
            *//*firstRecur(size/3*2,size/3*2, size/3);*//*
            firstRecur(size/3*2,size, size/3);
            firstRecur(size,size/3, size/3);
            firstRecur(size,size/3*2, size/3);
            firstRecur(size,size, size/3);

        }

    }*/

}