from collections import deque


a, b = map(int, input().split())

que = deque([(a, 1)])

while que:
    num, count = que.popleft()
    if num == b:
        print(count)
        break
    if num > b:
        continue
    que.append((num * 2, count + 1))
    que.append((num * 10 + 1, count + 1))
else:
    print(-1)