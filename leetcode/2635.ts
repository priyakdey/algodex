// https://leetcode.com/problems/apply-transform-over-each-element-in-array/description/

function map(arr: number[], fn: (n: number, i: number) => number): number[] {
    let mappedArr: number[] = [];

    for (let i = 0; i < arr.length; i++) {
        mappedArr.push(fn.call(this, arr[i], i));
    }

    return mappedArr;
}