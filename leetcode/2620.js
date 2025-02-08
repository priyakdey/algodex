// https://leetcode.com/problems/counter/

/**
 * @param {number} n
 * @return {Function} counter
 */
var createCounter = function(n) {

    let counter = n;

    return function() {
        return counter++;
    };
};