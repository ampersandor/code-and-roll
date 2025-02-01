from collections import deque

n = int(input())

deck = deque(range(1, n+1))
pop = True
while len(deck) != 1:
    if pop:
        deck.popleft()
    else:
        deck.append(deck.popleft())
    pop ^= True

print(deck[0])