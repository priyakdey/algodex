// https://leetcode.com/problems/memoize/

/**
 * @param {Function} fn
 * @return {Function}
 */
function memoize(fn) {

    const cache = new Map();

    return function (...args) {
        let key = args.join("-");
        if (!cache.has(key)) {
            cache.set(key, fn(...args));
        }

        return cache.get(key);
    };
}