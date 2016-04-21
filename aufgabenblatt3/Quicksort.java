package aufgabenblatt3;

import java.util.Arrays;

public class Quicksort {
	
	
	public int test(){
		
		int[] array = { 40, 20 , 10, 50};
		
		Arrays.sort(array);
		int median;
		if (array.length % 2 == 0)
		    median = (array[array.length/2] + array[array.length/2 - 1])/2;
		else
		    median = array[array.length/2];
		
		return median;
		
	}

	public int[] sort(int[] array, int links, int rechts) {
		
		
		
		
		
		if (rechts > links) {

			int i = links - 1;
			int j = rechts;
			int temp;

			while (true) {
				while (array[++i] < array[rechts]);
				while (array[--j] > array[rechts] && j > i);
				
				if (i >= j){
					break;
				}
				temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
			temp = array[i];
			array[i] = array[rechts];
			array[rechts] = temp;

			sort(array, links, i - 1);
			sort(array, i + 1, rechts);
		} return array;
	}
	public static void main(String[] args) {
		Quicksort a = new Quicksort();
		System.out.println(a.test());
	}

}
