class Solution {
    int count;
    
    public int solution(int[] num_list) {
        int answer = 0;
        
        for(int num : num_list){
            count = 0;
            answer += counting(num);
        }
        return answer;
    }
    
    public int counting(int number) {
        if(number == 1){
            return count;
        }
        else if(number%2 == 0){
            count++;
            return counting(number/2);
        }
        else{
            return counting(number-1);
        }
    }
}