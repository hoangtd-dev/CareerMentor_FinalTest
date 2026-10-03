public class Main {
	public static void main(String[] args) {
		System.out.println("result: " + solve(new int[] { 4, 2, 2, 3, 1, 4, 7, 8, 9 }));
		System.out.println("result: " + solve(new int[] { 1, 1, 1, 1, 1 }));
		System.out.println("result: " + solve(new int[] { 8, 8, 8, 8, 8, 8, 8, 9, 10 }));
		System.out.println("result: " + solve(new int[] { 7, 7, 7, 7, 7, 7, 7, 7, 7, 9 }));
	}

	public static int solve(int[] arr) {
		if (arr.length < 3)
			return -1;

		int start = 1;
		int left = 0;
		int right = arr.length - 1;

		while (start <= right) {
			if (left == start && start == right)
				return arr[start];

			// System.out.println(
			// "left[" + left + "]:" + arr[left] + " - start[" + start + "]:" + arr[start] +
			// " - right[" + right + "]:"
			// + arr[right]);
			if (arr[start] < arr[left] || arr[start] >= arr[right]) {
				start++;
				left = 0;
				right = arr.length - 1;
			} else if (start > left) {
				left++;
			} else {
				right--;
			}
		}

		return -1;
	}
}
