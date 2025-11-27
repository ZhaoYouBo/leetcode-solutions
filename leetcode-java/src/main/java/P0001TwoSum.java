
import java.util.Map;
import java.util.HashMap;

public class P0001TwoSum {

    /**
     * 两数之和 - 哈希表解法
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int[] twoSum(int[] nums, int target) {
        // 哈希表：key 为数组元素值，value 为该元素的索引
        Map<Integer, Integer> map = new HashMap<>();

        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 计算当前元素的补数（complement）
            int complement = target - nums[i];

            // 检查补数是否已在哈希表中
            if (map.containsKey(complement)) {
                // 找到答案：返回补数的索引和当前索引
                return new int[]{map.get(complement), i};
            }

            // 将当前元素及其索引存入哈希表，供后续元素查找
            map.put(nums[i], i);
        }

        return new int[0];
    }
}
