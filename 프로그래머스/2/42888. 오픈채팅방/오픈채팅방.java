// 10:35
import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        
        Map<String, String> nick = new HashMap<>();
        List<String> info = new ArrayList<>();
        
        for(int i=0; i<record.length; i++){
            String[] splitR = record[i].split(" ");
            if(splitR[0].equals("Enter")){
                info.add(splitR[0] + " " + splitR[1]);
                nick.put(splitR[1], splitR[2]);
            }else if(splitR[0].equals("Leave")){
                info.add(splitR[0] + " " + splitR[1]);
            }else{
                nick.put(splitR[1], splitR[2]);
            }
        }
        
        String[] answer = new String[info.size()];
        for(int i=0; i<info.size(); i++){
            String[] splitInfo = info.get(i).split(" ");
            if(splitInfo[0].equals("Enter")){
                answer[i] = nick.get(splitInfo[1]) + "님이 들어왔습니다.";
            }else{
                answer[i] = nick.get(splitInfo[1]) + "님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}

// 나갔다가 새로운 닉네임으로 들어온다.
// 닉네임을 벽녕한다.