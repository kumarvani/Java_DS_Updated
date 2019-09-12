package arrays;

public class BuildingsFacingSun {
	public static void main(String[] args) {
		int[] array = { 1, 6, 7, 3, 2, 5, 8 };
		int n = array.length;
		int facingBuilding = array[0];
		System.out.print(facingBuilding+" ");

		for (int i = 1; i < n ; i++) {
			if (array[i] > facingBuilding) {
				facingBuilding = array[i];
				System.out.print(facingBuilding+" ");
			}
		}

	}
}
