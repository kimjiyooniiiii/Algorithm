class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        int[] min = new int[y+1];
        
        for(int i=x; i<=y; i++){
            if(x != i && min[i] == 0){
                min[i] = -1;
                continue;
            }
            if(i * 2 <= y){
                min[i * 2] = (min[i * 2] == 0) ? min[i] + 1 : Math.min(min[i* 2], min[i] + 1);
            }
            if(i * 3 <= y){
                min[i * 3] = (min[i * 3] == 0) ? min[i] + 1 : Math.min(min[i * 3], min[i] + 1);
            }
            if(i + n <= y){
                min[i + n] = (min[i + n] == 0) ? min[i] + 1 : Math.min(min[i + n], min[i] + 1);
            }
        }
        
        answer = min[y];
        return answer;
    }
}