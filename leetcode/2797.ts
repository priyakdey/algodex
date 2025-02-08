// https://leetcode.com/problems/partial-function-with-placeholders/description/

type JSONValue = null | boolean | number | string | JSONValue[] | {
    [key: string]: JSONValue
};
type Fn = (...args: JSONValue[]) => JSONValue

function partial(fn: Fn, args: JSONValue[]): Fn {

    return function(...restArgs) {
        let cursor = 0;
        for (let i = 0; i < args.length; i++) {
            if (args[i] === "_") {
                args[i] = restArgs[cursor++];
            }
        }

        return fn.call(this, ...args, ...restArgs.slice(cursor));
    };
}