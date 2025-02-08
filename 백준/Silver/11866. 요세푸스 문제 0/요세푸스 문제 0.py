from collections import deque

n, k = map(int, input().split())

que = deque([i for i in range(1, n+1)])
i = 1
print("<", end="")
while que:
    if i % k:
        que.rotate(-1)
    else:
        print(que.popleft(), end=", " if que else "")
    i += 1

print(">")