from functools import lru_cache

@lru_cache()
def fib(a):
    if a == 1:
        return 0, 1
    elif a == 0:
        return 1, 0

    z1, o1 = fib(a - 1)
    z2, o2 = fib(a - 2)

    return z1 + z2, o1 + o2

n = int(input())

for _ in range(n):
    query = int(input())

    print(*fib(query))