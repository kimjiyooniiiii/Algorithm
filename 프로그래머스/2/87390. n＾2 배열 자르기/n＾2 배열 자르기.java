// 12:02 -> 24
class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left)+1];
        
        for(long i=left; i<=right; i++){ 
            int row = (int)(i / n) + 1;
            int remainder = (int)(i % n);
            int diff = remainder - row;
            
            if(diff < 0){
                answer[(int)(i-left)] = row;
            }else{
                answer[(int)(i-left)] = row + diff + 1;
            }
        }
        
        return answer;
    }
}