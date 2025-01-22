from heapq import heappush, heappop
from sys import stdin

input = stdin.readline

n = int(input())

heap = []
record = set()

for _ in range(n):
    word = input().strip()
    if word not in record:
        heappush(heap, (len(word), word))
        record.add(word)

while heap:
    print(heappop(heap)[1])


