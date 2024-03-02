import java.io.*;
import java.util.Arrays;

public class Main {

    public static int n;
    public static int[][] map;
    public static boolean[][] visited;
    // 상좌하우
    public static int[] dx = {-1, 0, 1};
    public static int[] dy = {-1, 0, 1};
    public static int count,w,h;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] test;
        while(!Arrays.equals(test = br.readLine().split(" "),new String[]{"0","0"})) {
            w = Integer.parseInt(test[0]);
            h = Integer.parseInt(test[1]);
            map = new int[h][w];
            visited = new boolean[h][w];

            // 지도 입력
            for(int i=0; i<h; i++) {
                String[] line = br.readLine().split(" ");
                for(int j=0; j<w; j++) {
                    map[i][j] = Integer.parseInt(line[j]);
                }
            }

            count = 0;
            for(int i=0; i<h; i++) {
                for(int j=0; j<w; j++) {
                    if(visited[i][j] == false && map[i][j] == 1) {
                        visited[i][j] = true;
                        dfs(i,j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    public static void dfs(int startY, int startX) {// 1 0
        for(int i=0; i<dy.length; i++) {
            for(int j=0; j<dx.length; j++) {
                int nextY = startY + dy[i]; // -1 0 1
                int nextX = startX + dx[j];

                if(nextX>=0 && nextX<w && nextY>=0 && nextY<h) {
                    if(visited[nextY][nextX] == false && map[nextY][nextX] == 1){
                    //    System.out.println(nextY + " " + nextX);

                        visited[nextY][nextX] = true;
                        dfs(nextY, nextX);
                    }
                }
            }
        }
    }
}