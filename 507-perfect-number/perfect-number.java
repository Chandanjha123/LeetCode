class Solution {
    public boolean checkPerfectNumber(int num) {

        int halfNum=num/2;
        int perfectNum=0;
        for(int i=1;i<=halfNum;i++){
            if(num%i==0){
                perfectNum += i;
            }
        }
        return(perfectNum==num);
        
    }
}