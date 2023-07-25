class Solution {
    public String solution(String s) {
        String answer = "";
        int start = 0;
        String[] array = s.split("");
        
        for(int i=0; i<array.length; i++){
            if(array[i].equals(" ")){
                start = 0;
            }
            else if(start%2 == 0){
                array[i] = array[i].toUpperCase();
                start++;
            }
            else if(start%2 == 1){
                array[i] = array[i].toLowerCase();
                start++;
            }
        }
        for(String a : array){
            answer += a;
        }
        return answer;
    }
}