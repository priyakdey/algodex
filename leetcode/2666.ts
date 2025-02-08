// https://leetcode.com/problems/allow-one-function-call/description/

type JSONValue = null | boolean | number | string | JSONValue[] | { [key: string]: JSONValue };
type OnceFn = (...args: JSONValue[]) => JSONValue | undefined

function once(fn: Function): OnceFn {
    let counter = 1;
    return function (...args) {
        if (counter === 0) return undefined;
        counter--;
        return fn.call(this, ...args);
    };
}