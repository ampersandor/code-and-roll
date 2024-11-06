
from collections import defaultdict, deque
import sys
sys.setrecursionlimit(600000)
input = sys.stdin.readline

N, M = map(int, input().split())
raw_edge = defaultdict(list)
for _ in range(M) :
  a, b = map(int, input().split())
  raw_edge[a].append(b)
raw_cash = [0] + [int(input()) for _ in range(N)]

raw_visited = [-1]*(N+1)
scc_finished = [-1]*(N+1)
scc_idx = 0
idx = 0
stk = []

def scc(node) :
  global idx, scc_idx
  raw_visited[node] = ret = idx
  idx += 1
  stk.append(node)
  for nxt in raw_edge[node] :
    if scc_finished[nxt] > -1 :
      continue
    if raw_visited[nxt] == -1 :
      scc(nxt)
    raw_visited[node] = min(raw_visited[node], raw_visited[nxt])
  if ret == raw_visited[node] :
    while stk :
      n = stk.pop()
      scc_finished[n] = scc_idx
      if n == node :
        break
    scc_idx += 1

for i in range(1, N+1) :
  if scc_finished[i] == -1 :
    scc(i)

S, P = map(int, input().split())
cash = [0]*scc_idx
edge_list = [set() for _ in range(scc_idx)]
max_cash = [0]*scc_idx
finish = [False]*scc_idx
for r in list(map(int, input().split())) :
  finish[scc_finished[r]] = True
result = 0

for i in range(1, N+1) :
  _i = scc_finished[i]
  cash[_i] += raw_cash[i]
  for j in raw_edge[i] :
    if _i != scc_finished[j] :
      edge_list[_i].add(scc_finished[j])
  if i == S :
    s = _i

def bfs(node) :
  max_cash[node] += cash[node]
  q = deque([node])
  while q :
    n = q.popleft()
    for nxt in edge_list[n] :
      if max_cash[nxt] < max_cash[n] + cash[nxt] :
        max_cash[nxt] = max_cash[n] + cash[nxt]
        q.append(nxt)

bfs(s)
for i in range(scc_idx) :
  if finish[i] :
    result = max(result, max_cash[i])
print(result)
