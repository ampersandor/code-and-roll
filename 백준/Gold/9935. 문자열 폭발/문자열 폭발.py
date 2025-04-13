template = input().strip()
stack = []
bomb = list(input().strip())
b = len(bomb)

for i in range(len(template)):
    stack.append(template[i])
    if stack[-b:] == bomb:
        # stack = stack[:-b]
        for _ in range(b):
            stack.pop()


print("".join(stack) if stack else "FRULA")