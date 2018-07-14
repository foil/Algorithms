class Solution:
    def calcEquation(self, equations, values, queries):
        """
        :type equations: List[List[str]]
        :type values: List[float]
        :type queries: List[List[str]]
        :rtype: List[float]
        """
        def dfs(q, visited):
            for e in equations:
                if e in visited:
                    continue
                if e[0] == q[0] and e[1] == q[1]:
                    return e[2]
                elif e[1] == q[0] and e[0] == q[1]:
                    return 1 / e[2]
                elif e[0] == q[0]:
                    if q[0] == q[1]:
                        return 1.0
                    visited.append(e)
                    r = dfs([e[1], q[1]], visited)
                    if r != -1.0:
                        return e[2] * r
                elif e[1] == q[0]:
                    if q[0] == q[1]:
                        return 1.0
                    visited.append(e)
                    r = dfs([e[0], q[1]], visited)
                    if r != -1.0:
                        return r / e[2]

            return -1.0

        for i, e in enumerate(equations):
            e.append(values[i])

        return [dfs(q, []) for q in queries]
