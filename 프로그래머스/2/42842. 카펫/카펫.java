class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        // yellow의 가로가 최대 개수 -> 1개까지 완전탐색
        for(int i=yellow; i>0; i--) {
            int row = i;
            int column = yellow/i;
            if(yellow%i != 0){
                continue;
            }
            
            if(brown == calculate(row, column)){
                System.out.println(row + " " + column);
                answer[0] = row + 2;
                answer[1] = column + 2;
                break;
            }
        }
        return answer;
    }
    
    public int calculate(int yRow, int yColumn) {
        int bRow = yRow + 2;
        int bColumn = yColumn + 2;
        int bCount = (bRow * bColumn) - (yRow * yColumn);
        return bCount;
    }
}