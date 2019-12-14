package other.array;

/**
 * Created by gouthamvidyapradhan on 01/08/2017. Rotate an array of n elements to the right by k
 * steps.
 *
 * <p>For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 *
 * <p>Note: Try to come up as many solutions as you can, there are at least 3 different ways to
 * solve this problem.
 *
 * <p>Hint: Could you do it in-place with O(1) extra space? Related problem: Reverse Words in a
 * String II
 */
public class RotateArray {
    /**
     * Main method
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        int[] A = {1, 2, 3, 4, 5, 6};
//        new RotateArray().rotate(A, 2);
//        new RotateArray().rotate_1(A, 2);
//        new RotateArray().rotate_3(A, 2);
        for (int i : A) System.out.print(i + " ");
    }


    /**
     * 双重循环
     * 时间复杂度：O(kn)
     * 空间复杂度：O(1)
     */
    public void rotate_1(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            int temp = nums[n - 1];
            for (int j = n - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }

    /**
     * 循环交换
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public void rotate_3(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        // 第一次交换完毕后，前 k 位数字位置正确，后 n-k 位数字中最后 k 位数字顺序错误，继续交换
        for (int start = 0; start < nums.length && k != 0; n -= k, start += k, k %= n) {
            for (int i = 0; i < k; i++) {
                swap(nums, start + i, nums.length - k + i);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int s, int e) {
        for (int i = s, j = e; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

}

/**
 * 方法 2：使用额外的数组
 * 算法
 *
 * 我们可以用一个额外的数组来将每个元素放到正确的位置上，也就是原本数组里下标为 ii 的我们把它放到 (i+k)\%数组长度(i+k)%数组长度 的位置。然后把新的数组拷贝到原数组中。
 *
 * 作者：LeetCode
 * 链接：https://leetcode-cn.com/problems/rotate-array/solution/xuan-zhuan-shu-zu-by-leetcode/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * */
class Solution {
    public static void rotate(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6};
        rotate(A,2);
        for (int i : A) System.out.print(i + " ");
    }
}

 class Solution1 {
    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

     public static void main(String[] args) {
         int[] A = {1, 2, 3, 4, 5, 6};
         rotate(A,2);
         for (int i : A)  System.out.print(i + " ");
     }
}
