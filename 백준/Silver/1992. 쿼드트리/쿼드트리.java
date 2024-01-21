import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static BufferedWriter bw;
    public static int[][] array;
    public static int n;
    public static Queue<String> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        array = new int[n][n];

        for(int i=0; i<n; i++) {
            String[] line = br.readLine().split("");
            for(int j=0; j<line.length; j++) {
                array[i][j] = Integer.parseInt(line[j]);
            }
        }
        recur(0,0,n);

        while(!queue.isEmpty()){
            bw.write(queue.poll());
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }

    public static void recur(int row, int column, int size) {
        if(check(row, column, size)){
            queue.add(String.valueOf(array[row][column]));
        }else{
            queue.add("(");

            int update = size/2;
            recur(row, column, update);
            recur(row, column+update, update);
            recur(row+update, column, update);
            recur(row+update, column+update, update);

            queue.add(")");
        }
    }

    // 모든 수가 같은 수인지
    public static boolean check(int row, int column, int size) {
        int stand = array[row][column];

        for(int i=row; i<row+size; i++) {
            for(int j=column; j<column+size; j++) {
                if(array[i][j] != stand){
                    return false;
                }
            }
        }
        return true;
    }


}