package utilities;

import java.util.Comparator;
import domain.Product;

public class QuickSort {
	/*@param products array which contains elements.
	 * Checks if the array is null or is empty, to see what the next step is.
	 * @return If array is null or only has 1 or less, there's no sorting needed.
	 */
	public static void sort(Product[] products, Comparator<Product> comp) {
		if (products == null || products.length <= 1) { 
			return;
		}
		//Sorts the array from smallest to largest: low index starting at 0, high index the last element of the array.
		quickSort(products, 0, products.length - 1, comp);  
	}
	private static void quickSort(Product[] products, int low, int high, Comparator<Product> comp) {
		//If low is greater than or equal to high, return because the section of the array we want to sort has only one element or no element, which means it's already sorted.
		if (low >= high) { 
			return;
		}
		/*
		 * Partition for the section between low and high. 
		 * Sorts the left and right side of the array
		 */
		int split = part(products, low, high, comp); 
		quickSort(products, low, split - 1, comp); 
		quickSort(products, split + 1, high, comp); 
	}
	 // //Used to find the middle index between for median of 3.
	private static int part(Product[] products, int low, int high, Comparator<Product> comp) {
		int mid = low + (high - low) / 2; 
		/*
		 * IF statements compares the value of low and mid, low and high, mid and high.
		 * This is used for Median of 3, to sort them in order from low, mid, and high. 
		 * Temporary variable is then used to store the current value of low/mid index.
		 */
		if (comp.compare(products[low], products[mid]) < 0){ 
			Product temp = products[low]; 
			products[low] = products[mid]; 
			products[mid] = temp; 
		}
		if (comp.compare(products[low], products[high]) < 0) { 
			Product temp = products[low];
			products[low] = products[high]; 
			products[high] = temp; 
		}
		if (comp.compare(products[mid], products[high]) < 0) {
			Product temp = products[mid]; 
			products[mid] = products[high]; 
			products[high] = temp; 
		}
		/*Temporary variable temp1 stores the current [mid] index.
		 * Since [high] has already been figured out from previous statement, [j] is then pushed inward (products[high - 1]) because that element has been sorted and is in the right place.
		 * Index is move one inward.
		 */
		Product temp1 = products[mid];
		products[mid] = products[high - 1];
		products[high - 1] = temp1;
		
		//Pivot at the index high - 1.
		Product benchmark = products[high - 1]; 
		
		//Initial pointer for the left and right side of the array.
		int i = low; 
		int j = high - 1; 
		
		//Partition loop
		while (true) {
			
			i++;
			//While the value of the array at low is greater than the benchmark(pivot), i moves right.
			while (comp.compare(products[i], benchmark) > 0) { 
				i++;
			}
			j--;
			//While the value of the array is less than the benchmark(pivot), j moves left.
			while (comp.compare(products[j], benchmark) < 0) { 
				j--;
			}
			//Loops break when both left and right pointer intersects.
			if (i >= j) { 
				break;
			}
			/*
			 * Used to make sure that both pointers (i and j) are in the correct spot and swaps them if not.
			 * Ensures that elements are sorted properly: no small are on the right side, and no big are on the left side. 
			 */
			Product temp2 = products[i]; 
			products[i] = products[j]; 
			products[j] = temp2; 
        }
		/*
		 * Make sures that everything is in placed in the index with proper pivot. Process repeats until every thing is sorted.
		 * @return index for partition
		 */
		Product temp3 = products[i];
		products[i] = products[high - 1];
		products[high - 1] = temp3;
		
		return i; 
	}
	}


