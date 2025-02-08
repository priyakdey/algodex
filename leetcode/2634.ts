// https://leetcode.com/problems/filter-elements-from-array

type Fn = (n: number, i: number) => any

function filter(arr: number[], fn: Fn): number[] {
    let filterArr = [];
    for (let i = 0; i < arr.length; i++) {
        let num = arr[i];
        if (fn.call(this, num, i)) {
            filterArr.push(num);
        }
    }

    return filterArr;
}