import java.util.*;

class Solution {
    public int o = 0;   // o와 x의 개수
    public int x = 0;
    
    public int solution(String[] board) {
        int answer = 1;
        count(board);
        
        if(o != x && (o-x) != 1){   // 게임판 위의 개수에 대한 규칙이 맞지 않을 때
            answer = 0;       
        }else{
            List<Character> bingo = complete(board);
            if(bingo.contains('O') && bingo.contains('X')){
                answer = 0;
            }
            else if(bingo.contains('O')){
                if(o <= x || o > 3){    // 선공이 빙고인데, 후공 또는 선공을 또 놓았을 경우
                    answer = 0;
                }
            }else if(bingo.contains('X')){     // 후공이 빙고인데, 후공 또는 선공을 또 놓았을 경우
                if(o > x || x > 3){
                    answer = 0;
                }
            }
        }
        return answer;
    }
    
    public List<Character> complete(String[] board){
        List<Character> list = new ArrayList<>();
        // 가로 빙고 확인
        for(int i=0; i<3; i++){
          if(board[i].equals("OOO")){
              list.add('O');
          } else if(board[i].equals("XXX")){
              list.add('X');
          }
        }
        // 세로 빙고 확인
        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();
        StringBuilder third = new StringBuilder();

       for(int y=0; y<3; y++){
          first.append(board[y].charAt(0));
          second.append(board[y].charAt(1));
           third.append(board[y].charAt(2));
       }
        
        // 대각선 빙고 확인
        StringBuilder rCross = new StringBuilder();
        StringBuilder lCross = new StringBuilder();
        
        for(int y=0; y<3; y++){
          rCross.append(board[y].charAt(y));
          lCross.append(board[y].charAt(2-y));
       }
        
        if(first.equals("OOO") || second.equals("OOO") || third.equals("OOO") 
           || rCross.equals("OOO") || lCross.equals("OOO")){
            list.add('O');
        }else if(first.equals("XXX") || second.equals("XXX") || third.equals("XXX")
                || rCross.equals("XXX") || lCross.equals("XXX")){
            list.add('X');
        }
    
        return list;
    }
    
    public void count(String[] board){
        for(int i=0; i<3; i++){
            String b = board[i];
            for(int j=0; j<3; j++){
                if(b.charAt(j) == 'O'){
                    o++;
                }else if(b.charAt(j) == 'X'){
                    x++;
                }
            }
        }
    }
}