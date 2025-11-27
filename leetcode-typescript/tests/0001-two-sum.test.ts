import { describe, it, expect } from 'vitest';
import { twoSum } from '../src/0001-two-sum';

describe('twoSum (LeetCode Official)', () => {
    it('returns indices for a typical example', () => {
        expect(twoSum([2, 7, 11, 15], 9)).toEqual([0, 1]);
    });

    it('handles duplicate values correctly', () => {
        expect(twoSum([3, 3], 6)).toEqual([0, 1]);
    });

    it('works with negative numbers', () => {
        expect(twoSum([-1, -2, -3, -4, -5], -8)).toEqual([2, 4]);
    });

    it('does not use the same element twice', () => {
        expect(twoSum([3, 2, 4], 6)).toEqual([1, 2]);
    });
});

