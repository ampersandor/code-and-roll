from sys import stdin
from heapq import heappush, heappop

input = stdin.readline

n = int(input())
heap = []
for _ in range(n):
    x, y = map(int, input().split())
    heappush(heap, (y, x))


while heap:
    y, x = heappop(heap)
    print(x, y)