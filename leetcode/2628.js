// https://leetcode.com/problems/json-deep-equal/description/

/**
 * @param {null|boolean|number|string|Array|Object} o1
 * @param {null|boolean|number|string|Array|Object} o2
 * @return {boolean}
 */
var areDeeplyEqual = function (o1, o2) {
    if (o1 === null && o2 === null) {
        return true;
    } else if (o1 === null || o2 === null) {
        return false;
    }

    if (o1 instanceof Array) {
        if (!o2 instanceof Array || o2 instanceof Object) return false;
        if (o1.length !== o2.length) return false;


        for (let i = 0; i < o1.length; i++) {
            if (!areDeeplyEqual(o1[i], o2[i])) {
                return false;
            }
        }
    } else if (o1 instanceof Object) {
        if (o2 instanceof Array || !o2 instanceof Object) return false;

        let entries = Object.entries(o1);
        if (entries.length !== Object.entries(o2).length) return false;

        for (let [ key, value ] of entries) {
            if (!o2.hasOwnProperty(key) || !areDeeplyEqual(value, o2[key])) {
                return false;
            }
        }
    } else if (o1 !== o2) {
        return false;
    }

    return true;
};