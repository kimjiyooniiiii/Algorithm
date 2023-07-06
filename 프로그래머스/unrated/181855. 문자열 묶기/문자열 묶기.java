import java.util.Arrays;

class Solution {
    public int solution(String[] strArr) {
        int answer = 0;
        int[] array = new int[30];
        
        for(int i=0; i<strArr.length; i++) {
            for(int j=0; j<array.length; j++){
                if(strArr[i].length() == j+1){
                    array[j]++;
                }
            }
        }
        Arrays.sort(array);
        
        answer = array[29];
        return answer;
    }
}