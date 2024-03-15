import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> hash = new HashMap<>();
        for(String p : participant){
            if(hash.containsKey(p)){
                int value = hash.get(p);
                hash.replace(p,++value);
            }else{
                hash.put(p,1);   
            }
        }
        
        for(String c : completion){
            if(hash.get(c) == 1){
                hash.remove(c);
            }else{
                int value = hash.get(c);
                hash.replace(c,--value);
            }
        }
        
        Set<String> set = hash.keySet();
        for(String s : set){
            answer += s;
        }

        return answer;
    }
}