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

        n = Integer.parseInt(br.readLine());
        array = new String[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                array[i][j] = " ";
            }
        }

        firstRecur(0,0,n);

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                bw.write(array[i][j] + "");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static void firstRecur(int row, int column, int size) throws IOException {
        if(size == 1) {
            array[row][column] = "*";
        }else{
            int len = size/3;
            for(int i=0; i<size; i+=size/3){
                for(int j=0; j<size; j+=size/3){
                    if(!(i >= len && i<2*len && j >= len && j<2*len)){
                       /* for(int x=len; x<len*2; x++){
                            for(int y=len; y<len*2; y++){
                                array[x][y] = " ";
                            }
                        }*/
                        firstRecur(i+row,j+column,size/3);
                    }
                   /* else{
                        firstRecur(i+row,j+column,size/3);
                    }*/
                }
            }
        }
    }

}