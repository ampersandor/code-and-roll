n = int(input())
m = int(input())
S = input()

def make_p_table(seq):
    p_table = [0] * len(seq)
    j = 0
    for i in range(1, len(seq)):
        while j > 0 and seq[i] != seq[j]:
            j = p_table[j-1]
        if seq[i] == seq[j]:
            j += 1
        p_table[i] = j
    return p_table

def search(query, subject):
    p_table = make_p_table(query)
    count = 0
    j = 0
    for i in range(len(subject)):
        while j > 0 and subject[i] != query[j]:
            j = p_table[j - 1]
        if subject[i] == query[j]:
            if j == len(query) - 1:
                count += 1
                j = p_table[j]
            else:
                j += 1

    return count

print(search("IOI" + "OI" * (n - 1), S))