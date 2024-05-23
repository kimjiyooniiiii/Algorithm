import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static int n, k;
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        input(br);

        int sum = 0;
        for(int j=0; j<k; j++){
            sum += list.get(j);
        }
        //System.out.println(sum);
        int max = sum;

        int prev = 0, next = k;
        while (next < list.size()) {
            sum -= list.get(prev);
            sum += list.get(next);
            //System.out.println(sum);
            max = Math.max(max, sum);

            prev++; next++;
        }
        System.out.println(max);
    }


    public static void input(BufferedReader br) throws IOException {
        String[] condition = br.readLine().split(" ");
        n = Integer.parseInt(condition[0]);
        k = Integer.parseInt(condition[1]);

        String[] number = br.readLine().split(" ");
        for(int i=0; i<number.length; i++){
            list.add(Integer.parseInt(number[i]));
        }
        for(int i=0; i<k-1; i++){
            list.add(Integer.parseInt(number[i]));
        }
    }
}

// 행과 열이 길
// 지나가는 곳의 높이가 같으면 길

// 경사로 놓기
