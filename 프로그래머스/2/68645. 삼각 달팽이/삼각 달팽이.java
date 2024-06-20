class Solution {
    public int[] solution(int n) {
        int[] answer = new int[sizing(n)];
        int num = 1, firstLayer = 1;
        
        while(n > 0){
            num = fillIn(n,firstLayer,num,answer);
            firstLayer += 2;
            n -= 3;     // 총 층이 3개씩 줄어듬
        }
        return answer;
    }
    
    public int fillIn(int allLayer, int firstLayer, int num, int[] answer){
        int startIndex = sumOfLayer(firstLayer)+firstLayer/2; // 결과에 채워넣을 첫번째 인덱스
        answer[startIndex] = num++;
        for(int i=0; i<allLayer-1; i++){    // 삼각형의 왼쪽 변 채우기
            startIndex += firstLayer++;
            answer[startIndex] = num++;
        }
        for(int i=0; i<allLayer-1; i++){    // 삼각형의 밑변 채우기
            answer[++startIndex] = num++;
        }
        for(int i=0; i<allLayer-2; i++){ 
            startIndex -= firstLayer--;
            answer[startIndex] = num++;
        }
        return num;     // 다음 시작 수 반환
    }
    
    public int sumOfLayer(int n){   // n행 이전까지의 층들의 칸의 개수
        int sum = 0;
        for(int i=1; i<n; i++){
            sum += i;
        }
        return sum;
    }
    
    public int sizing(int n){   // 결과 배열 사이즈 계산
        int size = 0;
        for(int i=1; i<=n; i++){
            size += i;
        }
        return size;
    }
}