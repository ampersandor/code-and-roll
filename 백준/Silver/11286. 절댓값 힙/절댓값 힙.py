from sys import stdin, stdout

read = stdin.readline
write = stdout.write

n = int(read())

heap = []

def compare(x, y):
    return True if abs(x) < abs(y) or (abs(x) == abs(y) and x < y) else False

def insert(num):
    heap.append(num)
    i = len(heap) - 1
    while i > 0 and compare(heap[i], heap[(i-1)//2]):
        parent = (i-1) // 2
        heap[i], heap[parent] = heap[parent], heap[i]
        i = parent

def pop():
    if not heap:
        return 0
    if len(heap) == 1:
        return heap.pop()
    res = heap[0]
    heap[0] = heap.pop()
    i = 0
    while i < len(heap) and 2 * i + 1 < len(heap):
        child = 2 * i + 1
        if child < len(heap) - 1 and compare(heap[child + 1], heap[child]):
            child += 1
        if compare(heap[child], heap[i]):
            heap[i], heap[child] = heap[child], heap[i]
            i = child
        else:
            break
    return res

for _ in range(n):
    k = int(read())
    if k:
        insert(k)
    else:
        write(str(pop()) + "\n")