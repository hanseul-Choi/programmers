# 조이스틱

## 문제 설명
조이스틱으로 알파벳 이름을 완성하세요. 맨 처음엔 A로만 이루어져 있습니다. <br>
ex) 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA <br><br>

조이스틱을 각 방향으로 움직이면 아래와 같습니다.<br><br>

▲ - 다음 알파벳 <br>
▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로) <br>
◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)<br>
▶ - 커서를 오른쪽으로 이동<br>
예를 들어 아래의 방법으로 "JAZ"를 만들 수 있습니다.<br><br>

- 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성합니다.<br>
- 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동시킵니다.<br>
- 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성합니다.<br>
따라서 11번 이동시켜 "JAZ"를 만들 수 있고, 이때가 최소 이동입니다.<br>
만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값을 return 하도록 solution 함수를 만드세요. <br>

### 제한 사항
name은 알파벳 대문자로만 이루어져 있습니다. <br>
name의 길이는 1 이상 20 이하입니다. <br>

### 입출력 예
| name     | return |
|----------|--------|
| "JEROEN" | 56     |
| "JAN"    | 23     |

<br>

## 나의 풀이
이번껀 예외사항을 잘 생각해야하는 문제였다. 접근 방식은 조이스틱을 위아래로 움직이는 횟수와 양옆으로 움직이는 횟수를 더하는 방식으로 접근했다. 위아래로 움직이는 경우 N이 위에서 움직이거나 아래에서 움직여도 총 13번 움직여서 N보다 작으면 위로 움직이고, N보다 크면 아래로 움직이는 방식을 적용하였다. 문제는 양옆으로 움직이는 방식이었는데, 맨 처음 접근은 왼쪽으로 쭉 움직이거나 오른쪽으로 쭉 움직이는 경우를 계산해 가장 작은 수를 반환하는 방식으로 하였다. 그렇지만 오른쪽으로 갔다가 왼쪽으로 꺾이는 경우에서 예외사항이 발생했다. ex) "ZZAAAZZ" -> 양옆 움직임은 4번. <br>
결국, 맨처음 보이는 A의 연속되는 문자열을 빼 주어 그 길이를 계산하는 방식을 채택하였다. ex) "ZZAAAZZ" 는 "ZZZZ"로 변환한 후 길이를 재었다. 또한, 왼쪽으로 쭉 움직인 경우, 오른쪽으로 쭉 움직인 경우, 왼쪽으로 갔다가 오른쪽으로 간 경우의 최소값을 반환하여 계산하였다.