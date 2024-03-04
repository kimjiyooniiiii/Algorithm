import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static int n;
    public static int[][] map;
    public static boolean[][] visited;
    // 상좌하우
    public static int[] dx = {-1,-2,1,2,-2,-1,2,1};
    public static int[] dy = {-2,-1,-2,-1,1,2,1,2};
    public static int count,w,h;
    public static int endX, endY;
    public static Queue<int[]> queue;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            visited = new boolean[n][n];
            queue = new LinkedList<>();

            String[] start = br.readLine().split(" ");
            int startY = Integer.parseInt(start[0]);
            int startX = Integer.parseInt(start[1]);
            queue.add(new int[]{startY,startX});
            visited[startY][startX] = true;

            String[] end = br.readLine().split(" ");
            endY = Integer.parseInt(end[0]);
            endX = Integer.parseInt(end[1]);

            System.out.println(dfs());
        }

    }

    public static int dfs() {
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[1];
            int y = poll[0];
            int value = map[y][x];

            if(y == endY && x == endX) {
                return map[y][x];
            }
            for(int i=0; i<8; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if(nextX>=0 && nextX<n && nextY>=0 && nextY<n) {
                    if(visited[nextY][nextX] == false){
                        map[nextY][nextX] = value+1;
                        visited[nextY][nextX] = true;
                        queue.add(new int[]{nextY,nextX});
                    }
                }
            }
        }
        return 0;
    }
}