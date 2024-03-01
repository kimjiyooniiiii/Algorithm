import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int[][] graph;
    public static boolean[][] isVisited;
    public static int value=0;
    public static int n,m;
    public static int step = 1;
    public static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        graph = new int[n][m];
        isVisited = new boolean[n][m];

        for(int i=0; i<n; i++) {
            String[] friend = br.readLine().split("");
            for(int j=0; j<m; j++) {
                graph[i][j] = Integer.parseInt(friend[j]);
            }
        }

        dfs(0,0);
        System.out.println(graph[n-1][m-1]);
    }

    public static void dfs(int startX, int startY) {
        queue.add(new int[] {startX, startY});
        isVisited[startX][startY] = true;

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            int value = graph[x][y];

            if(x == n-1 && y == m-1) {
                return;
            }

                if(x-1>=0 && isVisited[x-1][y] == false && graph[x-1][y] == 1) {
                    isVisited[x-1][y] = true;
                    queue.add(new int[] {x-1, y});
                    graph[x-1][y] = value + 1;
                }
                if(x+1<n && isVisited[x+1][y] == false && graph[x+1][y] == 1) {
                    isVisited[x+1][y] = true;
                    queue.add(new int[] {x+1, y});
                    graph[x+1][y] = value + 1;
                }
                if(y-1>=0 && isVisited[x][y-1] == false && graph[x][y-1] == 1) {
                    isVisited[x][y-1] = true;
                    queue.add(new int[] {x, y-1});
                    graph[x][y-1] = value + 1;
                }
                if(y+1<m && isVisited[x][y+1] == false && graph[x][y+1] == 1) {
                    isVisited[x][y+1] = true;
                    queue.add(new int[] {x, y+1});
                    graph[x][y+1] = value + 1;
                }
            }
    }
}