// https://leetcode.com/problems/array-reduce-transformation/

type Fn = (accum: number, curr: number) => number

function reduce(nums: number[], fn: Fn, init: number): number {
    for (let num of nums) {
        init = fn(init, num);
    }

    return init;
}