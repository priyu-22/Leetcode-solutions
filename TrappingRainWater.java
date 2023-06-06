package practice;

public class TrappingRainWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(height));
	}
	
	public static int trap1(int[] height) {
        int ptr1 =0;
        int ptr2 = height.length-1;
        int leftMax = 0;
        int rightMax = 0;
        int trappedWater = 0;
        while(ptr1<ptr2){
            leftMax = Math.max(leftMax, height[ptr1]);
            rightMax = Math.max(rightMax, height[ptr2]);
            if(leftMax > rightMax){
                trappedWater += Math.min(leftMax, rightMax) - height[ptr2];
                ptr2--;
            }else{
                trappedWater += Math.min(leftMax, rightMax) - height[ptr1];
                ptr1 ++;

            }
        }
        return trappedWater;
    }

	//29th may 2023
	public static int trap(int[] height) {
        int left = 0, right = height.length-1;
		int maxL = height[left], maxR = height[right];
		int totalWaterTrapped = 0;
		while(left<right) {
			if(height[left]>height[right]) {
				totalWaterTrapped += (Math.min(maxR, maxL)) - height[right];
				right--;
			}
			else {
				totalWaterTrapped += (Math.min(maxR, maxL)) - height[left];
				left++;
			}
			maxL=Math.max(maxL, height[left]);
			maxR = Math.max(maxR, height[right]);
		}
		return totalWaterTrapped;
    }
}
