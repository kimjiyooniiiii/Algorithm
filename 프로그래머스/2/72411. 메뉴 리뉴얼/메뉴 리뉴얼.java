import java.util.*;
class Solution {
    private Map<String, Integer> map = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        for(int i=0; i<orders.length; i++){
            String[] o = orders[i].split("");
            String[] menu = new String[o.length];
            boolean[] visit = new boolean[o.length];
            
            recur(o, menu, 0, visit, -1);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
            public int compare(Map.Entry<String, Integer> a, 
                         Map.Entry<String, Integer> b){
                if(a.getKey().length() == b.getKey().length()){
                    return b.getValue() - a.getValue();
                }
                return a.getKey().length() - b.getKey().length();

            }
        });

        int index = 0;
        List<String> answerList = new ArrayList<>();
        
        for(int i=0; i<course.length; i++){
            int size = course[i];
            int max = 2;
            for(int j=index; j<list.size(); j++){
                Map.Entry<String, Integer> m = list.get(j);
                if(m.getKey().length() == size && m.getValue() >= max){
                    answerList.add(m.getKey());
                    max = m.getValue();
                }
                if(m.getKey().length() > size){
                    index = j;
                    break;
                }
            }
        }
        Collections.sort(answerList);
        
        return answerList.toArray(new String[answerList.size()]);
    }
    
    public void recur(String[] o, String[] menu, int len, boolean[] visit, int prev){
        if(len >= 2){
            List<String> list = new ArrayList<>();
            for(int i=0; i<len; i++){
                list.add(menu[i]);
            }
            Collections.sort(list);
            
            StringBuilder sb = new StringBuilder();
            for(String l : list){
                sb.append(l);
            }
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
        }
        if(len >= o.length) return;
        
        for(int i=0; i<o.length; i++){
            if(!visit[i] && i>prev){
                visit[i] = true;
                menu[len] = o[i];
                recur(o, menu, len+1, visit, i);
                visit[i] = false;
            }
        }
    }
}