// https://leetcode.com/problems/cache-with-time-limit/description/

var TimeLimitedCache = function () {
    this.cache = new Map();
    this.timeout = new Map();
};

/**
 * @param {number} key
 * @param {number} value
 * @param {number} duration time until expiration in ms
 * @return {boolean} if un-expired key already existed
 */
TimeLimitedCache.prototype.set = function (key, value, duration) {
    const isActive = this.cache.has(key);

    this.cache.set(key, value);

    if (isActive) {
        clearTimeout(this.timeout.get(key));
    }
    const id = setTimeout(() => this.cache.delete(key), duration);
    this.timeout.set(key, id);

    return isActive;
};

/**
 * @param {number} key
 * @return {number} value associated with key
 */
TimeLimitedCache.prototype.get = function (key) {
    return this.cache.has(key) ? this.cache.get(key) : -1;
};

/**
 * @return {number} count of non-expired keys
 */
TimeLimitedCache.prototype.count = function () {
    return this.cache.size;
};
