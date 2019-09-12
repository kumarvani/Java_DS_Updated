package arrays;


public class WindowTechniqueFindingMaximumSum {
	public static void main(String[] args) {
		int[] array={1,6,7,3,2,5,8};
		int k=2;
		int n=array.length;
		int maximum_sum=0, window_sum=0;
		
		for(int i=0;i<k;i++) {
			maximum_sum+=array[i];
			window_sum=maximum_sum;
		}
		
		for(int i=0;i<n-k;i++) {
			window_sum+=array[i+k]-array[i];
			maximum_sum = Math.max(maximum_sum, window_sum);
		}
		System.out.println(maximum_sum);
	}
}
