from sys import stdin

input = stdin.readline

openings = {"(": ")", "[": "]"}
closings = {")", "]"}
def is_balanced(sentence):
    stack = []
    for char in sentence:
        if char in openings:
            stack.append(char)
        elif char in closings:
            if stack and openings[stack[-1]] == char:
                stack.pop()
            else:
                return False

    return stack == []

n = int(input())

for _ in range(n):
    text = input().strip()

    print("YES" if is_balanced(text) else "NO")
