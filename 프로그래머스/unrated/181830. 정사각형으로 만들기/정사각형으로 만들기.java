import java.util.ArrayList;

class Solution {
    public int[][] solution(int[][] arr) {
        int row = arr.length;
        int column = arr[0].length;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        
        for(int i=0; i<row; i++){   // 이차원 리스트 생성
            list.add(new ArrayList<>());
        }
        
        for(int i=0; i<row; i++) {  // 출력
            for(int j=0; j<column; j++){
                list.get(i).add(arr[i][j]);
            }
        }
        
        
        if(row>column){
            for(int j=0; j<row; j++){
                for(int i=0; i<row-column; i++){
                    list.get(j).add(0);
                }
            }
        }
        else if(row<column){
            ArrayList<Integer> newL = new ArrayList<>();
            
            for(int i=0; i<column; i++){
                    newL.add(0);
                }
            
            for(int j=0; j<column-row; j++){
                list.add(newL);
                
            }
        }
        
        for (ArrayList<Integer> r : list) {
            for (int element : r) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        
        int[][] answer = new int[list.size()][];
        
        for(int i=0; i<answer.length; i++) {
            answer[i] = new int[list.get(i).size()];
        }
        
        for(int i=0; i<list.size(); i++){
            for(int j=0; j<list.get(i).size(); j++) {
                answer[i][j] = list.get(i).get(j);
            }
        }
        
        return answer;
    }
}