import java.io.*;
import java.util.Arrays;

public class Main {
    public static int n,m;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        int[] nArray = new int[n];
        String[] nInput = br.readLine().split(" ");

        for(int i=0; i<n; i++){
            nArray[i] = Integer.parseInt(nInput[i]);
        }
        Arrays.sort(nArray);

        m = Integer.parseInt(br.readLine());
        int[] result = new int[m];
        String[] mInput = br.readLine().split(" ");

        for(int i=0; i<m; i++){
            if(search(Integer.parseInt(mInput[i]),nArray,0,n-1)){
                result[i] = 1;
            }
        }

        for(int i : result){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static boolean search(int num, int[] nArray, int low, int high){
        if(low > high){
            return false;
        }
        int mid = (low + high) / 2;
        if(nArray[mid] == num){
            return true;
        }else if(nArray[mid] > num){
            return search(num, nArray, low,mid-1);
        }else{
            return search(num, nArray, mid+1,high);
        }
    }
}
