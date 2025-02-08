// https://leetcode.com/problems/array-upper-bound/description/
Array.prototype.upperBound = function (target) {
    var index = -1;
    var left = 0, right = this.length - 1;
    while (left <= right) {
        var mid = left + (right - left) / 2;
        if (this[mid] === target) {
            index = mid;
            left = mid + 1;
        }
        else if (this[mid] < target) {
            left = mid + 1;
        }
        else {
            right = mid - 1;
        }
    }
    return index;
};
console.log([3, 4, 5].upperBound(5));
