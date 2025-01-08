alphas = {chr(i + 97) : -1 for i in range(26)}
word = input()

for i, w in enumerate(word):
    if alphas[w] == -1:
        alphas[w] = i

print(" ".join(map(str, alphas.values())))