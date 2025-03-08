from collections import defaultdict

n = int(input())
fruits = list(map(int, input().split()))
counter = defaultdict(int)
l = 0
res = 0

for f in range(n):
    counter[fruits[f]] += 1
    while len(counter) > 2:
        if counter[fruits[l]] == 1:
            del counter[fruits[l]]
        else:
            counter[fruits[l]] -= 1
        l += 1
    res = max(res, f - l + 1)

print(res)