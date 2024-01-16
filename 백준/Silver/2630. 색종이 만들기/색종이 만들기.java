import java.io.*;

public class Main {

    public static BufferedWriter bw;
    public static int[][] array;
    public static int blue = 0;
    public static int white = 0;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        array = new int[n][n];

        for(int i=0; i<n; i++) {
            String[] line = br.readLine().split(" ");
            for(int j=0; j<line.length; j++) {
                array[i][j] = Integer.parseInt(line[j]);
            }
        }
        firstRecur(0,0,n);

        bw.write(white + "\n" + blue + "\n");
        bw.flush();
        bw.close();
    }

    public static void firstRecur(int row, int column, int size) {
        if(isPass(row,column,size)){
            if(array[row][column] == 1){
                blue++;
            }else{
                white++;
            }
        }else{
            int half = size/2;
            firstRecur(row,column,half);
            firstRecur(row,column+half,half);
            firstRecur(row+half,column,half);
            firstRecur(row+half,column+half,half);
        }
    }

    public static boolean isPass(int row, int column, int size) {
        int stand = array[row][column];

        for(int i=row; i<row+size; i++) {
            for(int j=column; j<column+size; j++){
                if(array[i][j] != stand){
                    return false;
                }
            }
        }
        return true;
    }


}