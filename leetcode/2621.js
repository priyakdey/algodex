// https://leetcode.com/problems/sleep/description/

/**
 * @param {number} millis
 * @return {Promise}
 */
async function sleep(millis) {
    return new Promise((resolve, _) => {
        setTimeout(resolve, millis);
    });
}