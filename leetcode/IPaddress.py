s = input()


def findIP(array):
    if len(array) == 4:
        sum = 0
        for item in array:
            sum += item
        if sum == len(s):
            # 1. 통과
            ip = list()
            p = 0
            for index in array:
                check = s[p:index+p]
                if 0 <= int(check) <= 255:
                    if check[0] == '0' and len(check) > 1:
                        break
                    ip.append(check)
                    p += index
                else:
                    break
            # ip 리스트에 값이 있고, 남아있는 원소가 없으면 유효한 ip리스트에 추가
            if len(s[p:]) == 0:
                answer.append(".".join(ip))
        return

    array.append(1)
    findIP(array)
    array.pop()

    array.append(2)
    findIP(array)
    array.pop()

    array.append(3)
    findIP(array)
    array.pop()


answer = list()
findIP([])
print(answer)
