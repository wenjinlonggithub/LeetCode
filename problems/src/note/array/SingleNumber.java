package note.array;

import java.util.*;

/**
 * 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class SingleNumber {
    public static Integer singleNumber(Integer[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num = num ^ nums[i];
        }
        return num;
    }

    /**
     * 方法 1：列表操作
     * */
    public static Integer singleNumberByList(Integer[] nums) {
        List<Integer> tempList = new ArrayList<>();
        for (Integer integer : nums) {
            if (!tempList.contains(integer)){
                tempList.add(integer);
            }else{
                tempList.remove(integer);
            }
        }
        return tempList.get(0);
    }

    /**
     * 方法 2：哈希表
     * */
    public static Map singleNumberByHash(Integer[] nums) {
        Map map = new HashMap();
        for (Integer num : nums) {
            if (null==map.get(num)){
                map.put(num,num);
            }else{
                if (num.equals(map.get(num))){
                    map.remove(num);
                }
            }
        }
        return map;
    }


    /**
     * 方法 3：数学
     * */
    public static int singleNumberByMath(Integer[] nums) {
        int totalSumBySet = 0;
        int totalSumByList = 0;
        Set set = new HashSet(Arrays.asList(nums));
        for (Object num : set) {
            totalSumBySet += 2 * (Integer) num;
        }
        for (Integer num : nums) {
            totalSumByList += num;
        }
        return totalSumBySet - totalSumByList;
    }

    public static void main(String[] args) {
        Integer[] data = new Integer[]{17, 12, 5, -6, 12, 4, 17, -5, 2, -3, 2, 4, 5, 16, -3, -4, 15, 15, -4, -5, -6};
        System.out.println(singleNumber(data));
        System.out.println(singleNumberByList(data));
        System.out.println(singleNumberByHash(data));
        System.out.println(singleNumberByMath(data));
    }
}
