package arrayExample;

import java.util.HashSet;

class ArrayCal{
	
	static boolean checkSum(int arr[], int n) {
		int[] sum= new int[arr.length];
		for (int i = 0; i < n; i++) {
			sum[i]=arr[i]+1;
		}
		
		HashSet<Integer> s = new HashSet<Integer>(); 
        for (int i = 0; i < n; i++) 
        { 
            int val = sum[i] - arr[i]; 
  
            // If element exist than return the pair 
            if (s.contains(val) &&  
                val == (int) s.toArray()[s.size() - 1])  
            { 
                System.out.printf("There is such element", 
                        arr[i], val); 
                return true; 
            } 
            s.add(arr[i]); 
        } 
		return false;
	}
}

public class ArrayManipulation {
	static ArrayCal cal =new ArrayCal();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,3,7,3,5};
		int n = arr.length;
		if(cal.checkSum(arr,n)==false) {
			System.out.printf("No such element"); 
		}

	}

}
