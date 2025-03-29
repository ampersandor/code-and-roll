from collections import deque


def L(num):
    return (num % 1000) * 10 + num // 1000


def R(num):
    return (num // 10) + (num % 10) * 1000

def D(num):
    return (2 * num) % 10000

def S(num):
    return (num - 1) % 10000

def solve(a, b):
    que = deque([(a, "")])
    visited = [False] * 10001
    ops = {"L": L, "R": R, "D": D, "S": S}
    while que:
        num, history = que.popleft()
        if num == b:
            return history
        for op in ops:
            n_num = ops[op](num)
            if n_num < 0:
                continue
            if not visited[n_num]:
                visited[n_num] = True
                que.append((n_num, history + op))

n = int(input())

for _ in range(n):
    a, b = map(int, input().split())
    print(solve(a, b))