import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static int n;
    public static int[][] map;
    public static boolean[][] visited;
    // 상좌하우
    public static int[] dx = {-1, 0, 0, 1};
    public static int[] dy = {0, 1, -1, 0};
    public static int count,w,h;
    public static Queue<int[]> queue = new LinkedList<>();

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] wh = br.readLine().split(" ");
            w = Integer.parseInt(wh[0]);
            h = Integer.parseInt(wh[1]);
            map = new int[h][w];
            visited = new boolean[h][w];

            // 지도 입력
            for(int i=0; i<h; i++) {
                String[] line = br.readLine().split(" ");
                for(int j=0; j<w; j++) {
                    map[i][j] = Integer.parseInt(line[j]);
                }
            }

        // 안 익은 것이 없으면 0을 출력
        if(zeroCount(map) == 0) {
            System.out.println(0);
        }
        // 안 익은 것이 있으면 bfs
        else{
            for(int i=0; i<h; i++) {
                for(int j=0; j<w; j++) {
                    if(map[i][j] == 1) {
                        queue.add(new int[]{i,j});
                        visited[i][j] = true;
                    }
                }
            }
            count = bfs()-1;

            if(zeroCount(map) > 0) {
                System.out.println(-1);
            } else{
                System.out.println(count);
            }
        }
    }

    public static int bfs() {
        int value = 0;
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int y = poll[0];
            int x = poll[1];
            value = map[y][x];

            for(int i=0; i<4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if(nextX>=0 && nextX<w && nextY>=0 && nextY<h) {
                    if(visited[nextY][nextX] == false && map[nextY][nextX] == 0) {
                        map[nextY][nextX] = value+1;
                        visited[nextY][nextX] = true;
                        queue.add(new int[]{nextY, nextX});
                    }
                }
            }
        }
        return value;
    }

    public static int zeroCount(int[][] map) {
        int zero = 0;
        for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++) {
                if(map[i][j] == 0) {
                    zero++;
                }
            }
        }
        return zero;
    }
}