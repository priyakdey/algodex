// https://leetcode.com/problems/flatten-deeply-nested-array/description/

/**
 * @param {Array} arr
 * @param {number} depth
 * @return {Array}
 */
var flat = function (arr, depth) {
    if (depth === 0) return arr;

    const acc = [];

    for (let val of arr) {
        if (val instanceof Array) {
            acc.push(...flat(val, depth - 1));
        } else {
            acc.push(val);
        }
    }

    return acc;
};