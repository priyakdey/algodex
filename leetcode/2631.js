// https://leetcode.com/problems/group-by/description/

/**
 * @param {Function} fn
 * @return {Object}
 */
Array.prototype.groupBy = function (fn) {
    const obj = {};

    for (let item of this) {
        const key = fn(item);
        if (!obj.hasOwnProperty(key)) {
            obj[key] = [];
        }

        obj[key].push(item);
    }

    return obj;
};