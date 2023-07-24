class Solution {
    public long solution(int price, int money, int count) {
        long total = 0;
        long haveTo = 0;
        
        while(count > 0){
            total += (Long.valueOf(price) * count);
            
            count--;
        }
        if(total > money){
            haveTo =  total - money;
        }else{
            haveTo = 0;
        }
        
        return haveTo;

    }
}