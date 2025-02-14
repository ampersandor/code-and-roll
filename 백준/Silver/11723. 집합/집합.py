from sys import stdin, stdout

class MSet(list):
    def __init__(self):
        super().__init__([False for _ in range(21)])

    def custom(self, value, num: str=None):
        if num:
            num = int(num)
        if value == "add":
            self[num] = True
        elif value == "remove":
            self[num] = False
        elif value == "check":
            write('1\n' if self[num] else '0\n')
        elif value == "toggle":
            self[num] ^= True
        elif value == "all":
            for i in range(1, 21):
                self[i] = True
        elif value == "empty":
            for i in range(1, 21):
                self[i] = False


read = stdin.readline
write = stdout.write

n = int(read())
mset = MSet()

for _ in range(n):
    mset.custom(*read().split())