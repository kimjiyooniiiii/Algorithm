import java.util.*;
class Solution {
    public int[][] weight;
    public String[] copy; 
    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int section;
        int picksSum = 0;
        for(int p : picks){
            picksSum += p;
        }
        if(picksSum * 5 < minerals.length){     // 곡괭이로 캘 수 없는 광물은 버림
            copy = new String[picksSum * 5];
        }else{                              // 광물 구간을 5단위로 만든 copy 배열 생성
            if(minerals.length%5 != 0){
                copy = new String[minerals.length + (5-minerals.length%5)];
            }else{
                copy = new String[minerals.length];
            }
        }
        section = copy.length/5;
        
        
        for(int i=0; i<copy.length; i++){
            if(i >= minerals.length){
                copy[i] = "";
            }else{
                copy[i] = minerals[i]; 
            }
        }
        
        weight = new int[section][3];   // 광물 구간을 5씩 구분하고, 각 구간의 피로도 저장
        calculateWeight(section);
        
        int j = 0;
        for(int i=0; i<3; i++){ // 가장 피로도가 높은 구간에 다이아 > 철 > 돌을 사용
            while(picks[i] > 0 && j < weight.length){
                if(i==0){
                    System.out.println(picks[i] + " " + weight[j][0]);
                    answer += weight[j][0];
                } else if(i==1){
                    System.out.println(picks[i] + " " + weight[j][1]);
                     answer += weight[j][1];
                }else{
                    System.out.println(picks[i] + " " + weight[j][2]);
                     answer += weight[j][2];
                }
                picks[i]--;
                j++;
            }
        }
        return answer;
    }
    
    public void calculateWeight(int section){
        for(int i=0; i<section; i++){
            for(int j=0; j<5; j++){
                if(copy[i*5+j].equals("diamond")){
                    weight[i][0] += 1;  // dia를 dia로 캐기
                    weight[i][1] += 5;  // dia를 iron으로 캐기
                    weight[i][2] += 25; // dia를 stone으로 캐기
                }else if(copy[i*5+j].equals("iron")){
                    weight[i][0] += 1;  // iron를 dia로 캐기
                    weight[i][1] += 1;  // iron를 iron으로 캐기
                    weight[i][2] += 5; // iron를 stone으로 캐기
                }else if(copy[i*5+j].equals("stone")){
                    weight[i][0] += 1;  // stone를 dia로 캐기
                    weight[i][1] += 1;  // stone를 iron으로 캐기
                    weight[i][2] += 1; // stone를 stone으로 캐기
                }
            }
        }
        Arrays.sort(weight, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b){
                if(a[2] == b[2]){
                    if(a[1] == b[1]){
                        return b[0]-a[0];
                    }else{
                        return b[1]-a[1];
                    }
                }else{
                    return b[2]-a[2];
                }
            }
        });
    }
}