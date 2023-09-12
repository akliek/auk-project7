package src.part2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BubbleSortSnapshot {
	private static void printArray(int[] nums) {
		for (int num : nums) {
			System.out.print(num + " ");
		}
		System.out.print("\n");
	}

	private static int[] getRandArray(int size) {
		int[] nums = new int[size];
		for (int i = 0; i < size; i++) {
			nums[i] = (int) (Math.random() * 100);
		}
		return nums;
	}

	private static void bubbleSortWithSnapshots(int[] arr) {
		int tmp;

		for (int i = 0; i < arr.length; i++) {

			System.out.printf("\u001B[32mOuter loop, iteration %d\u001B[0m: ", i + 1);
			printArray(arr);

			for (int j = i+1; j < arr.length; j++) {

				System.out.printf("\u001B[33mInner loop, iteration %d\u001B[0m: ", j - i);
				printArray(arr);

				if (arr[i] > arr[j]) {
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}

	public static void main(String[] args) {
		final int SIZE = 5;
		int[] nums = getRandArray(SIZE);

		System.out.print("\u001B[31mInitial array: \u001B[0m");
		printArray(nums);

		bubbleSortWithSnapshots(nums);
	}
}
