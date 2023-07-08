class Solution {
    public int solution(String my_string) {
        
        String[] array = my_string.split(" ");
        int answer = Integer.valueOf(array[0]);
        
        for(int i=0; i<array.length; i++) {
            if(array[i].equals("+")){
                answer += Integer.valueOf(array[i+1]);
                
            }else if(array[i].equals("-")){
                answer -= Integer.valueOf(array[i+1]);
            }   
        }
        return answer;
    }
}