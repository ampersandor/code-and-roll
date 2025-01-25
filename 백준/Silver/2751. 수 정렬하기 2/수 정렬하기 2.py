from heapq import heappush, heappop

n = int(input())
heap = []

for _ in range(n):
    heappush(heap, int(input()))

while heap:
    print(heappop(heap))
