def grammer_correction(thought_input):
    asks = ("How", "What", "Who", "Whose", "Whom")
    capitalized = thought_input.capitalize().rstrip("?")
    capitalized = capitalized.rstrip(".")
    if capitalized.startswith(asks):
        return '{}? '.format(capitalized)
    else:
        return '{}. '.format(capitalized)


thought = ''
thoughts = []

while thought != 'done':
    thought = input('what\'s on your mind ? ')
    if thought == 'done':
        break
    thoughts.append(grammer_correction(thought))
print(" ".join(thoughts))
