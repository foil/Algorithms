class Solution:
    def robotSim(self, commands, obstacles):
        """
        :type commands: List[int]
        :type obstacles: List[List[int]]
        :rtype: int
        """
        x = 0
        y = 0
        v = [0, 1]
        ans = 0
        obstacles = set(map(tuple, obstacles))
        for c in commands:
            if c == -2:
                v[0], v[1] = -v[1], v[0]
            elif c == -1:
                v[0], v[1] = v[1], -v[0]
            else:
                for i in range(c):
                    nx = x + v[0]
                    ny = y + v[1]
                    if (nx, ny) not in obstacles:
                        x = nx
                        y = ny
                        ans = max(ans, x * x + y * y)

        return ans