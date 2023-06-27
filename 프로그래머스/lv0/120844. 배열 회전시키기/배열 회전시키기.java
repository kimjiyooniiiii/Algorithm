class Solution {
    public int[] solution(int[] numbers, String direction) {
        int size = numbers.length;
        int[] answer = new int[size];
        
        if(direction.equals("right")) {
            for(int i=0; i<size; i++) {
                if(i == size-1) {
                    answer[0] = numbers[i];
                }
                else{
                    answer[i+1] = numbers[i];
                }
            }
        }
       else if(direction.equals("left")) {
            for(int i=0; i<size; i++) {
                if(i == 0) {
                    answer[size-1] = numbers[i];
                }
                else{
                    answer[i-1] = numbers[i];
                }
            }
       }
        return answer;
    }
}