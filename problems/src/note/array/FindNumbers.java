package note.array;

public class FindNumbers {


    /**
     * 方法一：枚举 + 字符串
     * 我们枚举数组 nums 中的整数，并依次判断每个整数 x 是否包含偶数个数字。
     * 一种简单的方法是使用语言内置的整数转字符串函数，将 x 转换为字符串后，判断其长度是否为偶数即可。
     */
    public static int findNumbers1(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            String string = String.valueOf(nums[i]);
            if (string.length() % 2 == 0) {
                num++;
            }
        }
        return num;

    }
    /**
     * 方法二：枚举 + 数学
     * 我们也可以使用语言内置的以 10 为底的对数函数 log10() 来得到整数 x 包含的数字个数。
     * <p>
     * 一个包含 k 个数字的整数 x 满足不等式 10^{k-1} \leq x < 10^k10
     * k−1
     * ≤x<10
     * k
     * 。将不等式取对数，得到 k - 1 \leq \log_{10}(x) < kk−1≤log
     * 10
     * ​
     * (x)<k，因此我们可以用 k = \lfloor\log_{10}(x) + 1\rfloork=⌊log
     * 10
     * ​
     * (x)+1⌋ 得到 x 包含的数字个数 k，其中 \lfloor a \rfloor⌊a⌋ 表示将 aa 进行下取整，例如 \lfloor 5.2 \rfloor = 5⌊5.2⌋=5。
     * *
     */
    public static int findNumbers2(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((Math.log10(nums[i]) + 1) % 2 == 0) {
                num++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int[] nums = {12, 345, 2, 6, 7896};
        System.out.println(findNumbers1(nums));
        System.out.println(findNumbers2(nums));
    }
}
