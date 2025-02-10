from collections import deque
tests = int(input())


for _ in range(tests):
    n, m = map(int, input().split())
    arr = input().strip().split()
    que = deque(map(lambda i: (int(arr[i]), i), range(len(arr))))
    ranks = sorted(map(int, arr))
    count = 1
    while True:
        if ranks[-1] == que[0][0]:
            _, index = que.popleft()
            ranks.pop()
            if index == m:
                break
            count += 1
        else:
            que.rotate(-1)

    print(count)
