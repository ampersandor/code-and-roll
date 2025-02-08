from heapq import heappush, heappop

n = int(input())
cut = int(n * 0.15 + 0.5)
m = n - cut * 2

if m:
    scores = []
    for _ in range(n):
        heappush(scores, int(input()))
    total = 0
    for _ in range(cut):
        heappop(scores)
    for _ in range(m):
        total += heappop(scores)
    print(int(total / m + 0.5))
else:
    print(0)