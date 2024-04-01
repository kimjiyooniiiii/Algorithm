import java.io.*;

public class Main {
    public static int n,queen = 0, result = 0;
    public static int[] map;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        map = new int[n];
        backTracking(0);
        System.out.println(result);
    }

    public static void backTracking(int y){
        if(y == n){
            result++;
            return;
        }
        for(int i=0; i<n; i++){
            map[y] = i; // y에 x넣기
            if(!isAttack(y)){
                // 퀸을 놓을 수 있으면 다음 y로 넘어가기
                queen++;
                backTracking(y+1);
            }
        }

    }

    public static boolean isAttack(int y){
        for(int i=0; i<y; i++){
            if(y != i){
                if(map[i] == map[y] || Math.abs(map[y]-map[i]) == Math.abs(y-i)){
                    //같은 x가 있거나 같은 대각선에 위치하면
                    return true;
                }
            }
        }
        return false;
    }
}
