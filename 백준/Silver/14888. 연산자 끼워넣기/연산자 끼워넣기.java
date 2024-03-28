import java.io.*;

public class Main {
    public static int[] signCount;
    public static String[] num;
    public static int n,max = -1000000000, min = 1000000000;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        num = br.readLine().split(" ");
        String[] inputSign = br.readLine().split(" ");
        signCount = new int[4];

        for(int i=0; i<4; i++){
            signCount[i] = Integer.parseInt(inputSign[i]);
        }
        recur(Integer.parseInt(num[0]), 1);
        System.out.println(max);
        System.out.println(min);
    }

    public static void recur(int sum, int count){
        if(count == n){
            max = Math.max(max,sum);
            min = Math.min(min,sum);
            return;
        }
        for(int i=0; i<4; i++){
            if(signCount[i] > 0){
                signCount[i]--;
                switch(i){
                    case 0 : recur(sum + Integer.parseInt(num[count]), count+1); break;
                    case 1 : recur(sum - Integer.parseInt(num[count]), count+1); break;
                    case 2 : recur(sum * Integer.parseInt(num[count]), count+1); break;
                    case 3 :
                        if(sum < 0){
                            recur(((-1 * sum) / Integer.parseInt(num[count])) * -1, count+1); break;
                        }else{
                            recur(sum / Integer.parseInt(num[count]), count+1); break;
                        }
                }
                signCount[i]++;
            }

        }
    }
}
