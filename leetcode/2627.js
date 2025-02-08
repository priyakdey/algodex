// https://leetcode.com/problems/debounce/

/**
 * @param {Function} fn
 * @param {number} t milliseconds
 * @return {Function}
 */
var debounce = function (fn, t) {

    let id = null;

    return function (...args) {
        if (id !== null) {
            clearTimeout(id);
        }

        id = setTimeout(() => fn(...args), t);
    };
};