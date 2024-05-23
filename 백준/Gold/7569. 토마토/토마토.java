import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static int[][][] box;   // 1부터 h까지의 상자
    private static int h,n,m;
    private static int[] dy = {-1,1,0,0}, dx = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        input(br);
        // 하루가 지날 때마다 익은 토마토(1)에 인접한 익지 않은 토마토(0)가 익는다. (동서남북, 이전박스 같은 위치, 이후박스 같은 위치)
        // 며칠이 지나면 다 익게 되는지 구하라.
        // 가장 밑의 상자부터 주어진다.
        // 익지 않은 토마토는 -1이다.


        System.out.println(bfs());
    }

    public static int bfs(){
        int fresh = 0;

        Queue<int[]> cook = new LinkedList<>();
        for(int z=0; z<h; z++){
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    int t = box[z][i][j];
                    if(t == 1){
                        cook.add(new int[]{z,i,j});
                    }else if(t == 0){
                        fresh++;
                    }
                }
            }
        }
        if(fresh == 0){
            return 0;
        }

        int value = 0;
        while(!cook.isEmpty()){
            int[] tomato = cook.poll();     // 꺼낸 토마토의 개수가 그 전날과 같으면 하루가 지남
            int numH = tomato[0], numN = tomato[1], numM = tomato[2];
            value = box[numH][numN][numM];
            //System.out.println("현재 " + (numH)+ " " + numN + " " + numM + "가 시작됨");

            for(int i=0; i<4; i++){         // 동서남북 익히기
                int nextY = numN + dy[i];
                int nextX = numM + dx[i];
                if(nextY >= 0 && nextY < n && nextX >=0 && nextX < m){
                    if(box[numH][nextY][nextX] == 0){
                        box[numH][nextY][nextX] = 1+value;
                        fresh--;
                        cook.add(new int[]{numH,nextY,nextX});
                        //System.out.println(nextY + " " + nextX + "가 익음");
                    }
                }
            }
            if(numH-1 >= 0 && box[numH-1][numN][numM] == 0){    // 아래 박스 익히기
                box[numH-1][numN][numM] = 1+value;
                cook.add(new int[]{numH-1,numN,numM});
                fresh--;
                //System.out.println((numH-1)+ " " + numN + " " + numM + "가 익음");
            }
            if(numH+1 < h && box[numH+1][numN][numM] == 0){     // 위의 박스 익히기
                box[numH+1][numN][numM] = 1+value;
                cook.add(new int[]{numH+1,numN,numM});
                fresh--;
                //System.out.println((numH+1)+ " " + numN + " " + numM + "가 익음");
            }

//            for(int z=0; z<h; z++){
//                for(int i=0; i<n; i++){
//                    for(int j=0; j<m; j++){
//                        System.out.print(box[z][i][j] + " ");
//                    }
//                    System.out.println();
//                }
//                System.out.println();
//            }
        }
        if(fresh != 0){
            return -1;
        }
        return value-1;
    }

    public static void input(BufferedReader br) throws IOException {
        String[] condition = br.readLine().split(" ");
        m = Integer.parseInt(condition[0]);
        n = Integer.parseInt(condition[1]);
        h = Integer.parseInt(condition[2]);

        box = new int[h][n][m];

        for(int z=0; z<h; z++){
            for(int i=0; i<n; i++){
                String[] line = br.readLine().split(" ");
                for(int j=0; j<m; j++){
                    box[z][i][j] = Integer.parseInt(line[j]);
                }
            }
        }

    }
}

