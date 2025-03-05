from collections import Counter

n = int(input())
nums = list(map(int, input().split()))
counter = Counter(nums)
hashed = dict()
for i, k in enumerate(sorted(counter.keys())):
    hashed[k] = str(i)

print(" ".join(map(lambda x: hashed[x], nums)))