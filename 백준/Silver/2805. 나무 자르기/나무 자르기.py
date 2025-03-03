from bisect import bisect_left
from collections import Counter

n, m = map(int, input().split())

trees = Counter(map(int, input().split()))

keys = sorted(trees.keys())

def calc(k):
    res = 0
    idx = bisect_left(keys, k)
    for i in range(idx, len(keys)):
        res += (keys[i] - k) * trees[keys[i]]
    return res

def solve():
    low, high = 0, 2_000_000_000
    ans = 0
    while low <= high:
        mid = low + (high - low) // 2
        res = calc(mid)
        if res < m:
            high = mid - 1
        else:
            ans = mid
            low = mid + 1

    return ans


print(solve())
"""
ox
oo

"""