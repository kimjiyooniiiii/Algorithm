class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int max = 0;
        int min = 0;
        int spare = 0;
        
        if(n>m) {
            max = n;
            min = m;
        }else{
            max = m;
            min = n;
        }
        spare = min;
        
        while(max%min > 0) {
            spare = max%min;
            max = min;
            min = spare;
        }
        answer[0] = spare;
        
        answer[1] = n*m/spare;
        
        return answer;
    }
}