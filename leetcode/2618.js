// https://leetcode.com/problems/check-if-object-instance-of-class/

/**
 * @param {*} obj
 * @param {*} classFunction
 * @return {boolean}
 */
var checkIfInstanceOf = function (obj, classFunction) {
    const proto = Object.getPrototypeOf(obj);
    if (proto === classFunction) return true;

    return checkIfInstanceOf(proto, classFunction);
};