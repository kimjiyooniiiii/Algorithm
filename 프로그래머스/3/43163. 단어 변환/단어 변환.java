import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {

        return bfs(begin, target, words);
    }
    
    public int bfs(String begin, String target, String[] words){
        boolean[] visit = new boolean[words.length];
        Queue<String[]> q = new LinkedList<>();
        q.add(new String[]{begin,"0"});
        
        while(!q.isEmpty()){
            String[] prev = q.poll();
            if(prev[0].equals(target)) return Integer.parseInt(prev[1]);
            
            for(int i=0; i<words.length; i++){
                if(!visit[i]){
                    String cur = words[i];
                    int diff = 0;
                    for(int j=0; j<cur.length(); j++){
                        if(prev[0].charAt(j) != cur.charAt(j)) diff++;
                    }
                    if(diff == 1){
                       // System.out.println(cur);
                        visit[i] = true;
                        q.add(new String[]
                              {cur, String.valueOf(Integer.parseInt(prev[1])+1)});
                    }
                }
            }
        }
        return 0;
    }
}