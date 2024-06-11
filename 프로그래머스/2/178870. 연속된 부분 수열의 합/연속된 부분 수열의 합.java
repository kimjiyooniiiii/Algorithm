import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        List<Result> passResult = new ArrayList<>();
        Queue<Integer> element = new LinkedList<>();
        
        int sum = 0;
        for(int i=0; i<sequence.length; i++){
            sum += sequence[i];
            element.add(i);
            //System.out.println(sequence[i]);
            
            while(sum > k){
                //System.out.println("빼기 " + sequence[element.peek()]);
                sum -= sequence[element.poll()];
            }
            if(sum == k){
               // System.out.println("완성 사이즈" + element.size() + " 시작" + sequence[element.peek()]);
               // System.out.println(element.poll());
                passResult.add(new Result(element.size(), element.peek()));
            }
        }
        
        Collections.sort(passResult, new Comparator<Result>(){
            @Override
            public int compare(Result a, Result b){
                if(a.len == b.len){
                    return a.start - b.start;
                }
                return a.len - b.len;
            }
        });
        
        answer[0] = passResult.get(0).start;
        answer[1] = passResult.get(0).start + passResult.get(0).len - 1;
        return answer;
    }
    
    class Result{
        private int len;
        private int start;
        
        public Result(int len, int start){
            this.len = len;
            this.start = start;
        }
    }
}

