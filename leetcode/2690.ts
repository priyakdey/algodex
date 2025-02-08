// https://leetcode.com/problems/infinite-method-object/description/

function createInfiniteObject(): Record<string, () => string> {
    const handler = {
        get: function (target, prop, receiver) {
            return () => prop;
        }
    }

    return new Proxy(this, handler);
}