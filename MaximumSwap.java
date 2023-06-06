package practice;

public class MaximumSwap {

	public static void main(String[] args) {}
		//System.out.println(maximumSwap(2736));	}
	
	/*public static int maximumSwap1(int num) {
        int maxNum=0;
        String str = ""+num;
        int maxInt = 0;
        int[] numArr = new int[str.length()];
        for(int j = 0; j<str.length(); j++) {
        	numArr[j] = (str.charAt(j)-'0');
        	maxInt = (numArr[j]>numArr[maxInt])? j:maxInt;
        }
        int temp = numArr[0];
        numArr[0] = numArr[maxInt];
        numArr[maxInt] = temp;
        for (int i = 0; i < numArr.length; i++) {
            maxNum = maxNum * 10 + numArr[i];
        }
        
//        for(int i =0; i<(""+num).length()-1; i++) {
//        	 StringBuilder sb = new StringBuilder(""+num); 
//        	 if(Character.getNumericValue(sb.charAt(i)) < Character.getNumericValue(sb.charAt(i+1))) {
//        		 char temp = sb.charAt(i);
//		    	 sb.setCharAt(i, sb.charAt(i+1));
//		    	 sb.setCharAt(i+1, temp);
//		    	 maxNum=Math.max(maxNum, Integer.valueOf(sb.toString()));
//        	 }
//        	 
//        }
		
		return Math.max(maxNum, num);
    }
	
	public static int maximumSwap(int num) {
        int maxNum=num;
        String str = ""+num;
       // int maxInt = 0;
        int[] numArr = new int[str.length()];
        for(int j = 0; j<str.length(); j++) {
        	numArr[j] = (str.charAt(j)-'0');
        	//maxInt = (numArr[j]>numArr[maxInt])? j:maxInt;
        }
        for(int i = 0; i<numArr.length; i++) {
        	for(int k=i+1; k<numArr.length; k++) {
        		int temp = numArr[k];
        		numArr[k] = numArr[i];
        		numArr[i] = temp;
        		int tmp = 0;
        		for (int m = 0; m < numArr.length; m++) {
                    tmp = tmp * 10 + numArr[m];
                }
        		maxNum = Math.max(maxNum, tmp);
        	}
        }
        
        
        
        
//        for(int i =0; i<(""+num).length()-1; i++) {
//        	 StringBuilder sb = new StringBuilder(""+num); 
//        	 if(Character.getNumericValue(sb.charAt(i)) < Character.getNumericValue(sb.charAt(i+1))) {
//        		 char temp = sb.charAt(i);
//		    	 sb.setCharAt(i, sb.charAt(i+1));
//		    	 sb.setCharAt(i+1, temp);
//		    	 maxNum=Math.max(maxNum, Integer.valueOf(sb.toString()));
//        	 }
//        	 
//        }
		
		return Math.max(maxNum, num);
    }*/
	
	
	

}
