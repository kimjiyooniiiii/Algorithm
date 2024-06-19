import java.util.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        List<Integer> divisorA = divisor(arrayA);
        List<Integer> divisorB = divisor(arrayB);
        
        if(divisorA.size() != 0){
            answer = Math.max(answer, checkCondition(arrayB, divisorA));
        }
        if(divisorB.size() != 0){
            answer = Math.max(answer, checkCondition(arrayA, divisorB));
        }

        return answer;
    }
    
    public int checkCondition(int[] array, List<Integer> divisor){  // 조건 체크
        int result = 0;
        for(int i=0; i<divisor.size(); i++){
            boolean isDivide = false;
            for(int j=0; j<array.length; j++){
                if(array[j] % divisor.get(i) == 0){
                    isDivide = true;
                }
            }
            if(!isDivide){
                //System.out.println(divisor.get(i));
                result = Math.max(result,divisor.get(i));
            }
        }
        //System.out.println(result);
        return result;
    }
    
    public List<Integer> divisor(int[] array){  // 배열의 공약수들을 반환
        Arrays.sort(array);
        List<Integer> divisorList = minDivisor(array[0]);   // 가장 작은 수의 약수들을 구함
        List<Integer> result = new ArrayList<>();
        
        for(int i=0; i<divisorList.size(); i++){
            boolean isDivide = true;
            for(int j=1; j<array.length; j++){
                if(array[j] % divisorList.get(i) != 0){
                    isDivide = false;
                    break;
                }
            }
            if(isDivide){
                result.add(divisorList.get(i));
            }
        }
        return result;
    }
    
    public List<Integer> minDivisor(int num){
        List<Integer> result = new ArrayList<>();
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num % i == 0){
                result.add(i);
                result.add(num / i);
            }
        }
        result.add(num);
        return result;
    }
}
