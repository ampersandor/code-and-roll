from sys import stdin
from heapq import heappush, heappop


read = stdin.readline

n = int(read())
heap = []
for _ in range(n):
    num = int(read())
    if num == 0:
        print(heappop(heap) if heap else 0)
    else:
        heappush(heap, num)
