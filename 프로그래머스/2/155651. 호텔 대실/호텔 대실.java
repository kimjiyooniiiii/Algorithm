import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[][] time = new int[book_time.length][2];
        
        input(book_time, time);
        List<Integer> end = new ArrayList<>();
        end.add(time[0][1]);
        answer++;
        
        for(int i=1; i<book_time.length; i++){
            int nextStart = time[i][0];
            int nextEnd = time[i][1];
            boolean isPass = false;
            for(int j=0; j<end.size(); j++){
                //System.out.println(nextStart + " " + nextEnd + " " + end.get(j));
                if(nextStart >= end.get(j)){
                    //System.out.println(end.get(j) + "와 같은 방 " + nextStart);
                    end.set(j,nextEnd);
                    isPass = true;
                    break;
                }
            }
            if(!isPass){
                //System.out.println("새로운 방 " + nextEnd);
                end.add(nextEnd);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void input(String[][] book_time, int[][] time){
        for(int i=0; i<book_time.length; i++){
            String[] startS = book_time[i][0].split(":");
            int start = Integer.parseInt(startS[0]) * 60 + Integer.parseInt(startS[1]);
            
            String[] endS = book_time[i][1].split(":");
            int end = Integer.parseInt(endS[0]) * 60 + Integer.parseInt(endS[1])+10;
            
            time[i][0] = start;  time[i][1] = end;
            //System.out.println(start + " " + end); 
        }
        Arrays.sort(time, new Comparator<int[]>(){
           @Override
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });
    }
}

// 끝나는 시간 이후에 들어갈 수 있는 방을 찾기 
// 나의 시작 시간과 그 방의 끝시간 차이가 적은 것을 찾기
