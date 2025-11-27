
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Two Sum 问题测试套件")
public class P0001TwoSumTest {

    private P0001TwoSum solution;

    @BeforeEach
    void setUp() {
        solution = new P0001TwoSum();
    }

    @ParameterizedTest(name = "测试 {index}: nums={0}, target={1}, 期望结果={2}")
    @MethodSource("provideBasicTestCases")
    @DisplayName("基础测试场景（参数化）")
    void testTwoSum_ParameterizedBasicCases(int[] nums, int target, int[] expected) {
        int[] result = solution.twoSum(nums, target);
        assertValidTwoSumResult(nums, target, result, expected);
    }

    private static Stream<Arguments> provideBasicTestCases() {
        return Stream.of(
                // 基本场景
                Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
                // 中间元素
                Arguments.of(new int[]{3, 2, 4}, 6, new int[]{1, 2}),
                // 相同元素
                Arguments.of(new int[]{3, 3}, 6, new int[]{0, 1}),
                // 负数
                Arguments.of(new int[]{-1, -2, -3, -4, -5}, -8, new int[]{2, 4}),
                // 包含零
                Arguments.of(new int[]{0, 4, 3, 0}, 0, new int[]{0, 3})
        );
    }

    @Test
    @DisplayName("边界测试：最小数组（2个元素）")
    void testTwoSum_MinimumArray() {
        int[] nums = {1, 2};
        int target = 3;
        int[] result = solution.twoSum(nums, target);

        assertValidTwoSumResult(nums, target, result, new int[]{0, 1});
    }

    @Test
    @DisplayName("边界测试：目标值为负数")
    void testTwoSum_NegativeTarget() {
        int[] nums = {-5, -3, -1, 0, 2};
        int target = -8;
        int[] result = solution.twoSum(nums, target);

        assertValidTwoSumResult(nums, target, result, new int[]{0, 1});
    }

    @Test
    @DisplayName("特殊场景：结果在数组末尾")
    void testTwoSum_ResultAtEnd() {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 9;  // 4 + 5
        int[] result = solution.twoSum(nums, target);

        assertValidTwoSumResult(nums, target, result, new int[]{3, 4});
    }

    @Test
    @DisplayName("特殊场景：正负数混合")
    void testTwoSum_MixedPositiveNegative() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int target = -2;
        int[] result = solution.twoSum(nums, target);

        assertNotNull(result);
        assertEquals(2, result.length);
        assertEquals(target, nums[result[0]] + nums[result[1]]);
    }

    @Test
    @DisplayName("特殊场景：重复元素但不使用")
    void testTwoSum_DuplicateElementsNotUsed() {
        int[] nums = {3, 3, 2, 4};
        int target = 6;  // 应使用索引 1 和 3 的元素
        int[] result = solution.twoSum(nums, target);

        assertNotNull(result);
        assertEquals(2, result.length);
        assertEquals(target, nums[result[0]] + nums[result[1]]);
        // 验证不是同一个索引
        assertNotEquals(result[0], result[1], "不能使用同一个元素两次");
    }


    /**
     * 统一的结果验证方法
     *
     * @param nums     输入数组
     * @param target   目标值
     * @param result   实际结果
     * @param expected 期望结果（可选，用于精确匹配）
     */
    private void assertValidTwoSumResult(int[] nums, int target, int[] result, int[] expected) {
        // 基础验证
        assertNotNull(result, "结果不应为 null");
        assertEquals(2, result.length,
                () -> String.format("应返回 2 个索引，实际返回 %d 个", result.length));

        // 索引顺序验证
        assertTrue(result[0] < result[1],
                () -> String.format("第一个索引 (%d) 应小于第二个索引 (%d)", result[0], result[1]));

        // 索引范围验证
        assertTrue(result[0] >= 0 && result[0] < nums.length,
                "第一个索引超出数组范围");
        assertTrue(result[1] >= 0 && result[1] < nums.length,
                "第二个索引超出数组范围");

        // 业务逻辑验证
        int sum = nums[result[0]] + nums[result[1]];
        assertEquals(target, sum,
                () -> String.format("nums[%d](%d) + nums[%d](%d) = %d，应等于目标值 %d",
                        result[0], nums[result[0]], result[1], nums[result[1]], sum, target));
    }
}
