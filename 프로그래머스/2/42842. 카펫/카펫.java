// 3:22 -> 36
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int all = brown + yellow;
        
        for(int i=1; i<= Math.sqrt(yellow); i++){   // i 최대값 다시 점검
            if(yellow % i != 0) continue;
            
            int yellowColumn = i;
            int yellowRow = yellow / i;
            
            int brownColumn = yellowColumn + 2;
            int brownRow = yellowRow + 2;
            
            if(brownColumn * brownRow == all){
                answer[0] = brownRow;
                answer[1] = brownColumn;
                break;
            }
        }
        
        return answer;
    }

}