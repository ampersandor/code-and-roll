from collections import defaultdict
from heapq import heappush, heappop

class DPQ:
    def __init__(self):
        self.min_que = []
        self.max_que = []
        self.history = defaultdict(int)
        self.n = 0

    def push(self, num):
        heappush(self.min_que, num)
        heappush(self.max_que, -num)
        self.history[num] += 1
        self.n += 1

    def pop(self, sign: str):
        if self.n == 0:
            return
        if sign == "1":
            self._clear(self.max_que, -1)
            self._pop(self.max_que, -1)
        else:
            self._clear(self.min_que, 1)
            self._pop(self.min_que, 1)
        self.n -= 1

    def _pop(self, heap, sign):
        if heap:
            num = sign * heappop(heap)
            if num in self.history:
                self.history[num] -= 1
                if self.history[num] < 1:
                    del self.history[num]

    def _clear(self, heap, sign):
        while heap and self.history[sign * heap[0]] <= 0:
            heappop(heap)

    def print(self):
        if self.n == 0:
            print("EMPTY")
            return
        self._clear(self.min_que, 1)
        self._clear(self.max_que, -1)

        print(f"{-self.max_que[0]} {self.min_que[0]}")



T = int(input())

for _ in range(T):
    k = int(input())
    dpq = DPQ()
    for _ in range(k):
        op, num = input().strip().split()
        if op == "I":
            dpq.push(int(num))
        else:
            dpq.pop(num)
    
    dpq.print()

