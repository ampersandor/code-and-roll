n, m = map(int, input().split())

nums = sorted(map(int, input().split()))
res = set()

def backtracking(cur):
    if len(cur) == m:
        combi = " ".join(map(str, cur))
        if combi not in res:
            res.add(tuple(cur))
        return

    for i in range(n):
        if cur and cur[-1] > nums[i]:
            continue
        cur.append(nums[i])
        backtracking(cur)
        cur.pop()

backtracking([])

for row in sorted(res):
    print(*row)
