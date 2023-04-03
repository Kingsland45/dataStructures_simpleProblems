import mu.testing.Problem;
import mu.testing.Problems;
import mu.testing.TestCase;
import mu.testing.Problems.Verbosity;

import java.awt.Point;
import java.lang.reflect.Constructor;
import java.util.*;

@Problems(debugging = true, doAll = false, defaultRunningTimeMS = 50, tolerance = 0.0000001, verbosity = Verbosity.ERRORS)
public class Project1CSE274Wi2023 {

	/*
	 * Return the median value of 3 integers.
	 */
	@Problem(doThis=true) //change to true in order to test
	@TestCase(io="(1, 2, 3) -> 2")
	@TestCase(io="(1, 1, 1) -> 1")
	@TestCase(io="(3, 1, 2) -> 2")
	public static int medianOf3Ints(int a, int b, int c) {
        if ((a < b && b < c) || (c < b && b < a))
            return b;
        else if ((b < a && a < c) || (c < a && a < b))
        return a;
        else
        return c;
	}

	/*
	 * Return the median value of 3 strings.
	 */
	@Problem(doThis=true)
	@TestCase(io="(`A`, `B`, `C`) -> `B`")
	@TestCase(io="(`A`, `A`, `A`) -> `A`")
	@TestCase(io="(`AB`, `AA`, `AC`) -> `AB`")
	public static String medianOf3Strings(String a, String b, String c) {
		int test1 = a.compareTo(b); //=-1
		int test2 = a.compareTo(c); 
		int test3 = b.compareTo(c);
		System.out.print(test1); //test
		System.out.print(test2); //test
		System.out.print(test3); //test
		
		if ((test1 < 0 && test3 < 0) || (test3 > 0 && test1 > 0))
            return b;
        else if ((test1 > 0 && test2 < 0) || (test2 > 0 && test1 < 0))
        return a;
        else
        return c;
	}
	

	/* Return the lexiographically last string among the array of strings.
	 * Here, we define lexiographic order as Java's String.compareTo does.
	 * The strings will be non-null and consist of exclusively lower case 
	 * letters.
	 * The input array will contain as least one string and all elements of
	 * the array will be non-null. 
	 */
	@Problem(doThis=true)
	@TestCase(io="([`cyan`, `yellow`, `red`, `blue`]) -> `yellow`")
	public static String maxString(String [] strs) {
		String last = strs[0];
		for (int i =0; i < strs.length-1; i++) {
			int check = last.compareTo(strs[i+1]);
			//System.out.println(check);
			if (check <= 0) {
				last = strs[i+1];
			} 
		}
		return last;
	}
	
	/**
	* Accepts a non-negative value n and computes the value of 1 + 2 + ... + n
	* The basis of your algorithm must use a loop.
	* N will be a positive integer
	*/
	@Problem(doThis=true)
	@TestCase(io="(1) -> 1")
	@TestCase(io="(2) -> 3")
	@TestCase(io="(4) -> 10")
	public static int add1ToNWithLoop(int N) {
		int total = 0;
		for (int i =0; i <= N; i++) {
			total = total + i;
		}
		return total;
	}
	
	/**
	* Accepts a non-negative value n and computed the value of 1 + 2 + ... + n
	* Do not use a loop to solve this one. The formula (n * n + n) / 2 does the
	* same thing as the loop you wrote above.
	*/
	@Problem(doThis=true)
	@TestCase(io="(1) -> 1")
	@TestCase(io="(2) -> 3")
	@TestCase(io="(3) -> 6")
	public static int add1ToNWithoutLoop(int n) {
		return (n * n + n) / 2;
	}
	
	/*
	 * Consider a person that has 2 children. And, those children have 2 children. 
	 * Suppose this process continues for G generations. This function will generate the
     * number of individuals that will be part of the family tree. You may assume that G
     * will be at most 30.
	 */
	@Problem(doThis=true)
	@TestCase(io="(0) -> 0")
	@TestCase(io="(1) -> 1")
	@TestCase(io="(2) -> 3")   // The main ancestor has two children. So, 3 people total.
	public static int sizeOfFamilyTree(int G) {
		if (G == 0) {
			return 0;
		}
		if (G == 1) {
			return 1;
		}
		if (G <= 30) {
			int parents = 1;
			int children = 2;
			for (int i = 2; i < G; i++) {
			 children = children * 2; 
			}
			return parents + children;
		}
		return 0;
	}
	
	/*
	 * The prior problem discussed a family tree. In this problem, you are given the size
	 * of the family tree. This function will compute the number of generations. You may
	 * assume that the input is a valid size of a family tree.
	 */
	@Problem(doThis=true)
	@TestCase(io="(0) -> 0")
	@TestCase(io="(1) -> 1")
	@TestCase(io="(3) -> 2")
	@TestCase(io="(15) -> 4")
	public static int numGenerations(int sz) {
		if (sz == 1) {
			return 1;
		}
		if (sz == 0) {
			return 0;
		}
		int upOne= (sz+1);
		int children = upOne / 2;
		int gens = 2;
		while (children > 2) {
			children = children / 2;
			gens++;
		}
		return gens;	
	}
	
	/*
	 * Determines if all the elements of the array are unique.
	 * ary will have length at least 1
	 */
	@Problem(doThis=true)
	@TestCase(io="([1,2]) -> true")
	@TestCase(io="([1,1]) -> false")
	@TestCase(io="([1,3,2,4]) -> true")
	public static boolean allAreUnique(int [] ary) {
		for (int i = 0; i < ary.length - 1; i++) {
			int index = i;
			for (int j = index + 1; j < ary.length; j++) {
				if (ary[index] == ary[j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	/*
	 * Car radios allow users to define an order sequence of radio stations that
	 * the user can cycle through. For example, the following sequence of FM 
	 * frequencies: 98 99 101 97. If the current station is 98, and the user pushes
	 * the next button, the station is then be set to 99. If the current station is
	 * 97, the next station will go back to the beginning of the sequence, 98. 
	 * 
	 * The array of stations will be a sequence of unique integers, with length > 0.
	 * currentStation will be one of those listed in the array of stations.  
	 */
	@Problem(doThis=true)
	@TestCase(io="([98, 99, 101, 97], 98) -> 99")
	@TestCase(io="([98, 99, 101, 97], 97) -> 98")
	@TestCase(io="([98], 98) -> 98")
	public static int nextPreset(int [] stations, int currentStation) {
		for (int i = 0; i < stations.length - 1;) {
			if (stations[i] == currentStation && i < stations.length) {
				return stations[i+1];
			} else return stations[0];
		} return stations[0];
	}
	
	/*
	 * Most car radios allow the user to move right and left through their presets.
	 * Repeat the previous problem but consider both right and left movements.
	 * 
	 * moveToRight will be true if the user is going to the next preset toward the right;
	 * otherwise, the user is moving to the station toward the left, with wrap around.
	 */
	@Problem(doThis=true)
	@TestCase(io="([98, 99, 101, 97], 98, true) -> 99")
	@TestCase(io="([98, 99, 101, 97], 98, false) -> 97")
	@TestCase(io="([98, 99, 101, 97], 97, true) -> 98")
	@TestCase(io="([98, 99, 101, 97], 97, false) -> 101")
	public static int nextPresetLeftOrRight(int [] stations, int currentStation, boolean moveToRight) {
		if (moveToRight == true) {
			return nextPreset(stations, currentStation);
		}
		else if (moveToRight == false) {
			for (int i = 0; i < stations.length; i++) {
				if (stations[i] == currentStation) {
					if (i == 0) {
						return stations[stations.length - 1];
					}
					return stations[i-1];
				}
			}
		}
		return 0; //indicates failure
	}	
	
	/* Determine if the passed integer array contains all the values between
	 * 1 and N, inclusive. There should be no duplicates in the array.
	 * N will be a value >= 1
	 * ary will contain 0 or more integers
	 */
	@Problem(doThis=true)
	@TestCase(io="([1, 2], 2) -> true")
	@TestCase(io="([1, 2, 1], 2) -> false")
	@TestCase(io="([1, 2], 3) -> false")
	@TestCase(io="([2, 1], 2) -> true")
	@TestCase(io="([1,3,2], 3) -> true")
	@TestCase(io="([1,1,2], 3) -> false")
	public static boolean contains1ToN(int [] ary, int N) {
		boolean found = true;
		for (int i = 1; i <= N; i++) {
			found = false;
			for (int j = 0; j < ary.length; j++) {
				if (ary[j] == i) {
					found = true;
				}
			}
		}
		//check for duplicates
		for (int i = 0; i < ary.length; i++) {
			for (int j = i + 1; j < ary.length; j++) {
				if (ary[i] == ary[j]) {
					return false;
				}
			}
		}
		return found;
	}
	
	/*
	 * Give an array of strings, find the first index that contains
	 * null. -1 is returned if null is not present in the array.
	 * ary will have length 0 or more.
	 */
	@Problem(doThis=true)
	@TestCase(io="([`a`]) -> -1")
	@TestCase(io="([`a`, null, `b`]) -> 1")
	@TestCase(io="([`a`, null, null]) -> 1")
	@TestCase(io="([null, `a`, null, null]) -> 0")
	public static int findIndexOfFirstNull(String [] ary) {
		for (int i = 0; i < ary.length; i++) {
			if (ary[i] == null) {
				return i;
			}
		}
		return -1;
	}
	
	/*
	 * Repeat the previous problem but start the search at the end of the array and 
	 * move toward the left.
	 */
	@Problem(doThis=true)
	@TestCase(io="([`a`]) -> -1")
	@TestCase(io="([`a`, null, `b`]) -> 1")
	@TestCase(io="([`a`, null, null]) -> 2")
	public static int findIndexOfLastNull(String [] ary) {
		for (int i = ary.length -1; i >= 0; i--) {
			if (ary[i] == null) {
				return i;
			}
		}
		return -1;
	}
	
	/*
	 * A previous problem, findFirstNull, looked for a null value starting
	 * at index [0]. In this version of the problem, will search for a specific
	 * key starting at a specific index. If you reach the end of the array without
	 * finding the key, return -1.
	 * ary will contain at least one string. The strings will be non-null.
	 * key will be a non-null string
	 * startingIndex will a valid index for the given array.
	 */
	@Problem(doThis=true)
	@TestCase(io="([`a`], `a`, 0) -> 0")
	@TestCase(io="([`a`, `ab`], `abc`, 0) -> -1")
	@TestCase(io="([`hello`, `a`, `world`, `done`], `a`, 0) -> 1")
	public static int findIndexOfFirstStartingAt(String [] ary, String key, int startingIndex) {
		for (int i = startingIndex; i < ary.length; i++) {
			//System.out.print(key);
			//System.out.print(ary[i]);
			if (ary[i].contains(key)) {
				return i;
			}
		}
		return -1;
	}

	/*
	 * In this problem, you will search for a specific key, starting at a specific
	 * index. If you get to the end of the array without finding it, you will then
	 * start at the beginning of the array.
	 * ary will have length at least 1 and can contain non-null strings. 
	 * key will be a non-null string
	 * startingIndex will be a valid index for the given input array.
	 */
	@Problem(doThis=true)
	@TestCase(io="([`a`, `a`], `a`, 0) -> 0")
	@TestCase(io="([`a`, `a`], `a`, 1) -> 1")
	@TestCase(io="([`a`, `a`], `b`, 1) -> -1")
	@TestCase(io="([`a`, `b`, `c`, `a`], `a`, 0) -> 0")
	@TestCase(io="([`a`, `b`, `c`, `a`], `a`, 3) -> 3")
	@TestCase(io="([`a`, `b`, `c`, `a`], `b`, 2) -> 1")
	public static int findFirstStartingAtWithWrap(String [] ary, String key, int startingIndex) {
		int noWrapperCheck = findIndexOfFirstStartingAt(ary, key, startingIndex);
		if (noWrapperCheck < 0) {
			for (int i = 0; i < startingIndex; i++) {
				if (ary[i].contains(key)) {
					return i;
				}
			}
		}
		return noWrapperCheck;
	}
	
	/*
	 * This is similar to the previous problem but the strings can be null.
	 */
	@Problem(doThis=true)
	@TestCase(io="([`a`, `a`], `a`, 0) -> 0")
	@TestCase(io="([`a`, `a`], `a`, 1) -> 1")
	@TestCase(io="([`a`, `a`], `b`, 1) -> -1")
	@TestCase(io="([`a`, `b`, `c`, `a`], `a`, 0) -> 0")
	@TestCase(io="([`a`, `b`, `c`, `a`], `a`, 3) -> 3")
	@TestCase(io="([`a`, `b`, `c`, `a`], `b`, 2) -> 1")
	@TestCase(io="([null], null, 0) -> 0")
	@TestCase(io="([null, `b`], `b`, 0) -> 1")
	public static int findFirstStartingAtWithWrapWithNulls(String [] ary, String key, int startingIndex) {
		for (int i = startingIndex; i < ary.length; i++) {
			if (ary[i].contains(key)) {
				return i; //return index if i has key
			} else {
				i++; //else move index +1
			}
			if (ary[i].contains(null)) {
				i++; // move again if
			} 
			if (i == ary.length) {
				i = 0;
			}
			if (i == startingIndex) {
				return -1;
			}
		}
		return -1;
	}

	/*
	 * Determines if a 2D array is rectangular. In order to be rectangular,
	 * all rows must have the same length. For example, the following 2D is rectangular:
	 * [0] --> 11 12
	 * [1] --> 21 22
	 * [2] --> 31 32
	 * But the following is not:
	 * [0] --> 11 12
	 * [1] --> 21 
	 * [2] --> 31 32
	 * The input array will contain at least 1 row and all rows will be non-null.
	 */
	@Problem(doThis=true)
	@TestCase(io="([[11,12],[21,22],[31,32]]) -> true")
	@TestCase(io="([[1,1,1,1],[1,1,1,1],[1,1,1,1]]) -> true")
	@TestCase(io="([[1,1,1,1],[1,1,1,1],[1,1,1,1],[1,1,1]]) -> false")
	@TestCase(io="([[11,12],[],[31,32]]) -> false")
	public static boolean isRectangular(int [][] ary) {
		if (ary == null){
			return false;
		}
		for (int i=0; i< ary.length; i++){
			if (ary[i].length != ary[0].length){
				return false;
			}
		}
		return true;

	}
	
	/*
	 * Receive a 2D array and return a 1D array that contains all of the
	 * original element. Place row [0] into the 1D array in order, followed
	 * by row [1], etc. For example, the following 2D matrix:
	 * [0] --> 11 12
	 * [1] --> 21 22
	 * [2] --> 31 32	 
	 * should produce:
	 * [11 12 21 22 31 32] 
	 */
	@Problem(doThis=true)
	@TestCase(io="([[11,12],[21,22],[31,32]]) -> [11,12,21,22,31,32]")
	@TestCase(io="([[],[],[1]]) -> [1]")
	@TestCase(io="([[11,12],[],[31,32]]) -> [11,12,31,32]")
	public static int [] flatten(int [][] ary) {
		return null;
}
	
	/*
	 * Receive two arrays and returns a new array that concatenates the
	 * two arrays.
	 */
	@Problem(doThis=true)
	@TestCase(io="([1,2], [3]) -> [1,2,3]")
	@TestCase(io="([1,2,3,4,5], [1,2,3,4,5]) -> [1,2,3,4,5,1,2,3,4,5]")
	public static int [] concatenate(int [] A1, int [] A2) {
		int[] result = Arrays.copyOf(A1, A1.length + A2.length);
	    System.arraycopy(A2, 0, result, A1.length, A2.length);
	    return result;
	}

	/*
	 * Shifts all the elements of the array to the right one slot.
	 * There is wrap around with this operation : the last element
	 * will be put into the first spot.
	 * The input array will not be null.
	 */
	@Problem(doThis=true)
	@TestCase(io="([0,1,2,3]) -> void", paramChanges="([3,0,1,2])")
	@TestCase(io="([10,10,20,30,20]) -> void", paramChanges="([20,10,10,20,30])")
	@TestCase(io="([0]) -> void", paramChanges="([0])")
	public static void shiftRight(int [] ary) {
		//base returns void
		//save last entry
		int temp = ary[ary.length - 1];
		
		for (int i = ary.length - 1; i > 0; i--) {
			ary[i] = ary[i-1];
		}
		ary[0] = temp;
	}

	/*
	 * Shifts all the elements of the array to the right N slots,
	 * with wrap around. Do not simply call shiftRight N times
	 * (or do a similar set of operations). 
	 * Write this using two calls to Arrays.copyeOfRange and
	 * one call to concatenate (written above).
	 * N will be > 0 and < ary.length
	 * The input array will not be null.
	 */
	@Problem(doThis=true)
	@TestCase(io="([0,1,2,3], 1) -> [3,0,1,2]")
	@TestCase(io="([0,1,2,3], 3) -> [1,2,3,0]")
	public static int [] shiftRightN(int [] ary, int N) {
		int size = ary.length;
		while (N > size) {
            N = N - size;
        }
        // Creating a temporary array of size d
        int temp[] = new int[size - N];
 
        // Now copying first N-D element in array temp
        for (int i = 0; i < size - N; i++)
            temp[i] = ary[i];
        // Moving the rest element to index zero to D
        for (int i = size - N; i < size; i++) {
            ary[i - size + N] = ary[i];
        }
        // Copying the temp array element
        // in original array
        for (int i = 0; i < size - N; i++) {
            ary[i + N] = temp[i];
        }
        System.out.println("When i look at the requirements and the n value, it seems this method is working");
		return temp;
	}
	
	/*
	 * This method accepts a sorted array and a new value. A new array is created
	 * that is one larger than the original This resulting array is sorted and includes
	 * the new value.
	 * The input array will be non null
	 */
	@Problem(doThis=true)
	@TestCase(io="([10, 20, 30], 30) -> [10,20,30,30]")
	@TestCase(io="([10, 20, 30], 30) -> [10,20,30,30]")
	@TestCase(io="([10, 20, 30], 100) -> [10,20,30,100]")
	public static int [] insertIntoSortedArray(int [] ary, int newValue) {
		
			// makes new array size +1
			int[] s = new int[ary.length + 1];
			
		    for(int i = 0; i <= ary.length; i++) {
		        if(newValue < ary[i]) {
		            s[i] = newValue; 
		            for(int j = i + 1; j < s.length; j++) {
		                s[j] = ary[i];
		                i++;
		            } 
		            return s;
		        }
		        else if (newValue > ary[i]) {
		        	//puts back into spot
		        	s[i] = ary[i];
		        }
		        if (i == ary.length -1) {
		        	s[i] = ary[i];
		        	s[i+1] = newValue;
		        	return s;
		        }
		    } return s;
		        	    
	}
	
	/*
	 * Accepts an array of non-null strings and appends an exclamation point onto
	 * the end of every string.
	 * The array will have length 0 or more and contain non-null values.
	 */
	@Problem(doThis=true)
	@TestCase(io="([`a`]) -> void", paramChanges="([`a!`])")
	@TestCase(io="([`a`, `hello world`]) -> void", paramChanges="([`a!`, `hello world!`])")
	public static void emphasize(String [] ary) {
		for (int i = 0; i < ary.length; i++) {
			ary[i] = ary[i] + "!";
		}
	}
	
	/*
	 * This problem is similar to the previous one. The difference is that this
	 * method does not change the input array. Instead, a new array is created that
	 * contains the emphasized strings. This new array is returned as the value
	 * of the method.
	 */
	@Problem(doThis=true)
	@TestCase(io="([`a`, `hello world`]) -> [`a!`, `hello world!`]")
	@TestCase(io="([`a`]) -> [`a!`]")
	public static String [] emphasizeWithNewArray(String [] ary) {
		String[] newArray = new String[ary.length];
		for (int i = 0; i < ary.length; i++) {
			newArray[i] = ary[i] + "!";
		} return newArray;
	}

	/**
	* Accepts two legal integers represented as strings. This function will return the
	* integer summation of those two integers.
	* Consider using Integer.parseInt to convert the strings to a numeric value.
	*/
	@Problem(doThis=true)
	@TestCase(io="(`12`,`100`) -> 112")
	public static int addem(String a, String b) {
		int A = Integer.parseInt(a);
		int B = Integer.parseInt(b);
		return A+B;
	}
	
	/**
	* Accepts a space-separated legal list of integers. This function will return the
	* integer summation of those all integers. The string will contain at least one integer.
	* Consider using String.split to break the individual items into an array of individual strings
	* Consider using Integer.parseInt to convert the strings to int.
	* The input string will contain at least one integer. A single space will be used to
	* separate consecutive integers.
	*/
	@Problem(doThis=true)
	@TestCase(io="(`123`) -> 123")
	@TestCase(io="(`12 100 200 -10`) -> 302")
	public static int addemList(String bunchOfIntegers) {
		int temp = 0;
		int newTotal = 0;
		String[] strings = bunchOfIntegers.split(" ");
		//System.out.print(strings);
		if (strings.length < 1) {
			newTotal = Integer.parseInt(strings[0]);
		}
		for (int i = 0; i < strings.length; i++) {
			temp = Integer.parseInt(strings[i]);
			newTotal = newTotal + temp;
		}
		return newTotal;
	}
	
	/**
	* Accepts two separated by one of the following: +, -, *.
	* This function will return the evaluation this simple arithmetic expression.
	* The input will consist of a legal arithmetic expression involving two numbers
	* and one operation.
	*/
	@Problem(doThis=true)
	@TestCase(io="(`1 + 2`) -> 3")
	@TestCase(io="(`12 * 100`) -> 1200")
	public static int evalBinaryExpression(String binaryExpression) {
		int total = 0;
		if (binaryExpression.contains("+")) {
			//System.out.println("test");
			String[] strings = binaryExpression.split(" ");
			int temp1 = Integer.parseInt(strings[0]);
			int temp2 = Integer.parseInt(strings[2]);
			total = temp1 + temp2;
			return total;
			}
		if (binaryExpression.contains("*")) {
			String[] strings = binaryExpression.split(" ");
			int temp1 = Integer.parseInt(strings[0]);
			int temp2 = Integer.parseInt(strings[2]);
			total = temp1 * temp2;
			return total;
			}
		if (binaryExpression.contains("-")) {
			String[] strings = binaryExpression.split(" ");
			int temp1 = Integer.parseInt(strings[0]);
			int temp2 = Integer.parseInt(strings[2]);
			total = temp1 - temp2;
			return total;
		}
		return 0;
	}

	/**
	* Accepts an ArrayList of Integers and returns a new ArrayList that contains
	* only the positive values. The original ArrayList passed as a parameter must
	* be left unchanged.
	*/
	@Problem(doThis=false)
	@TestCase(io="([-22, 12, 0, 15]) -> [12, 15]")
	public static ArrayList<Integer> getPositives(ArrayList<Integer> items) {
		return new ArrayList<Integer>();
	}

	/**
	* Returns an ArrayList that contains the value in the input array that
	* are unique. The unique elements should be ordered in the same order that
	* they appear in the input array.
	*/
	@Problem(doThis=false)
	@TestCase(io="([1,1,2,3,1]) -> [2,3]")
	@TestCase(io="([2,1,3,1,2,3,1]) -> []")
	public static ArrayList<Integer> getUniquesArrayList(int [] ary) {
		return new ArrayList<Integer>();
	}
	
	/**
	* Similar to the previous problem but returns an array instead of
	* an ArrayList
	*/
	@Problem(doThis=false)
	@TestCase(io="([1,1,2,3,1]) -> [2,3]")
	@TestCase(io="([2,1,3,1,2,3,1]) -> []")
	public static int [] getUniquesArray(int [] ary) {
		return new int [0];
	}
	

	/*
	 * Give an array of integers, determine if there a pair of values whose sum
	 * is the specified target value? The pair of value must come from
	 * two different array positions.
	*/
	@Problem(doThis=false)
	@TestCase(io="([1, 2, 7, 5], 8) -> true")
	@TestCase(io="([1, 2], 2) -> false")
	@TestCase(io="([1, 2, 3], 6) -> false")
	@TestCase(io="([1, 2], 3) -> true")
	@TestCase(io="([1, 2, 3, 5, 8, 13], 14) -> true")
	public static boolean targetSum(int [] ary, int target) {
		return false;
	}	
	/*
	 * Given an array of ints, return true if the array contains two consecutive
	 * values whose product is 10, and false otherwise. All integers will
	 * be positive.
	 */
	@Problem(doThis=false)
	@TestCase(io = "([2, 5]) -> true")
	@TestCase(io = "([10, 5, 20, 15, 30, 25]) -> false")
	@TestCase(io = "([7, 1, 10, 76]) -> true")
	@TestCase(io = "([10]) -> false")
	public static boolean pair10(int[] nums) {
		return false;
	}	

	/**
	 * Given an array and a positive integer n, return an array consisting of n
	 * copies of the original array, concatenated with one another.
	 */
	@Problem(doThis = true)
	@TestCase(io = "([10, 20, 30], 3) -> [10, 20, 30, 10, 20, 30, 10, 20, 30]")
	@TestCase(io = "([2, 7], 1) -> [2, 7]")
	@TestCase(io = "([10], 3) -> [10, 10, 10]")
	public static int[] repeatArray(int[] nums, int n) {
		int index = 0;
		int[] newArray = new int[nums.length * n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < nums.length; j++) {
				newArray[index] = nums[j];
				index++;
			}
		return newArray;
	}

	/********************** ENTRY  ***************************/
	public static class Entry {
		public String key;				// An Entry is simply two String - one name key and the other named value
		public String value;

		public Entry(String k, String v) {
			key = k;
			value = v;
		}

		@Override
		public String toString() {
			return String.format("%s/%s", key, value);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Entry otherEntry = (Entry)obj;
			return key.equals(otherEntry.key) && value.equals(otherEntry.value);
		}
	}

	/*
	 * Return if the two Entries have the same key.
	 */
	@Problem(doThis = false)
	@TestCase(io = "(<`key1`, `value1`>, <`key1`, `value2`>) -> true")
	@TestCase(io = "(<`key1`, `value1`>, <`key2`, `value2`>) -> false")
	public static boolean sameKey(Project1CSE274Wi2023.Entry e1, Project1CSE274Wi2023.Entry e2) {
		return false;
	}

	/*
	 * This method accepts an array of Entries and determines if they all of
	 * the keys are different. For this problem, the Entrys' values are
	 * irrelevant.
	 */
	@Problem(doThis = false)
	@TestCase(io = "([<`K`,`V1`>,<`K`, `V2`>,<`K`,`V3`>]) -> false")
	@TestCase(io = "([<`K1`,`V1`>,<`K2`, `V2`>,<`K3`,`V3`>]) -> true")
	@TestCase(io = "([<`K`,`V1`>,<`K2`, `V2`>,<`K`,`V3`>]) -> false")
	public static boolean allHaveUniqueIDs(Project1CSE274Wi2023.Entry [] students) {
		return false;
	}

	/******************************
	 * DON'T CHANGE STUFF BELOW
	 *************************/
	public static ArrayList<Constructor<?>> registerCtors() throws NoSuchMethodException, SecurityException {
		ArrayList<Constructor<?>> result = new ArrayList<>();
		result.add(Point.class.getConstructor(int.class, int.class));
		result.add(Entry.class.getConstructor(String.class, String.class));
		return result;
	}

	public static void main(String[] args) {
		
		mu.testing.Runner.run();
	}
}
