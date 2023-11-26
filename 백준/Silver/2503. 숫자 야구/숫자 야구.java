import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Integer> possible = new ArrayList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[] visited;
    static int[] selection;
    static List<info> list;

    static class info{
        String num;
        int strike,ball;

        public info(String num, int strike, int ball) {
            this.num = num;
            this.strike = strike;
            this.ball = ball;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int talk = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for(int i=0; i<talk; i++){
            String[] array = br.readLine().split(" ");
            list.add(new info(array[0], Integer.parseInt(array[1]), Integer.parseInt(array[2])));
        }

        int n = 9;
        int r = 3;
        visited = new boolean[n+1];
        selection = new int[r];
        make(n,0);  // 모든 경우의 수 만들기

        for(int i=0; i<possible.size(); i++){
            boolean is = check(possible.get(i));
            if(is == false){
                possible.remove(i);
                i--;
            }
        }

        bw.write(possible.size()+"");
        bw.flush();
        bw.close();

    }
    // 3자리수 만들거나 5자리수 만들거나 6자리수 만드는 함수 만들기
    public static void make(int n, int r){
        if(r == 3){
            possible.add((selection[0]*100 + selection[1]*10 + selection[2]));
            return;
        }

        for(int i=1; i<=n; i++){
            if(visited[i]) continue;
            selection[r] = i;
            visited[i] = true;
            make(n,r+1);
            visited[i] = false;
        }
    }

    public static boolean check(int num){
        String s = String.valueOf(num);

        for(int i=0; i<list.size(); i++){
            String listNum = list.get(i).num;
            int realStrike = 0;
            int realBoll = 0;

            for(int j=0; j<3; j++){
                if(s.charAt(j) == listNum.charAt(j)){
                    realStrike++;
                }
            }
            if(realStrike != list.get(i).strike){
                return false;
            }

            for(int j=0; j<3; j++){
                int temp = (j+1)%3;
                if(s.charAt(j) == listNum.charAt(temp)){
                    realBoll++;
                }
                temp = (j+2)%3;
                if(s.charAt(j) == listNum.charAt(temp)){
                    realBoll++;
                }
            }
            if(realBoll != list.get(i).ball){
                return false;
            }
        }
        return true;
    }
}