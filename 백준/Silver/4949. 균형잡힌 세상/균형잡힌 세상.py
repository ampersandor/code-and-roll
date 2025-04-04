
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

text = input()

while text != ".":
    print("yes" if is_balanced(text) else "no")

    text = input()

