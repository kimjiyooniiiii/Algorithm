import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashSet<String> set = new HashSet<>();
        for(String p : phone_book){
            set.add(p);
        }
        
        for(String p : phone_book){
            for(int i=1; i<p.length(); i++){
                if(set.contains(p.substring(0,i))){
                    answer = false;
                    return answer;
                }
            }
        }
        return answer;
    }
}