import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static String[][] map = new String[5][5];
    public static int[] pick;
    public static int result = 0;
    public static int[] dy = {-1,1,0,0};
    public static int[] dx = {0,0,1,-1};
    public static boolean[] pickVisit = new boolean[25];

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=0; i<5; i++){
            String[] input = br.readLine().split("");
            for(int j=0; j<5; j++){
                map[i][j] = input[j];
            }
        }

        // 25개 중 7개를 고르는 함수
        pick = new int[7];
        pick7(-1,0);
       // pick = new int[]{0,1,2,5,7,8,9};
        bfs();
        System.out.println(result);
    }

    public static void pick7(int current, int count){
        if(count == 7){
            // 7개가 이어져 있는지, 임도연 파가 4개 미만인지
            int bfs = bfs();
            if(bfs != -1){
                result++;
            }
            return;
        }
        for(int i=0; i<25; i++){
            if(pickVisit[i] == false && current<i){
                pick[count] = i;
                pickVisit[i] = true;
                pick7(i,count+1);
                pickVisit[i] = false;
            }
        }
    }

    public static int bfs(){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visit = new boolean[5][5];
        int y = pick[0]/5;
        int x = pick[0]%5;

        int count = 1;
        int countY = 0;

        if(map[y][x].equals("Y")){countY++;}
        q.add(new int[]{y, x}); // 열과 행을 q에 넣음
        visit[y][x] = true;

        while(!q.isEmpty()){
            int[] poll = q.poll();

            for(int i=0; i<4; i++){
                int nextY = poll[0] + dy[i];
                int nextX = poll[1] + dx[i];

                if(nextY >= 0 && nextX >= 0 && nextY < 5 && nextX < 5 && visit[nextY][nextX] == false){
                    for(int j=1; j<7; j++){
                        if(nextY == pick[j]/5 && nextX == pick[j]%5){
                            visit[nextY][nextX] = true;
                            count++;
                            q.add(new int[]{nextY,nextX});

                            if(map[nextY][nextX].equals("Y")){
                                countY++;
                            }
                        }
                    }
                }
            }
        }
        if(count == 7 && countY < 4){
            return countY;
        }else{
            return -1;
        }
    }

}
