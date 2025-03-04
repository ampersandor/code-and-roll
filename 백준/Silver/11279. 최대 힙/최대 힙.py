from sys import stdin

input = stdin.readline

max_heap = []

def insert(num):
    idx = len(max_heap)
    max_heap.append(num)
    while idx > 0 and max_heap[idx] > max_heap[(idx-1)//2]:
        max_heap[idx], max_heap[(idx-1)//2] = max_heap[(idx-1)//2], max_heap[idx]
        idx = (idx-1) // 2

def pop():
    if not max_heap:
        print(0)
        return
    if len(max_heap) == 1:
        print(max_heap.pop())
        return
    print(max_heap[0])
    max_heap[0] = max_heap.pop()
    size = len(max_heap)
    idx = 0
    while idx * 2 + 1 < size:
        child = idx * 2 + 1
        if child + 1 < size and max_heap[child] < max_heap[child + 1]:
            child += 1
        if max_heap[idx] > max_heap[child]:
            break
        max_heap[idx], max_heap[child] = max_heap[child], max_heap[idx]
        idx = child


n = int(input())
for _ in range(n):
    num = int(input())
    if num:
        insert(num)
    else:
        pop()
        