import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int start = 100;
        String destination = br.readLine();
        int count = Integer.parseInt(br.readLine());
        List<String> brokeStr = new ArrayList<>();
        if(count !=0){
            brokeStr = Arrays.asList(br.readLine().split(" "));
        }
        int onlyPM = Math.abs(start - Integer.parseInt(destination));    // +,-로만 이동했을 때

       for(int i=0; i<destination.length(); i++){
           // 만약 고장난 버튼이 있으면 방법을 찾으러 가기
           if(brokeStr.contains(String.valueOf(destination.charAt(i)))){
               int searchResult = searchMethod(destination, brokeStr);
               if(searchResult == -1){
                   bw.write(onlyPM + "\n");
                   bw.flush();
                   bw.close();
                   return;
               }
               if(searchResult > onlyPM){
                   bw.write(onlyPM + "\n");
                   bw.flush();
               }else{
                   bw.write(searchResult + "\n");
                   bw.flush();
               }
               bw.close();
               return;
           }
       }
       int len = destination.length();
       bw.write(Math.min(len,onlyPM) + "\n");
       bw.flush();
       bw.close();
    }

    public static int searchMethod(String destination, List<String> brokeStr) {
        int des = Integer.parseInt(destination);
        int bigger = des;
        int smaller = des;

        // 자신보다 큰 숫자에서 방법찾기
        for(int i=des+1; i<=999900; i++){
            String check = String.valueOf(i);
            boolean pass = true;
            // 새로 찾은 숫자가 고장난 버튼을 포함하는지
            for(int j=0; j<check.length(); j++){
                if(brokeStr.contains(String.valueOf(check.charAt(j)))){
                    pass = false;
                    break;
                }
            }
            if(pass){   // 모든 숫자가 고장나지 않았다면
                bigger = i;
                break;
            }
        }

        //자신보다 작은 숫자에서 방법찾기
        for(int i=des-1; i>=0; i--){
            String check = String.valueOf(i);
            boolean pass = true;
            // 새로 찾은 숫자가 고장난 버튼을 포함하는지
            for(int j=0; j<check.length(); j++){
                if(brokeStr.contains(String.valueOf(check.charAt(j)))){
                    pass = false;
                    break;
                }
            }
            if(pass){   // 모든 숫자가 고장나지 않았다면
                smaller = i;
                break;
            }
        }

        // 반환해주는 값 정하기
        if(bigger == des && smaller == des){    // 큰수나 작은수가 모두 고장난 수라면
            return -1;
        }else if(bigger == des){
            return (des - smaller) + String.valueOf(smaller).length();
        }else if(smaller == des){
            return (bigger - des) + String.valueOf(bigger).length();
        }else{
            int countB = (bigger - des) + String.valueOf(bigger).length();
            int countS = (des - smaller) + String.valueOf(smaller).length();

            if(countB > countS){
                return countS;
            }else{
                return countB;
            }
        }
    }

}