class Solution {
    public int solution(String s) {
        int answer = 0;
        int minus = 0;
        
        String[] array = s.split(" ");
    
        for(int i=0; i<array.length; i++) {
            if(array[i].equals("Z")){
                minus = Integer.valueOf(array[i-1]);
                answer -= minus;
            }else{
                answer += Integer.valueOf(array[i]);
            }
        }
        return answer;
    }
}