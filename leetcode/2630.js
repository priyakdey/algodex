// https://leetcode.com/problems/memoize-ii/

/**
 * @param {Function} fn
 * @return {Function}
 */
function memoize(fn) {

    const cache = new Map();

    return function() {
        const key = JSON.stringify(...arguments);
        if (!cache.has(key)) {
            cache.set(key, fn(...arguments));
        }

        return cache.get(key);
    }
}
