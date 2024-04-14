import java.io.*;
import java.util.Arrays;

public class Main {
    public static int n,m, result = 0;
    public static int[] nArray, mArray;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            String[] nm = br.readLine().split(" ");

            n = Integer.parseInt(nm[0]);
            m = Integer.parseInt(nm[1]);

            nArray = new int[n];
            mArray = new int[m];
            result = 0;

            String[] nInput = br.readLine().split(" ");
            String[] mInput = br.readLine().split(" ");

            for(int j=0; j<n; j++){
                nArray[j] = Integer.parseInt(nInput[j]);
            }
            for(int j=0; j<m; j++){
                mArray[j] = Integer.parseInt(mInput[j]);
            }

            Arrays.sort(mArray);

            for(int j=0; j<n; j++){
                search(nArray[j],0,m-1);
            }
            System.out.println(result);
        }
    }

    public static void search(int num, int low, int high){
        if(low > high){
            return;
        }
        int mid = (low + high) / 2;
        if(mArray[mid] < num){  // 잡아먹힘
            result += (mid-low+1);  // mid 포함 앞의 것을 모두 잡아먹음
            search(num,mid+1,high); // 뒤의 배열을 다시 탐색한다
        }else{
            search(num,low,mid-1);
        }
    }
}
