import java.util.Arrays;

class Solution {
    public String solution(String my_string) {
        String[] array = new String[my_string.length()];
        String lower = my_string.toLowerCase();
        String answer = "";
        
        for(int i=0; i<lower.length(); i++){
            array[i] = String.valueOf(lower.charAt(i));
        }
        Arrays.sort(array);
        
        for(int i=0; i<array.length; i++){
            answer += array[i];
        }
    
        return answer;
    }
}