import java.io.*;
import java.util.Arrays;

public class Main {
    public static int n,s, result = 0;
    public static int[] num;
    public static int[] split;
    public static boolean[] visit;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        test t = new test();
//        t.aa();

        String[] option = br.readLine().split(" ");
        n = Integer.parseInt(option[0]);
        s = Integer.parseInt(option[1]);

        String[] numLine = br.readLine().split(" ");
        num = new int[n];
        split = new int[n];
        visit = new boolean[n];

        for(int i=0; i<n; i++){
            num[i] = Integer.parseInt(numLine[i]);
        }
        Arrays.sort(num);
        // 길이가 n인 조합 만들기
        for(int i=1; i<=n; i++){
            backTracking(0,i,-100001);
        }

        //backTracking(0,2,-100000);
        System.out.println(result);
    }

    public static void backTracking(int count, int length, int prevIndex){
        if(count == length){
            int sum = 0;
            for(int i=0; i<length; i++){
        //        System.out.print(split[i] + " ");
                sum += split[i];
            }
            if(sum == s){
                result++;
            }
      //      System.out.println();
            return;
        }
        for(int i=0; i<n; i++){
            int current = num[i];
            if(!visit[i] && prevIndex<i){
                visit[i] = true;
                split[count] = current;
                backTracking(count+1, length, i);
                visit[i] = false;
            }
        }
    }
}
