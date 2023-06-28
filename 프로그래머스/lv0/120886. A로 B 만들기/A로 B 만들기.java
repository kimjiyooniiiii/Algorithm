import java.util.Arrays;

class Solution {
    public int solution(String before, String after) {
        int answer = 0;
        char[] beforeArray = new char[before.length()];
        char[] afterArray = new char[after.length()];
        
        for(int i=0; i<before.length(); i++){
            beforeArray[i] = before.charAt(i);
            afterArray[i] = after.charAt(i);
        }
        
        Arrays.sort(beforeArray);
        Arrays.sort(afterArray);
        
        if(Arrays.equals(beforeArray, afterArray)){
            answer = 1;
        }
        return answer;
    }
}