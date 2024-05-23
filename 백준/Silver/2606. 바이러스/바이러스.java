import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    private static int com,net;
    private static List<Integer>[] graph;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        input(br);

        Queue<Integer> virus = new LinkedList();
        virus.add(1);
        visit[1] = true;
        int result = 0;
        while(!virus.isEmpty()){
            int cur = virus.poll();

            for(int i=0; i<graph[cur].size(); i++){
                int next = graph[cur].get(i);
                if(!visit[next]){
                    visit[next] = true;
                    virus.add(next);
                    result++;
                }
            }
        }
        System.out.println(result);
    }


    public static void input(BufferedReader br) throws IOException {
        String[] condition = br.readLine().split(" ");
        com = Integer.parseInt(condition[0]);
        visit = new boolean[com+1];

        net = Integer.parseInt(br.readLine());
        graph = new ArrayList[com+1];
        for(int i=0; i<com+1; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<net; i++){
            String[] connect = br.readLine().split(" ");
            int front = Integer.parseInt(connect[0]);
            int back = Integer.parseInt(connect[1]);

            graph[front].add(back);
            graph[back].add(front);
        }
    }
}

