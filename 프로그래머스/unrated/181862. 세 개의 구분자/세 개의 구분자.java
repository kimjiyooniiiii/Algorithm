import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        
        List<String> list = new ArrayList<>();
        List<String> result = new ArrayList<>();
        String s = "";
        
        for(int i=0; i<myStr.length(); i++){
            if((myStr.charAt(i) == 'a')
              || (myStr.charAt(i) == 'b')
              || (myStr.charAt(i) == 'c')){
                list.add(s);
                s = "";
            }else{
                s += Character.toString(myStr.charAt(i));
            }
        }
        list.add(s);
        
        for(String l : list){
            if(!l.equals("")){
                result.add(l);
            }
        }
        
        if(result.size() == 0){
            result.add("EMPTY");
        }
        
        String[] answer = result.toArray(new String[result.size()]);
        
        return answer;
    }
}