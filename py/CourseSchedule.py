class Solution:
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        tbl = []
        for i in range(numCourses):
            tbl.append([False] * numCourses)
        for [d, n] in prerequisites:
            tbl[n][d] = True

        cleaned = [False] * numCourses
        while True:
            l = len(tbl)
            changed = False
            for i in range(l):
                c = tbl[i]
                if cleaned[i] or any(c):
                    continue
                cleaned[i] = True
                changed = True
                for j in range(l):
                    if not cleaned[j]:
                        tbl[j][i] = False

            if not changed:
                break

        return all(cleaned)
