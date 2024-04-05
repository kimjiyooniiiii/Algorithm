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
            //List<Character> bingo = complete(board);
            List<Character> oB = complete(board,'O');
            List<Character> xB = complete(board,'X');
            
            if(oB.contains('O') && xB.contains('X')){
                answer = 0;
            }
            else if(oB.contains('O')){
                if(o <= x){    // 선공이 빙고인데, 후공 또는 선공을 또 놓았을 경우
                    answer = 0;
                }
            }else if(xB.contains('X')){     // 후공이 빙고인데, 후공 또는 선공을 또 놓았을 경우
                if(o > x){
                    answer = 0;
                }
            }

            // if(bingo.contains('O') && bingo.contains('X')){
            //     answer = 0;
            // }
            // else if(bingo.contains('O')){
            //     if(o <= x){    // 선공이 빙고인데, 후공 또는 선공을 또 놓았을 경우
            //         answer = 0;
            //     }
            // }else if(bingo.contains('X')){     // 후공이 빙고인데, 후공 또는 선공을 또 놓았을 경우
            //     if(o > x){
            //         answer = 0;
            //     }
            // }
        }
        return answer;
    }
    
    public List<Character> complete(String[] board, char word){
        List<Character> list = new ArrayList<>();
        
        // 가로 완성
		for (int i = 0; i < 3; i++) {
			if (board[i].charAt(0) == word && board[i].charAt(1) == word && board[i].charAt(2) == word) {
				list.add(word);
			}
		}

		// 세로 완성
		for (int i = 0; i < 3; i++) {
			if (board[0].charAt(i) == word && board[1].charAt(i) == word && board[2].charAt(i) == word) {
				list.add(word);
			}
		}

		// 좌->우 대각선 완성
		if (board[0].charAt(0) == word && board[1].charAt(1) == word && board[2].charAt(2) == word) {
			list.add(word);
		}

		// 우->좌 대각선 완성
		if (board[0].charAt(2) == word && board[1].charAt(1) == word && board[2].charAt(0) == word) {
			list.add(word);
		}
//         // 가로 빙고 확인
//         for(int i=0; i<3; i++){
//           if(board[i].equals("OOO")){
//               list.add('O');
//           } else if(board[i].equals("XXX")){
//               list.add('X');
//           }
//         }
//         // 세로 빙고 확인
//         StringBuilder first = new StringBuilder();
//         StringBuilder second = new StringBuilder();
//         StringBuilder third = new StringBuilder();

//        for(int y=0; y<3; y++){
//           first.append(board[y].charAt(0));
//           second.append(board[y].charAt(1));
//            third.append(board[y].charAt(2));
//        }
        
//         // 대각선 빙고 확인
//         StringBuilder rCross = new StringBuilder();
//         StringBuilder lCross = new StringBuilder();
        
//         for(int y=0; y<3; y++){
//           rCross.append(board[y].charAt(y));
//           lCross.append(board[y].charAt(2-y));
//        }
        
//         if(first.equals("OOO") || second.equals("OOO") || third.equals("OOO") 
//            || rCross.equals("OOO") || lCross.equals("OOO")){
//             list.add('O');
//         }else if(first.equals("XXX") || second.equals("XXX") || third.equals("XXX")
//                 || rCross.equals("XXX") || lCross.equals("XXX")){
//             list.add('X');
//         }
    
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