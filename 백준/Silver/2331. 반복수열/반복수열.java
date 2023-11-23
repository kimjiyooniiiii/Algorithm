import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[][] matrix = new int[5][5];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] order = br.readLine().split(" ");
        int firstNum = Integer.parseInt(order[0]);
        int pow = Integer.parseInt(order[1]);
        List<Integer> numRow = new ArrayList<>();
        numRow.add(firstNum);

        int repeatNum = 0;
        int index = 0;
        while(true){
            // 각 자릿수의 제곱수 합으로 새로운 수를 구함
            String numToStr = String.valueOf(numRow.get(index));
            double sum = 0.0;
            for(int j=0; j<numToStr.length(); j++){
                sum += Math.pow(Character.getNumericValue(numToStr.charAt(j)),pow);
            }

            if(numRow.contains(Integer.valueOf((int)sum))){
                repeatNum = (int)sum;
                break;
            }else{
                numRow.add((int)sum);
                index++;
            }
        }

        int result =0;
        for(int i=0; i<numRow.size(); i++){
            if(numRow.get(i) != repeatNum){
                result++;
            }else{
                bw.write(result+"\n");
                bw.flush();
                break;
            }
        }
        bw.close();
    }
}