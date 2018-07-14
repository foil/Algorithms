from EvaluationDivision import Solution


def main():
    s = Solution()
    equations = [ ["a", "b"], ["b", "c"] ]
    values = [2.0, 3.0]
    queries = [ ["a", "c"], ["b", "c"], ["a", "e"], ["a", "a"], ["x", "x"] ]

    print(s.calcEquation(equations, values, queries))


if __name__ == '__main__':
    main()
