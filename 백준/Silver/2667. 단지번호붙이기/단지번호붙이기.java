import java.io.*;
import java.util.*;

public class Main {

    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int[][] graph;
    public static boolean[][] isVisited;
    public static int value=0;
    public static int n,m;
    public static List<Integer> result = new ArrayList<>();
    public static int count = 0;
    public static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        isVisited = new boolean[n][n];

        for(int i=0; i<n; i++) {
            String[] line = br.readLine().split("");
            for(int j=0; j<n; j++) {
                graph[i][j] = Integer.parseInt(line[j]);
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(isVisited[i][j] == false && graph[i][j] == 1) {
                    bfs(i, j);
                }
            }
        }
        result.sort(Comparator.naturalOrder());
        System.out.println(count);
        for(int r : result) {
            System.out.println(r);
        }
    }

    public static void bfs(int startX, int startY) {
        queue.add(new int[] {startX, startY});
        isVisited[startX][startY] = true;
        count++;
        int value = 1;

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];

                if(x-1>=0 && isVisited[x-1][y] == false && graph[x-1][y] == 1) {
                    isVisited[x-1][y] = true;
                    queue.add(new int[] {x-1, y});
                    value++;
                }
                if(x+1<n && isVisited[x+1][y] == false && graph[x+1][y] == 1) {
                    isVisited[x+1][y] = true;
                    queue.add(new int[] {x+1, y});
                    value++;
                }
                if(y-1>=0 && isVisited[x][y-1] == false && graph[x][y-1] == 1) {
                    isVisited[x][y-1] = true;
                    queue.add(new int[] {x, y-1});
                    value++;
                }
                if(y+1<n && isVisited[x][y+1] == false && graph[x][y+1] == 1) {
                    isVisited[x][y+1] = true;
                    queue.add(new int[] {x, y+1});
                    value++;
                }
        }
        result.add(value);
    }
}