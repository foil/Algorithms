class Solution:
    def allPathsSourceTarget(self, graph):
        """
        :type graph: List[List[int]]
        :rtype: List[List[int]]
        """
        def solve(graph, index):
            N = len(graph)

            if index == N - 1:
                return [[index]]

            res = []
            for i in graph[index]:
                arrs = solve(graph, i)
                for arr in arrs:
                    arr.insert(0, index)
                    res.append(arr)

            return res

        return solve(graph, 0)
