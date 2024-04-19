import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static int n,k,time = 0;
    public static Queue<int[]> q = new LinkedList<>();  // 뱀이 차지하는 위치
    public static boolean[] isSnake;    // 뱀이 있는 위치는 true 표시
    public static boolean[] isApple;
    public static HashMap<Integer,String> rotationTime = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        input(br);
        q.add(new int[]{0,0});  // 처음 뱀의 위치
        isSnake[0] = true;
        game(0,0,1);  // 처음엔 오른쪽으로 시작, 방향은 북동남서 순으로 0,1,2,3

        System.out.println(time);
    }
    public static void game(int y, int x, int direction){
        int nextY = y, nextX = x;
        while(true){
            if(rotationTime.containsKey(time)){ // 회전할 시간이 되었다면
                String rotation = rotationTime.get(time);
                //System.out.println("Time " + time + " " + rotation + "으로 회전");
                //System.out.print("방향 전환 " + direction);

                if(rotation.equals("D")){   // 시계 방향 회전
                    direction = (direction + 1) % 4;
                }else{      // 반시계 방향 회전
                    direction = (direction - 1 + 4) % 4;
                }
                //System.out.println(" -> " + direction);
            }

            if(direction == 1){     // 원하는 방향으로 이동
                nextX++;
            }else if(direction == 3){
                nextX--;
            }else if(direction == 0){
                nextY--;
            }else{
                nextY++;
            }
            if(!move(nextY, nextX)){        // 자신의 몸이나 벽과 부딪혔다면 게임 끝
                time++; // 마지막 시간 업데이트
                break;
            }
        }
    }

    public static boolean move(int nextY, int nextX){
        int position = nextY * n + nextX;   // 좌표를 0 ~ n-1의 숫자로 환산
        //System.out.println("머리위치 " + nextY +" " + nextX);

        if(nextX == n || nextY == n || nextX < 0 || nextY < 0|| isSnake[position]){  // 자신의 몸이나 벽과 부딪히면
            if(nextX == n || nextY == n || nextX < 0 || nextY < 0){
                //System.out.println("벽과 부딪힘 " + nextY +" " + nextX);
            }else{
                //System.out.println("자신과 부딪힘 " + nextY +" " + nextX);
            }

            return false;
        }else if(isApple[position]){    // 사과가 있다면
            isApple[position] = false;  // 사과 삭제
            q.add(new int[]{nextY, nextX});
            isSnake[position] = true;
            //System.out.println("사과 먹음 " + nextY +" " + nextX);
            //System.out.print("현재 뱀 위치 ");
            for(int i=0; i<isSnake.length; i++){
                if(isSnake[i]){
          //          System.out.print((i/n) + " " + (i%n) + ", ");
                }
            }
           // System.out.println();
        } else{
            int[] poll = q.poll();
            isSnake[poll[0] * n + poll[1]] = false;     // 해당 위치의 뱀 삭제

            q.add(new int[]{nextY, nextX});     // 새로운 위치 삽입
            isSnake[position] = true;

            //System.out.println("위치만 이동 " + nextY +" " + nextX);
            //System.out.print("현재 뱀 위치 ");
            for(int i=0; i<isSnake.length; i++){
                if(isSnake[i]){
           //         System.out.print((i/n) + " " + (i%n) + ", ");
                }
            }
           // System.out.println();
        }
        time++;
       // System.out.println("이동 후 시간 " + time);
        //System.out.println("---------------------");
        return true;
    }

    public static void input(BufferedReader br) throws IOException {
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        isApple = new boolean[n*n];
        isSnake = new boolean[n*n];

        for(int i=0; i<k; i++){
            String[] apple = br.readLine().split(" ");
            int y = Integer.parseInt(apple[0])-1;
            int x = Integer.parseInt(apple[1])-1;

            isApple[y * n + x] = true;  // 사과의 위치 저장
        }

        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            String[] timeInput = br.readLine().split(" ");
            rotationTime.put(Integer.parseInt(timeInput[0]),timeInput[1]);
        }
    }
}
