def is_palindrome(sentence):
    n = len(sentence)
    for i in range(n // 2):
        if sentence[i] != sentence[n-i-1]:
            return False
    return True

word = input()


while word != "0":
    print("yes" if is_palindrome(word) else "no")
    word = input()