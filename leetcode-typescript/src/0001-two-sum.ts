/**
 * 两数之和 - 哈希表解法
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 */
export function twoSum(nums: number[], target: number): number[] {
    // 哈希表存储结构: key=数组元素值, value=该元素的索引
    let helperMap: Map<number, number> = new Map();

    // 用于存储在哈希表中找到的匹配元素的索引
    let index: number | undefined;

    // 结果数组，存储两个符合条件的索引
    let resArr: number[] = [];

    // 遍历数组，同时进行查找和存储
    for (let i = 0, length = nums.length; i < length; i++) {
        // 核心逻辑: 计算当前元素的"配对数" (target - nums[i])
        index = helperMap.get(target - nums[i]);

        // 如果找到了配对数（index !== undefined）
        if (index !== undefined) {
            // 返回当前索引和之前找到的索引
            resArr = [index, i];
            break; // 找到结果后立即退出循环
        }

        helperMap.set(nums[i], i);
    }

    return resArr;
}

export default twoSum;