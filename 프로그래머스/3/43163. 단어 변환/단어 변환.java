import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<int[]> q = new LinkedList<>();
        boolean[] isVisit = new boolean[words.length];
        
        for(int i=0; i<words.length; i++){
            int diff = 0;
            for(int j=0; j<begin.length(); j++){
                if(begin.charAt(j) != words[i].charAt(j)){
                    diff++;
                }
            }
            if(diff == 1){
                if(words[i].equals(target)){
                    return 1;
                }
                isVisit[i] = true;
                q.add(new int[]{i,1}); // 인덱스와 카운트
                //System.out.println("q.add " + i + " " + (1));
            }
        }
        answer = bfs(q, isVisit, begin, target, words);
        
        return answer;
    }
    
    public int bfs(Queue<int[]> q, boolean[] isVisit, String begin, String target, String[] words){
        while(!q.isEmpty()){
            int[] poll = q.poll();
            String prev = words[poll[0]];
            int count = poll[1];
            
            for(int i=0; i<words.length; i++){
                if(!isVisit[i]){
                    int diff = 0;
                    for(int j=0; j<prev.length(); j++){
                        if(prev.charAt(j) != words[i].charAt(j)){
                            diff++;
                        }
                    }
                    if(diff == 1){
                        if(words[i].equals(target)){
                            return count+1;
                        }
                        isVisit[i] = true;
                        q.add(new int[]{i,count+1}); // 인덱스와 카운트
                        //System.out.println("q.add " + i + " " + (count+1));
                    }
                }
            }
        }
        return 0;
    }
}

// 일차원 배열을 순회하면서 하나 차이나는 것을 구할 수 있다니. 신기하다...