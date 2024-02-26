import java.io.*;
import java.util.*;

public class Main {

    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static ArrayList<Integer>[] graph;
    public static boolean[] isVisitedBfs;
    public static boolean[] isVisitedDfs;
    public static Queue<Integer> queue = new LinkedList<>();
    public static int count = 0;

    public static List<Integer> dfsPath;
    public static int n,m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nmv = br.readLine().split(" ");
        n = Integer.parseInt(nmv[0]);
        m = Integer.parseInt(nmv[1]);
        int v = Integer.parseInt(nmv[2]);
        graph = new ArrayList[n+1];
        isVisitedBfs = new boolean[n+1];
        isVisitedDfs = new boolean[n+1];
        dfsPath = new ArrayList<>();

        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++) {
            String[] connect = br.readLine().split(" ");
            int node1 = Integer.parseInt(connect[0]);
            int node2 = Integer.parseInt(connect[1]);
            graph[node1].add(node2);
            graph[node2].add(node1);
        }

        for(int i=1; i<=n; i++) {
            graph[i].sort(Comparator.naturalOrder());
        }

        dfs(v);
        System.out.println();
        bfs(v);
    }

    public static void bfs(int v) {
        queue.add(v);
        isVisitedBfs[v] = true;
        System.out.print(v + " ");

        while(!queue.isEmpty()){
            int next = queue.poll();

            for(int i=0; i<graph[next].size(); i++) {
                if(isVisitedBfs[graph[next].get(i)] == false) {
                    queue.add(graph[next].get(i));
                    isVisitedBfs[graph[next].get(i)] = true;
                    System.out.print(graph[next].get(i) + " ");
                }
            }
        }
    }

    public static void dfs(int v) {
        System.out.print(v + " ");
        isVisitedDfs[v] = true;

        for(int i=0; i<graph[v].size(); i++) {
            int next = graph[v].get(i);
            if(isVisitedDfs[next] == false) {
                dfs(next);
            }
        }
    }
}