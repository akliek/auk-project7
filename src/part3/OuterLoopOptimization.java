package src.part3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OuterLoopOptimization {
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

	private static int getUserInt(Scanner scanner) {
		while (true) {
			try {
				return scanner.nextInt();
			} catch (InputMismatchException e) {
				scanner.nextLine();
				System.out.println("\u001B[31mIt is not a number. Try again: \u001B[0m");
			}
		}
	}

	private static int[] createArray(int size, Scanner scanner) {
		int n;
		int[] arr = new int[size];

		System.out.println("Enter array elements: ");
		for (int i = 0; i < size; i++) {
			n = getUserInt(scanner);
			arr[i] = n;
		}
		return arr;
	}

	private static int[] bubbleSort(int[] arr) {
		int tmp;
		boolean swapped;

		for (int i = 1; i < arr.length; i++) {
			swapped = false;
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
					swapped = true;
				}
			}
			if (!swapped) {
				break;
			}
		}
		return arr;
	}

	private static boolean repeat(Scanner scanner) {
		System.out.print("Press 'y' or 'Y' to continue: ");
		String input = scanner.nextLine();
		return input.equals("y") || input.equals("Y");
	}

	public static void main(String[] args) {
		int size;
		int[] arr;
		Scanner scanner = new Scanner(System.in);

		do {
			System.out.print("Enter array size: ");
			size = getUserInt(scanner);
			if (size <= 0) {
				scanner.nextLine();
				System.out.println("Array size must be greater than zero.");
				continue;
			}

			System.out.print("Press '1' to enter array elements manually or anything else to generate random array: ");
			if (getUserInt(scanner) == 1) {
				arr = createArray(size, scanner);
			} else {
				arr = getRandArray(size);
			}

			System.out.print("Original array: ");
			printArray(arr);
			System.out.print("Sorted array: ");
			printArray(bubbleSort(arr));

			scanner.nextLine();
		} while (repeat(scanner));

		scanner.close();
	}
}
