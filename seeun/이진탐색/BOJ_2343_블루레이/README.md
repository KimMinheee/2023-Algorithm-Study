블루레이의 크기가 될 수 있는 수들을 가지고 이분탐색

블루레이의 크기는 최소 각 레슨시간 중 최댓값, 최대 모든 레슨시간을 합한 값

<br>

레슨 구성이 1 2 3 4 5 6 7 8 9인 경우

9분-27분-45분, 블루레이 크기가 9분일 때 **블루레이 개수 9개**, 27분일 때 **2개** 45분 일 때 **1개**

여기서 개수는 각 레슨을 뒤에서부터 더하면서 합한 값이 크기를 넘어간다면 개수 카운트하고 다시 크기 0부터 더해가는 것을 맨 앞까지 수행 → 블루레이 개수 카운팅

우리는 블루레이 개수가 3개인 것을 원하므로

mid인 27분을 기준으로 오른쪽으로 가야한다.

1. 9분-18분-27분

18분일 때 9,8 / 7,6,5 / 4,3,2,1로 3개로 구성가능

여기서 끝내는 것이 아니고 더 짧은 시간으로 3개를 구성할 수 있는지 확인하기 위해 한번 더 이분탐색 수행, 왼쪽그룹

2. 9분-13분-17분

13분 3개보다 더 필요함, 이분탐색으로 오른쪽그룹

3. 14분-15분-17분

15분 3개보다 더 필요함, 이분탐색으로 오른쪽 그룹

4. 16분-16분-17분

16분 3개보다 더 필요함, 이분탐색으로 오른쪽 그룹

5. 17분-17분-17분(min==mid==max)

17분 3개 필요함, 더짧은 시간으로 3개를 구성할 수 있는지 확인하기 위해 이분탐색, 왼쪽그룹(max = mid-1 수행)

이렇게 되면 max가 min보다 작게되는 상황으로 이분탐색끝나게됨

여기서 마지막 유효한 크기인 min이나 mid가 정답