import java.util.*;

class Solution {
    public List<Plan> planList;
    public int current = 0; // 현재 시간
    public Stack<Plan> spareStack = new Stack<>();
    public List<String> finish;
    
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        process(plans);     // 시작 시간 순으로 정렬
        finish = new ArrayList<>();
        current = planList.get(0).start;
        
        for(int i=0; i<planList.size(); i++){
            String name = planList.get(i).name;
            int start = planList.get(i).start;
            int playtime = planList.get(i).playtime;
            int finishTime = start + playtime;
            
            if(start > current){    // 과제할 시간이 안되었으면
 System.out.println(name + " 시간이 남음");
                // 남은 과제를 먼저한다
                spareStudy(start-current);
            }
            // 현재 과제를 할 수 있는 만큼 한다
            if(i == planList.size()-1){ //마지막 과제면
    System.out.println(name + " 완전 다함");
                finish.add(name);
                current = finishTime; //현재시간 업데이트
                spareStudy(100000);  // 남은과제 끝마치기
            } else{
                int nextStart = planList.get(i+1).start;
                if(finishTime > nextStart) { //다음과제 시작보다 오래걸리는 과제면
                int updateTime = playtime - (nextStart - current);
   System.out.println(name + " " + (nextStart - current) + "했고, " + updateTime + "남음");
                    spareStack.push(new Plan(name, start, updateTime));
                    current = nextStart;    // 현재 시간 업데이트
                }else{
    System.out.println(name + " 완전 다함");
                    finish.add(name);
                    current = finishTime;
                }
            }
        }
        
        for(int i=0; i<finish.size(); i++){
            answer[i] = finish.get(i);
        }
        
        return answer;
    }
    
    public void spareStudy(int spareTime){
        while(!spareStack.isEmpty() && spareTime > 0){
            Plan pop = spareStack.pop();
            if(pop.playtime <= spareTime){  // 남는 시간동안 과제를 끝낼수 있으면
  System.out.println(pop.name + " 완전 다함");
                spareTime -= pop.playtime;  // 남은 시간 계산
                current += pop.playtime;    // 현재시간 업데이트
                finish.add(pop.name);
            }else{       
                int updateTime = pop.playtime - spareTime;
    System.out.println(pop.name + " " + spareTime + "했고, " + updateTime + "남음");     
                spareStack.push(new Plan(pop.name,pop.start,updateTime));
                current += spareTime;
                spareTime = 0;
            }
        }
    }
    
    public void process(String[][] plans){
        planList = new ArrayList<>();
        
        for(String[] p : plans){
            String[] time = p[1].split(":");
            // 시작시간 : 시간 * 60 * 분으로 환산
            int start = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            Plan plan = new Plan(p[0],start,Integer.parseInt(p[2]));
            planList.add(plan);
        }
        
        Collections.sort(planList, new Comparator<Plan>(){
            @Override
            public int compare(Plan a, Plan b){
                return a.start - b.start;
            }
        } );
          
    }
    
    public class Plan{
        private String name;
        private int start;
        private int playtime;
        
        public Plan(String name, int start, int playtime){
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }
    }
}