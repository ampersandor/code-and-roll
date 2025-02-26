# https://www.acmicpc.net/problem/17626
from collections import deque

n = int(input())

cache = dict()
def bfs(num):
    que = deque([(num, 0)])

    while que:
        num, count = que.popleft()
        if num == 0:
            return count
        for sr in range(int(num ** 0.5), 0, -1):
            que.append((num - sr ** 2, count + 1))
            if sr ** 2 < num // 2:
                break


print(bfs(n))
