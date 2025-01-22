from heapq import heappush, heappop

n = int(input())

heap = []
record = set()

for _ in range(n):
    word = input()
    if word not in record:
        heappush(heap, (len(word), word))
        record.add(word)

while heap:
    print(heappop(heap)[1])


