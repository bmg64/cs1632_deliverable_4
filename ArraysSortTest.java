import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;


public class ArraysSortTest {

	/* Property-based test of Arrays.sort() that ensures the following invariants:
	 *  1. The input and output arrays are of the same length
	 *  2. Values in the output array are never decreasing
	 *  3. Every element in the input array is in the output array
	 *  4. No element not in the input array is in the output array
	 */
	@Test
	public void SortTest() {
		
		int[][] arrays = new int[100][];
		int[][] oldArrays;
		
		//create 100 arrays of a random length 1-10 and populate them with random ints 1-100
		for(int i = 0; i < arrays.length; i++){
			int len = (int) Math.random() * 10;
			int[] temp = new int[len];
			for(int j = 0; j < len; j++){
				temp[j] = (int) Math.random() * 100;
			}
			arrays[i] = temp;
		}
		
		oldArrays = arrays;
		
		for(int i = 0; i < arrays.length; i++){
			Arrays.sort(arrays[i]);
		}
		
		for(int i = 0; i < arrays.length; i++){
			
			//test that the input and the output arrays are of the same length
			assertEquals(arrays[i].length, oldArrays[i].length);
			
			//test that values in the output array are never decreasing
			for(int j = 1; j < arrays[i].length; j++){
				if(arrays[i][j] < arrays[i][j-1]){
					fail("Output array decreases");
				}
			}
			
			//test that every element in the input array is in the output array
			boolean found;
			for(int j = 1; j < oldArrays[i].length; j++){
				found = false;
				for(int k = 1; k < arrays[i].length; k++){
					if(oldArrays[i][j] == arrays[i][k]){
						found = true;
						break;
					}
				}
				if(!found){
					fail("Element from input array missing from output array");
					break;
				}
			}
			
			//test that no element not in the input array is in the output array
			for(int j = 1; j < arrays[i].length; j++){
				found = false;
				for(int k = 1; k < oldArrays[i].length; k++){
					if(arrays[i][j] == oldArrays[i][k]){
						found = true;
						break;
					}
				}
				if(!found){
					fail("Element found in output array that is not found in input array");
					break;
				}
			}
		}
		
	}

}
