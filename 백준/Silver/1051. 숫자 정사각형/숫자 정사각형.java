import java.io.*;

public class Main {
    static int[][] matrix = new int[5][5];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] order = br.readLine().split(" ");
        int row = Integer.parseInt(order[0]);
        int column = Integer.parseInt(order[1]);

        int[][] matrix = new int[row][column];
        for(int i=0; i<matrix.length; i++){
            String line = br.readLine();

            for(int j=0; j<matrix[i].length; j++){
                matrix[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        int min = Math.min(row,column);
        int size = min-1;

        while(size+1 > 0){
            for(int i=0; i+size<row; i++){
                for(int j=0; j+size<column; j++){

                    int standard = matrix[i][j];
                    if(matrix[i][j+size]==standard && matrix[i+size][j]==standard && matrix[i+size][j+size]==standard){
                        bw.write((int)Math.pow(size+1,2)+"");
                        bw.flush();
                        return;
                    }
                }
            }
            size--;
        }

        bw.close();
    }
}