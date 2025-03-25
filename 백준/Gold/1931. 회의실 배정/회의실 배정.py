from heapq import heappush, heappop
n = int(input())
heap = []

for _ in range(n):
    s, e = map(int, input().split())
    heappush(heap, (e, s))

res = 1
pe, ps = heappop(heap)
while heap:
    e, s = heappop(heap)
    if pe <= s:
        pe, ps = e, s
        res += 1

print(res)
