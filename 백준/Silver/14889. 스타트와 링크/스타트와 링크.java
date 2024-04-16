import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int n;
    public static int sum; // 능력치 계산을 위한 변수
    public static int[] value = new int[2];
    public static int[][] table;
    public static int[] makeNum;
    public static List<String> combi = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        table = new int[n][n];
        makeNum = new int[n/2];
        input(br);

        int[] num = new int[n];   // 조합을 위한 숫자 배열 초기화
        for(int i=1; i<=n; i++){
            num[i-1] = (i);
        }
        team(-1,0,num); // 팀 조합 생성

        System.out.println(calculate());
        //System.out.println((19* 17* 2* 2* 13* 11 * 45));
    }

    public static int calculate(){      // 능력치 차이가 최소인 값을 반환
        // combi 리스트에서 각 조합의 능력치 합을 계산한다.
        int size = combi.size();
        int min = 10000;
        for(int i=0; i<size/2; i++){
            String[] t1 = combi.get(i).split(" ");
            String[] t2 = combi.get(size-1-i).split(" ");
            int sumT1, sumT2;

            // t1 = 123 / 1234  여기서 2개를 고른 조합을 다 더한다.
            sum = 0;
           // System.out.println("t1: " + combi.get(i));
            sum(0,0,t1);    // t1 팀의 능력치 합
            sumT1 = sum;

            sum = 0;
            //System.out.println("t2: " + combi.get(size-1-i));
            sum(0,0,t2);    // t2 팀의 능력치 합
            sumT2 = sum;

            int diff = Math.abs(sumT1-sumT2);
            min = Math.min(min,diff);

            //System.out.println(diff + "------------------------");
        }
        return min;
    }

    public static void sum(int prev, int len, String[] s){   // 문자열에서 2개씩 골라 능력치를 합한다.
        if(len == 2){
            int i = value[0]-1;
            int j = value[1]-1;
            sum += (table[i][j] + table[j][i]);
           // System.out.println("i:" + value[0] + " j:" + value[1] + " sum:" + (table[i][j] + table[j][i]) + " total: " + sum);
            return;
        }
        for(int i=0; i<s.length; i++){
             int current = Integer.parseInt(s[i]);
             if(current > prev){
                 value[len] = current;
                 sum(current, len+1, s);
             }
        }
    }

    public static void team(int prev, int len, int[] num){  // n명을 n/2씩 조합하기
        if(len == (n/2)){
            StringBuilder sb = new StringBuilder();
            for(int m : makeNum){
                sb.append(String.valueOf(m) + " ");
            }
            combi.add(sb.toString());   // 완성된 팀 넣기
            return;
        }
        for(int i=0; i<n; i++){
            if(num[i] > prev){
                makeNum[len] = num[i];
                team(num[i], len+1, num);
            }
        }
    }

    public static void input(BufferedReader br) throws IOException {
        for(int i=0; i<n; i++){
            String[] line = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                table[i][j] = Integer.parseInt(line[j]);
            }
        }
    }
}
