import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        int[] slice;
            
        for(int x=0; x<commands.length; x++) {
            int i = commands[x][0];
            int j = commands[x][1];
            int k = commands[x][2];
            
            slice = new int[j-i+1];
            
            for(int y=0; y<slice.length; y++){
                slice[y] = array[y+i-1];
            }
            
            Arrays.sort(slice);
            answer[x] = slice[k-1];
        }
        return answer;
    }
}