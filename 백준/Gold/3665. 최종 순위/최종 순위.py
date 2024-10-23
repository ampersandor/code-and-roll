from collections import defaultdict, deque


def solve():
    n = int(input())
    graph = defaultdict(list)
    indegree = [0] * (n+1)
    ranks = list(map(int, input().split()))

    # Initialize Graph and Indegree
    for i in range(n-1):
        for j in range(i+1, n):
            a, b = ranks[i], ranks[j]
            graph[a].append(b)
            indegree[b] += 1

    r = int(input())
    changed = [map(int, input().split()) for __ in range(r)]

    # Changed Graph and Indegree
    for a, b in changed:
        if a in graph[b]:
            graph[b].remove(a)
            graph[a].append(b)
            indegree[a] -= 1
            indegree[b] += 1
        elif b in graph[a]:
            graph[a].remove(b)
            graph[b].append(a)
            indegree[b] -= 1
            indegree[a] += 1
        else:
            return "IMPOSSIBLE"

    que = deque()
    for i in range(1, n+1):
        if indegree[i] == 0:
            que.append(i)

    if len(que) == 0:
        return "IMPOSSIBLE"

    if len(que) != 1:
        return "?"
    res = []
    while que:
        node = que.popleft()
        for child in graph[node]:
            indegree[child] -= 1
            if indegree[child] == 0:
                que.append(child)
        res.append(node)
        if len(que) > 1:
            return "?"

    if len(res) != n:
        return "IMPOSSIBLE"

    return " ".join(map(str, res))


tests = int(input())


for _ in range(tests):
    print(solve())