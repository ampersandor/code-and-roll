from collections import deque

INF = float('inf')


def bfs(edges):
    que = deque([(1, 0)])
    visited = [INF] * 101
    visited[1] = 0
    while que:
        a, count = que.popleft()
        if a == 100:
            return count
        if a in edges:
            if count < visited[edges[a]]:
                visited[edges[a]] = count
                que.appendleft((edges[a], count))
            continue
        for i in range(1, 7):
            b = a + i
            if b < 101 and count + 1 < visited[b]:
                visited[b] = count + 1
                que.append((b, count + 1))
    return -1

def main():
    n, m = map(int, input().split())
    edges = {a: b for _ in range(n+m) for a, b in [map(int, input().split())]}
    print(bfs(edges))

main()
