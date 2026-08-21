class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int maxx=0;
        while(left<right){
           int width=right-left;
            int water=Math.min(height[left],height[right])*width;
            maxx=Math.max(water,maxx);
        if(height[left]<height[right]){
            left++;
        }
        else{
            right--;
        }
        }
        return maxx;
        
    }
}