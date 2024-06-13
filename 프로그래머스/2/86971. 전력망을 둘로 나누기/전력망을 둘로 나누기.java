import java.util.*;
class Solution {
    private boolean[][] visit;
    
    public int solution(int n, int[][] wires) {
        int answer = 100;
        List[] connect = new ArrayList[n+1];
        input(n, connect, wires);
        
        for(int i=0; i<wires.length; i++){
            int a = wires[i][0]; // 끊는 곳
            int b = wires[i][1];
            visit = new boolean[n+1][n+1];
            answer = Math.min(answer, search(connect, a, b));
        }
        return answer;
    }
    
    public int search(List[] connect, int a, int b){
        List<Integer> group = new ArrayList<>();
        for(int i=1; i<connect.length; i++){
            List<Integer> list = new ArrayList<>();
            list.add(i);
            dfs(connect, i, list, a, b);
            
            if(list.size() > 1){
                group.add(list.size());
            }
        }
        //System.out.println(group.size());
        if(group.size() == 1){
            //System.out.println(group.get(0) + " " + 1);
            return group.get(0) - 1;
        }else{
            //System.out.println(group.get(0) + " " + group.get(1));
            return Math.abs(group.get(0) - group.get(1));
        }
    }
    
    public void dfs(List[] connect, int start, List<Integer> list, int a, int b){
        for(int j=0; j<connect[start].size(); j++){
            int next = (int)connect[start].get(j);
            if(!(a == start && b == next) && !(b == start && a == next)){   // 끊긴 곳이 아니면
                if(!visit[start][next]){
                    visit[start][next] = true;
                    visit[next][start] = true;
                    list.add(next);
                    dfs(connect, next, list, a, b);
                }
            }
        }
        return;
    }
    
    public void input(int n, List[] connect, int[][] wires){
        for(int i=0; i<n+1; i++){
            connect[i] = new ArrayList<>();
        }
        for(int i=0; i<wires.length; i++){
            connect[wires[i][0]].add(wires[i][1]);
            connect[wires[i][1]].add(wires[i][0]);
        }
    }
}