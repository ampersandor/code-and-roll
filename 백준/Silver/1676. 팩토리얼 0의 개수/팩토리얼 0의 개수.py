from math import factorial

n = int(input())


def solution(n):
    res = str(factorial(n))
    m = len(res) - 1
    for i in range(m, -1, -1):
        if res[i] != '0':
            return m - i
    return m


print(solution(n))