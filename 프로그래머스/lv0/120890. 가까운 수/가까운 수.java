class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        int standard = 100;
        int diff = 0;
        
        for(int a : array){
            diff = Math.abs(a - n);
            if(standard == diff){
                if(answer > a){
                    answer = a;
                }else{
                    continue;
                }
            }
            else if(standard > diff) {
                standard = diff;
                answer = a;
            }
        }
        return answer;
    }
}