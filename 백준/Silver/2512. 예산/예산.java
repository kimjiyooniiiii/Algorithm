import java.io.*;
import java.util.Arrays;

public class Main {

    public static int spare = 0, upLine, overIndex = 0;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] require = new int[n];

        String[] inputArray = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            require[i] = Integer.parseInt(inputArray[i]);
        }
        Arrays.sort(require);
        int money = Integer.parseInt(br.readLine());

        if(sum(require) <= money){      // 처음 예산으로 모두 배정이 가능하면
            System.out.println(require[n-1]);
            return;
        }

        upLine = money / n;     // 처음엔 평균으로 상한선 정하기
        spare += (money % n);   // 상한선만큼 배분하고 남은돈 보관
        //System.out.println("상한선 " + upLine + " overIndex 0");

        while(spare(require,overIndex)){    // 더 모을 수 있는 예산이 있을 때까지 반복
            int divide = spare / (n-overIndex); // 나눠줄 수 있는 예산 평균
            upLine += divide;  // 상한선 다시 정하기
            spare -= (divide * (n-overIndex));  // 상한선에 따라 다시 예산을 나눠준다
            //System.out.println("상한선 " + upLine + " overIndex " + overIndex);
        }
        System.out.println(upLine);

    }
    public static boolean spare(int[] require, int start){  // require은 오름차순으로 정렬됨
        if(require[start] >= upLine){
            return false;
        }
        for(int i=start; i<require.length; i++){
            if(require[i] > upLine){
                break;
            }
            spare += (upLine - require[i]); // 예산 더 모으기
            overIndex++;    // 예산을 못맞춘 지방의 인덱스 계산
        }
        //System.out.println("남는거 " + spare);
        return true;
    }

    public static int sum(int[] require){
        int sum = 0;
        for(int r : require){
            sum += r;
        }
        return sum;
    }
}
