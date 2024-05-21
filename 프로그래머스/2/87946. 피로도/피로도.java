class Solution {
    public int[] order;
    public boolean[] visit;
    public int answer = -1;
    
    public int solution(int k, int[][] dungeons) {
        int size = dungeons.length;
        order = new int[size];      // 던전 탐험의 순서를 정하기 위한 배열
        visit = new boolean[size];  // 백트래킹을 사용해 순서를 탐색하기 위한 배열
        
        orderingNumber(0, size, k, dungeons);   // 던전 탐험 순서 정하는 백트래킹 메소드
        return answer;
    }
    
    public void orderingNumber(int count, int size, int k, int[][] dungeons){
        if(count == size){
            // countGetDungeons : 순서가 정해지면 탐험 가능한 던전 수를 확인
            // 현재 최대 탐험수와 비교하여 정답 업데이트
            answer = Math.max(answer, countGetDungeons(k, dungeons));   
            return;
        }
        for(int i=0; i<size; i++){  // 0부터 던전의 길이까지 순열을 만들어 방문할 순서를 정함
            if(!visit[i]){
                order[count] = i;
                visit[i] = true;
                orderingNumber(count+1, size, k, dungeons);
                visit[i] = false;
            }
        }
    }
    
    public int countGetDungeons(int k, int[][] dungeons){   // 정해진 순서로 방문했을 때 탐험 가능한 던전 수 카운팅
        int count = 0;
        for(int i=0; i<order.length; i++){
            if(dungeons[order[i]][0] > k){    // 해당 던전을 탐험할 수 있는 피로도가 남아있는지 확인
                break;
            }
            k -= dungeons[order[i]][1];    // 남아있는 피로도 업데이트
            count++;
        }
        return count;   // 총 던전 탐험한 개수
    }
}

// 가지고 있어야 하는 피로도, 소모 되는 피로도