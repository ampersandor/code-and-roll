n, t = map(int, input().split())

arr = list(map(int, input().split()))
res = []
for num in arr:
    if num < t:
        res.append(num)

print(*res)