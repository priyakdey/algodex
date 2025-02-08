// https://leetcode.com/problems/repeat-string/description/

interface String {
    replicate(times: number): string;
}

String.prototype.replicate = function(times): string {
    const buf = new Array<String>(times);

    for (let i = 0; i < times; i++) {
        buf[i] = this;
    }

    return buf.join("");
}