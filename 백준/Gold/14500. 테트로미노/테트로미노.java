import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[][] matrix = new int[n][m];

        for(int i=0; i<n; i++){
            String[] line= br.readLine().split(" ");
            for(int j=0; j<m; j++){
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }

        int max = 0;
        //-------------------------------------------
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i+2 < n && j+1 < m){
                    int sum = matrix[i][j];
                    sum += matrix[i+1][j];
                    sum += matrix[i+2][j];
                    sum += matrix[i+2][j+1];
                    max = Math.max(max,sum);

                    sum = matrix[i][j];
                    sum += matrix[i][j+1];
                    sum += matrix[i+1][j];
                    sum += matrix[i+2][j];
                    max = Math.max(max,sum);

                    sum = matrix[i][j];
                    sum += matrix[i][j+1];
                    sum += matrix[i+1][j+1];
                    sum += matrix[i+2][j+1];
                    max = Math.max(max,sum);

                    sum = 0;
                    sum += matrix[i+2][j];
                    sum += matrix[i][j+1];
                    sum += matrix[i+1][j+1];
                    sum += matrix[i+2][j+1];
                    max = Math.max(max,sum);

                    ///////////////////////

                    sum = matrix[i][j];
                    sum += matrix[i+1][j];
                    sum += matrix[i+1][j+1];
                    sum += matrix[i+2][j+1];
                    max = Math.max(max,sum);

                    sum = 0;
                    sum += matrix[i+1][j];
                    sum += matrix[i+2][j];
                    sum += matrix[i][j+1];
                    sum += matrix[i+1][j+1];
                    max = Math.max(max,sum);

                    ///////////////////////

                    sum = matrix[i][j];
                    sum += matrix[i+1][j];
                    sum += matrix[i+2][j];
                    sum += matrix[i+1][j+1];
                    max = Math.max(max,sum);

                    sum = 0;
                    sum += matrix[i+1][j];
                    sum += matrix[i][j+1];
                    sum += matrix[i+1][j+1];
                    sum += matrix[i+2][j+1];
                    max = Math.max(max,sum);
                }
                if(i+1 < n && j+2 < m){
                    int sum = matrix[i][j];
                    sum += matrix[i][j+1];
                    sum += matrix[i][j+2];
                    sum += matrix[i+1][j+2];
                    max = Math.max(max,sum);

                    sum = matrix[i][j];
                    sum += matrix[i][j+1];
                    sum += matrix[i][j+2];
                    sum += matrix[i+1][j];
                    max = Math.max(max,sum);

                    sum = 0;
                    sum += matrix[i][j+2];
                    sum += matrix[i+1][j];
                    sum += matrix[i+1][j+1];
                    sum += matrix[i+1][j+2];
                    max = Math.max(max,sum);

                    sum = matrix[i][j];
                    sum += matrix[i+1][j];
                    sum += matrix[i+1][j+1];
                    sum += matrix[i+1][j+2];
                    max = Math.max(max,sum);

                    ///////////////////////

                    sum = matrix[i][j];
                    sum += matrix[i][j+1];
                    sum += matrix[i+1][j+1];
                    sum += matrix[i+1][j+2];
                    max = Math.max(max,sum);

                    sum = 0;
                    sum += matrix[i+1][j];
                    sum += matrix[i+1][j+1];
                    sum += matrix[i][j+1];
                    sum += matrix[i][j+2];
                    max = Math.max(max,sum);

                    ///////////////////////

                    sum = matrix[i][j];
                    sum += matrix[i][j+1];
                    sum += matrix[i][j+2];
                    sum += matrix[i+1][j+1];
                    max = Math.max(max,sum);

                    sum = 0;
                    sum += matrix[i][j+1];
                    sum += matrix[i+1][j];
                    sum += matrix[i+1][j+1];
                    sum += matrix[i+1][j+2];
                    max = Math.max(max,sum);
                }
                if(i+1 < n && j+1 < m){
                    int sum = matrix[i][j];
                    sum += matrix[i][j+1];
                    sum += matrix[i+1][j];
                    sum += matrix[i+1][j+1];
                    max = Math.max(max,sum);
                }
                if(j+3 < m){
                    int sum = matrix[i][j];
                    sum += matrix[i][j+1];
                    sum += matrix[i][j+2];
                    sum += matrix[i][j+3];
                    max = Math.max(max,sum);
                }
                if(i+3 < n){
                    int sum = matrix[i][j];
                    sum += matrix[i+1][j];
                    sum += matrix[i+2][j];
                    sum += matrix[i+3][j];
                    max = Math.max(max,sum);
                }
            }
        }
        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }

}