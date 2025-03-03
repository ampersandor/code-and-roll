from bisect import bisect_left

n, m = map(int, input().split())

trees = sorted(map(int, input().split()))


def calc(k):
    res = 0
    idx = bisect_left(trees, k)
    for i in range(idx, len(trees)):
        res += trees[i] - k
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