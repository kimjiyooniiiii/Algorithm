import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(int i=0; i<skill_trees.length; i++){
            String s = skill_trees[i];
            StringBuilder sb = new StringBuilder();
            
            for(int j=0; j<s.length(); j++){
                for(int x=0; x<skill.length(); x++){
                    if(skill.charAt(x) == s.charAt(j)){
                        sb.append(s.charAt(j));
                        break;
                    }
                }
            }
            Queue<Character> q = makeQueue(skill);
            boolean possible = true;
            String result = sb.toString();
            
            for(int x=0; x<result.length(); x++){
                if(!q.isEmpty()){
                    if(q.poll() != result.charAt(x)){
                        possible = false;
                        break;
                    }
                    else{
                        possible = true;
                    }
                }
            }
            if(possible){
                answer++;
              //  System.out.println(result);
            }
        }
        
        return answer;
    }
    
    public Queue<Character> makeQueue(String skill){
        Queue<Character> q = new LinkedList<>();
        for(int i=0; i<skill.length(); i++){
            q.add(skill.charAt(i));
        }
        return q;
    }
}