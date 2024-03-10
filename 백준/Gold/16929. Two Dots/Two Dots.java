import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int h,w, startY, startX, result;
    public static String[][] map;
    public static boolean[][] isVisited;

    public static int[] dy = {-1,1,0,0};
    public static int[] dx = {0,0,-1,1};

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        h = Integer.parseInt(input[0]);
        w = Integer.parseInt(input[1]);
        map = new String[h][w];

        // 지도 입력
        for (int i = 0; i < h; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < w; j++) {
                map[i][j] = line[j];
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                isVisited = new boolean[h][w];
                isVisited[i][j] = true;
                startY = i;
                startX = j;
                dfs(i, j, map[i][j], 1);
                if (result >= 1) {
                    System.out.println("Yes");
                    return;
                }
            }
        }
        System.out.println("No");

    }
    public static void dfs(int y, int x, String alpha, int count) {

        if(count >= 4 && checkCycle(y, x)) {
            result++;
            return;
        }

        for(int i=0; i<4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];

            if(nextY>=0 && nextY<h && nextX>=0 && nextX<w) {
                if(isVisited[nextY][nextX] == false && map[nextY][nextX].equals(alpha)) {
                    isVisited[nextY][nextX] = true;
                    dfs(nextY, nextX, alpha, count+1);
                }
            }
        }

    }

    // 마지막 도착점이 시작점과 이웃한지 확인
    public static boolean checkCycle(int y, int x) {
        for(int i=0; i<4; i++) {
            if(y + dy[i] == startY && x + dx[i] == startX) {
                return true;
            }
        }
        return false;
    }

    public static class Solution {

    }
}