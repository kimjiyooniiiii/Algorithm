import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        Map<String, Integer> map = new HashMap<>();
        map.put(words[0],1);
        
        for(int i=1; i<words.length; i++){
                char prev = words[i-1].charAt(words[i-1].length()-1);
            
                if(checkFirstWord(prev, words[i]) == false) {
                    answer[0] = i%n+1;
                    answer[1] = i/n+1;
                    break;
                } 
            
                if(map.containsKey(words[i])) {
                    answer[0] = i%n+1;
                    answer[1] = i/n+1;
                    break;
                }
            
                map.put(words[i],1);
            
                // if(checkDoubleWord(words, words[i], i) == false) {
                //     answer[0] = i%n+1;
                //     answer[1] = i/n+1;
                //     break;
                // }
        }
        
        return answer;
    }
    
    public boolean checkFirstWord(char prev, String word) {
        if(word.charAt(0) != prev){
            return false;
        }
        return true;
    }
    
    public boolean checkDoubleWord(String[] words, String word, int order) {
        for(int i=0; i<words.length; i++){
            if(words[i].equals(word) && i != order){
                    return false;
            }
        }
        return true;
    }
}