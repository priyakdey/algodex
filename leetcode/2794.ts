// https://leetcode.com/problems/create-object-from-two-arrays/description/

type JSONValue = null | boolean | number | string | JSONValue[] | {
    [key: string]: JSONValue
};

function createObject(keysArr: JSONValue[], valuesArr: JSONValue[]): Record<string, JSONValue> {
    const obj: Record<string, JSONValue> = {};

    for (let i = 0; i < keysArr.length; i++) {
        const key = keysArr[i] !== null ? keysArr[i].toString() : "null";
        const value = valuesArr[i];
        if (!obj.hasOwnProperty(key)) {
            obj[key] = value;
        }
    }

    return obj;
}