// https://leetcode.com/problems/array-upper-bound/description/

interface Array<T> {
    upperBound(target: number): number;
}

Array.prototype.upperBound = function(target): number {
    let index = -1;
    let left = 0, right = this.length - 1;

    while (left <= right) {
        const mid = left + (right - left) / 2;
        if (target == this[mid]) {
            index = mid;
            left = mid + 1;
        } else if (target < this[mid]) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }

    return index;
};