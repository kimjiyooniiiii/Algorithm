import java.util.*;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        List<Integer> numList = rainyNum(k);
        double[] areaArray = area(numList);
        int n = areaArray.length;
        double[] answer = new double[ranges.length];
        
        for(int i=0; i<ranges.length; i++){
            int start = ranges[i][0];
            int end = n + ranges[i][1];
            //System.out.println(start + " " + end);
            
            if(end > n || start > end || start > n || end < 0){
                answer[i] = -1.0;
            }else{
                answer[i] = sumArea(start, end, areaArray);
            }
        }

        return answer;
    }
    
    public double sumArea(int start, int end, double[] areaArray){
        double sum = 0.0;
        for(int i=start; i<end; i++){
            sum += areaArray[i];
        }
        return sum;
    }
    
    public double[] area(List<Integer> numList){
        double[] areaArray = new double[numList.size() - 1];
        
        for(int i=0; i<numList.size()-1; i++){
            int big = Math.max(numList.get(i), numList.get(i+1));
            int small = (big == numList.get(i)) ? numList.get(i+1) : numList.get(i);
            double sum = (big - small) / 2.0;
            areaArray[i] = (sum + small);
        }
        return areaArray;
    }
    
    public List<Integer> rainyNum(int k){
        List<Integer> numList = new ArrayList<>();
        numList.add(k);
        
        while(k > 1){
            if(k % 2 == 0){
                numList.add(k /= 2);
            }else{
                numList.add(k = k*3+1);
            }
        }
        return numList;
    }
}