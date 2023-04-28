https://www.acmicpc.net/problem/1874

### 원본문제 설명

```
스택 (stack)은 기본적인 자료구조 중 하나로, 컴퓨터 프로그램을 작성할 때 자주 이용되는 개념이다.
스택은 자료를 넣는 (push) 입구와 자료를 뽑는 (pop) 입구가 같아
제일 나중에 들어간 자료가 제일 먼저 나오는 (LIFO, Last in First out) 특성을 가지고 있다.

1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다.
이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자.
임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다. 이를 계산하는 프로그램을 작성하라.
```


스택에 1부터 시작해서 1씩 더하면서 푸시한다. 따라서 스택 안은 숫자 순서대로 오름차순이 늘 지켜진다!

팝해서 만들어진 수열이 입력된 수열과 같게 만들 수 있는지 확인하는 문제

---

### 문제

```java
    while(turn < n) { //배열요소 순회
        //배열요소가 자연수 이상일 때까지 자연수 push
        while (arr[turn] >= num) {
            System.out.println("푸시");
            st.push(num++);
            bw.write("+\n");
        }
        st.pop(); //top에 있는 자연수 num은 배열요소와 같으므로 pop
        bw.write("-\n");
        turn++; //다음 배열 요소로 넘어가기

        //배열 요소가 자연수 미만일 때까지 pop, 자연수가 클 경우 계속 출력
        while (!st.isEmpty() && arr[turn] < num) {
            System.out.println("팝");
            int val = st.pop();
            bw.write("-\n");
            if (val != arr[turn++]) {
                bw = new BufferedWriter(new OutputStreamWriter(System.out));
                bw.write("NO");
                bw.flush();
                bw.close();
                return;
            }
        }
    }
```        
처음에 푸시와 팝을 진행하면서 동시에 BufferedWriter에 써주었을 때 출력 초과가 발생했다.

찾아보니 BufferedWriter는 버퍼가 어느정도 차면 비정기적으로 flush를 진행하고

따라서 n이 작다면 비정기 flush를 하기 전에 NO만 출력하고 프로그램이 종료하지만

n이 충분히 큰 경우에는 (이 문제에서는 십만정도까지) NO를 출력하기 전에 flush를 진행하게되 이전까지의 버퍼를 출력해버린다.

따라서 출력 초과 발생

해결방법으로 StringBuilder를 사용

문자열을 더할 때 새로운 객체를 생성하지 않고 기존 객체에 더하는 방식이라 속도도 빠름

특히 중간에 비정기 flush도 없기 때문에 마음놓고 문자열을 더한 후 마지막에 결과를 출력할 수 있다.