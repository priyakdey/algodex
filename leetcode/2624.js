// https://leetcode.com/problems/snail-traversal/

/**
 * @param {number} rowsCount
 * @param {number} colsCount
 * @return {Array<Array<number>>}
 */
Array.prototype.snail = function (rowsCount, colsCount) {
    if (rowsCount * colsCount !== this.length) return [];

    const matrix = Array.from({ length: rowsCount }, () => new Array(colsCount));

    let cursor = 0;
    let row = 0;
    let direction = 1;
    for (let col = 0; col < colsCount; col++) {
        for (let i = 0; i < rowsCount; i++) {
            matrix[row][col] = this[cursor++];
            row += direction;
        }

        if (direction === 1) {
            row = rowsCount - 1;
            direction = -1;
        } else {
            row = 0;
            direction = 1;
        }
    }

    return matrix;
};