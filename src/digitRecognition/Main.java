package digitRecognition;

import java.util.Scanner;

public class Main {
	public final static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("input grid: ");
		String[][] input = new String[3][3];
		fill(input);
		Number nbr = new Number(input);
		System.out.println("This number is: " + nbr.discoverNbr());
	}
	
	static void fill(String[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			String s = sc.next();
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = s.charAt(j) + "";
			}
		}
	}
}

class Number{
	private String[][] arr;
	
	private int[] weight;
	private int b;
	{
		weight = new int[]{2, 1, 2, 4, -4, 4, 2, -1, 2};
		b = -5;
	}
	
	Number(String[][] arr) {
		this.arr = arr;
	}
	
	String[][] getArr() {
		return arr;
	}
	void setArr(String[][] arr) {
		this.arr = arr;
	}

	int discoverNbr() {
		int res = b;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				int a = arr[i][j].equals("X")? 1 : 0;
				res += a * weight[i];
			}
		}
		int r = res >= 4 || arr[1][1].equals("_") ? 0 : 1;
		return r;
	}
}