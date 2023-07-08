class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        
        for(int i=0; i<my_string.length(); i++) {
            int a = (int)my_string.charAt(i);
            if(65<=a && a<=90){
                answer[a-65] += 1;
            }else if(97<=a && a<=122){
                answer[a-97+26] += 1;
            }
        }
        return answer;
    }
}