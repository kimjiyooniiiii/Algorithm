import java.io.*;
import java.util.ArrayList;

public class Main {

    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static ArrayList<Integer>[] graph;
    public static boolean[] isVisited;
    public static int value=0;
    public static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        graph = new ArrayList[n];
        isVisited = new boolean[n];

        for(int i=0; i<n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++) {
            String[] friend = br.readLine().split(" ");
            int first = Integer.parseInt(friend[0]);
            int second = Integer.parseInt(friend[1]);
            graph[first].add(second);
            graph[second].add(first);
        }

        for(int i=0; i<n; i++) {
            if(value != 1) {
                dfs(i, 0);
            }
        }
        System.out.println(value);
    }

    public static void dfs(int start, int step) {
        if(step == 4) {
            value = 1;
            return;
        } else {
            isVisited[start] = true;

            for(int i=0; i<graph[start].size(); i++) {
                if(!isVisited[graph[start].get(i)]){
                    dfs(graph[start].get(i), step+1);
                }
            }
            isVisited[start] = false;
        }
    }
}