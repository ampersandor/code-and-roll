n, m = map(int, input().split())

nums = list(map(int, input().split()))

res = set()

def backtracking(tmp):
    if len(tmp) == m:
        res.add(tuple(tmp))
        return

    for i in range(len(nums)):
        tmp.append(nums[i])
        num = nums.pop(i)
        backtracking(tmp)
        nums.insert(i, num)
        tmp.pop()

backtracking([])

for r in sorted(res):
    print(*r)



