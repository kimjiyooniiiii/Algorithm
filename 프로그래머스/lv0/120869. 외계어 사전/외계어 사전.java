class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 0;
        boolean b = false;
        
        for(int i=0; i<dic.length; i++) {
            for(int j=0; j<spell.length; j++){
                if(dic[i].contains(spell[j])){
                  b = true;
                }else{
                    b = false;
                    break;
                }
            }
            if(b) {
                answer = 1;
                break;
            }
            System.out.println(b);
        }
        
        if(!b) {
            answer = 2;
        }
        
        return answer;
    }
}