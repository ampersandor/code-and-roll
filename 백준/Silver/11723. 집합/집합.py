from sys import stdin

class MSet(set):
    def __init__(self):
        super().__init__()

    def custom(self, value, num: int=None):
        if value == "add":
            self.add(num)
        elif value == "remove":
            self.discard(num)
        elif value == "check":
            print(1 if num in self else 0)
        elif value == "toggle":
            self.add(num) if num not in self else self.remove(num)
        elif value == "all":
            self.clear()
            self.update({str(i) for i in range(1, 21)})
        elif value == "empty":
            self.clear()


input = stdin.readline

n = int(input())
mset = MSet()

for _ in range(n):
    mset.custom(*input().split())
