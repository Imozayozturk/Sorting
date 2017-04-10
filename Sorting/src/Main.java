import java.util.Scanner;
import java.util.Random;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		// Prompt user for array size - trust the user input.
		System.out.print("Enter the size of input: ");
		int size = input.nextInt();
		
		
		// Insertion sort
		System.out.println("INSERTION SORT");
			alternativeInsertion(genArray(size));
			
		
		// Merge sort
		System.out.println("MERGE SORT");
			mergesort(genArray(size));
		
		input.close();
	}
	
	/* This method generates an array filled with pseudo-random numbers.
	 */
	private static int[] genArray(int size) {
		int[] a = new int[size];
		Random rand = new Random();
		for (int i=0; i < size; i++) {
			a[i] = rand.nextInt(10000); // Between 0 and 10k to make it easier on the eyes
		}
		return a;
	}
	
	private static void alternativeInsertion(int [] a){
		
		//printNumbers(a);
		long startTime = System.currentTimeMillis();
		int key=0; 
		for (int j = 1; j < a.length; j++) {
			key = a[j];
			int i;
			i = j-1;
			while(i>=0 && a[i]>key){
				a[i+1] = a[i];
				
				i--;
			};
			a[i+1] = key;
		}
		long endTime = System.currentTimeMillis();
		System.out.println("\t\tSize: " + a.length + "\t\tTime to sort: " + (endTime-startTime) + " milliseconds");
		//System.out.println();
		//printNumbers(a);
	}
	
	private static void mergesort(int[] a) {
		//printNumbers(a);
		long startTime = System.currentTimeMillis(); // Start the timer
		
		mergesort(a, 0, a.length-1);
		
		long endTime = System.currentTimeMillis(); // End the timer
		//printNumbers(a);
		
		System.out.println("\t\tSize: " + a.length + "\t\tTime to sort: " + (endTime-startTime) + " milliseconds");

		
	}
		
	private static void mergesort(int[] a, int top, int bottom) {
		if (top != bottom) {
			int middle = (top + bottom) / 2;
			mergesort(a, top, middle);
			mergesort(a, middle+1, bottom);
			merge(a, top, bottom);
		}
	}
	
	private static void merge(int[] a, int top, int bottom) {
		int t = top;
		int middle = (top + bottom) / 2;
		int b = middle + 1;
		int i = 0;
		int[] s = new int[bottom - top + 1];
		
		while (t <= middle && b <= bottom) {
			if (a[t] < a[b]) {
				s[i] = a[t];
				t++;
			} else {
				s[i] = a[b];
				b++;
			}
			i++;
		}
		
		int last = middle;
		if (b <= bottom) {
			t = b;
			last = bottom;
		}
		
		while (t <= last) {
			s[i] = a[t];
			t++;
			i++;
		
		}
		
		for (i = 0; i < s.length; i++) {
			a[i + top] = s[i];
		
		}
   }
	
	private static void printNumbers(int[] a){
	for (int i = 0; i < a.length; i++) {
		System.out.println(a[i] + ", ");
	}
	System.out.println("\n");
}
}
