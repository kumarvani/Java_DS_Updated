package arrays;

public class WindowTechniqueFindingMaximumProduct {
	public static void main(String[] args) {
		int[] array={1,6,7,3,2,5,8};
		int k=2;
		int n=array.length;
		int maximum_product=1,window_product=1;
		for(int i=0;i<k;i++) {
			window_product*=array[i];
			maximum_product=window_product;
		}
		
		for(int i=0;i<n-k;i++) {
			window_product*=array[i+k]/array[i];
			maximum_product=Math.max(window_product, maximum_product);
		}
		System.out.println(maximum_product);
	}
	
	
}
