from sys import stdin

input = stdin.readline

n = int(input())

arr = [int(input()) for _ in range(n)]
cur = 0
stack = []
history = []
for i in range(1, n + 1):
    stack.append(i)
    history.append("+")

    while stack and stack[-1] == arr[cur]:
        stack.pop()
        cur += 1
        history.append("-")

print("\n".join(history) if not stack else "NO")