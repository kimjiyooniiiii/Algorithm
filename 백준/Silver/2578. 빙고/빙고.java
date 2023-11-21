import java.io.*;

public class Main {
    static int[][] matrix = new int[5][5];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=0; i<matrix.length; i++){
            String[] line = br.readLine().split(" ");
            for(int j=0; j<matrix[i].length; j++){
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }// 빙고판 입력완료

        int[][] erase = new int[5][5];
        int bingoCount = 0;

        for(int i=0; i<erase.length; i++){
            String[] line = br.readLine().split(" ");
            for(int j=0; j<erase[i].length; j++){
                erase[i][j] = Integer.parseInt(line[j]);
            }
        }// 지우는 리스트 입력완료

        int result = 0;
        for(int i=0; i<erase.length; i++){
            for(int j=0; j<erase[i].length; j++){
                bingoCount = checkBingo(erase[i][j], bingoCount);
                result++;
                if(bingoCount >= 3){
                    bw.write(result + "\n");
                    bw.flush();
                    return;
                }
            }
        }

        bw.close();
}
        public static int checkBingo (int eraseNum, int bingoCount)throws IOException {
            boolean isBreak = false;
            int x=0, y=0;
            for(int i=0; i<matrix.length; i++){
                for(int j=0; j<matrix[i].length; j++){
                    if(matrix[i][j] == eraseNum){
                        matrix[i][j] = 0;
                        x = i;
                        y = j;
                        isBreak = true;
                        break;
                    }
                }
                if(isBreak){
                    break;
                }
            }

            int count = 0;
            //행 체크
            for(int i=0; i<5; i++){
                if(matrix[x][i] != 0){
                    break;
                }else{
                    count++;
                }
            }
            if(count == 5) bingoCount++;
            count = 0;

            // 열체크
            for(int i=0; i<5; i++){
                if(matrix[i][y] != 0){
                    break;
                }else{
                    count++;
                }
            }
            if(count == 5) bingoCount++;
            count = 0;

            //왼->오 대각선 체크
            if(x==y){
                for(int i=0; i<5; i++){
                    if(matrix[i][i] != 0){
                        break;
                    }else{
                        count++;
                    }
                }
            }
            if(count == 5) bingoCount++;
            count = 0;

            //오->왼 대각선 체크
            if(x+y == 4){
                for(int i=0; i<5; i++){
                    if(matrix[i][4-i] != 0){
                        break;
                    }else{
                        count++;
                    }
                }
            }
            if(count == 5) bingoCount++;

            return bingoCount;
        }
}