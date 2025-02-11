from heapq import heappush, heappop
from collections import defaultdict

n = int(input())

arr = []
heap = []

counter = defaultdict(int)

for _ in range(n):
    heappush(heap, int(input()))

total = 0
median = -1
min_count_num = -1
max_count = 0
min_num, max_num = heap[0], -1

for i in range(n):
    num = heappop(heap)
    total += num
    counter[num] += 1
    max_count = max(max_count, counter[num])
    if i == (n // 2):
        median = num
    if i == (n - 1):
        max_num = num

max_keys = sorted(filter(lambda x: counter[x] == max_count, counter))

print(int(total / n + 0.5) if total > 0 else int(total / n - 0.5))
print(median)
print(max_keys[0] if len(max_keys) == 1 else max_keys[1])
print(max_num - min_num)