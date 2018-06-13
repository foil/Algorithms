class Solution:
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        if numRows <= 1:
            return s

        numCols = len(s) // (numRows - 1) + 1
        matrix = [[0 for x in range(numCols)] for y in range(numRows)]

        i = 0
        x = 0
        y = 0
        r = False
        for c in s:
            i += 1
            matrix[y][x] = c

            if i % numRows == 0:
                x += 1
                i += 1
                r = not r

            if r:
                y -= 1
            else:
                y += 1

            if r and (i + 1) % numRows == 0:
                x += 1
                i += 1
                r = not r

        result = ""
        for y in range(numRows):
            for x in range(numCols):
                if matrix[y][x] != 0:
                    result += matrix[y][x]

        return result