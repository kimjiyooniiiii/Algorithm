import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int longSize = 0;
        Character[][] matrix = new Character[n][n];
        for(int i=0; i<n; i++){
            String input = br.readLine();
            for(int j=0; j<n; j++){
                matrix[i][j] = input.charAt(j);
            }
            longSize = Math.max(longSize,longCount(matrix[i]));

        }
        for(int i=0; i<n; i++){
            Character[] column = new Character[n];
            for(int j=0; j<n; j++){
                column[j] = matrix[j][i];
            }
            longSize = Math.max(longSize,longCount(column));
        }//바꾸지 않았을 때 제일 큰값

        //가로 바꾸기
        for(int i=0; i<n; i++){
            for(int j=0; j<n-1; j++){
                char temp = matrix[i][j];
                matrix[i][j] = matrix[i][j+1];
                matrix[i][j+1] = temp;

                longSize = Math.max(longSize,longCount(matrix[i]));

                Character[] column = new Character[n];
                for(int z=0; z<n; z++){
                    column[z] = matrix[z][j];
                }
                longSize = Math.max(longSize,longCount(column));

                for(int z=0; z<n; z++){
                    column[z] = matrix[z][j+1];
                }
                longSize = Math.max(longSize,longCount(column));

                temp = matrix[i][j];
                matrix[i][j] = matrix[i][j+1];
                matrix[i][j+1] = temp;
            }
        }

        //세로 바꾸기
        for(int i=0; i<n; i++){
            for(int j=0; j<n-1; j++){
                char temp = matrix[j][i];
                matrix[j][i] = matrix[j+1][i];
                matrix[j+1][i] = temp;

                longSize = Math.max(longSize,longCount(matrix[j]));
                longSize = Math.max(longSize,longCount(matrix[j+1]));

                Character[] column = new Character[n];
                for(int z=0; z<n; z++){
                    column[z] = matrix[z][i];
                }
                longSize = Math.max(longSize,longCount(column));

                temp = matrix[j][i];
                matrix[j][i] = matrix[j+1][i];
                matrix[j+1][i] = temp;
            }
        }

        System.out.println(longSize);


    }

    public static int longCount(Character[] line){
        int longSize = 0;
        int currentSize = 0;
        char current = ' ';

        for(int i=0; i<line.length; i++){
            if(line[i] == current){
                currentSize++;
            }else{
                currentSize = 1;
                current = line[i];
            }
            if(currentSize > longSize){
                longSize = currentSize;
            }
        }
        return longSize;
    }

}