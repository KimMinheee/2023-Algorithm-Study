https://www.acmicpc.net/problem/11004

O(nlogn)인 다른 정렬을 사용해도 되겠지만 만약 quick정렬을 이용하는 경우

마치 이진검색과 비슷하게 초기에 pivot을 중간 인덱스의 값으로 정함

파티션을 둬서 정렬할 부분이 **있다면** 정렬을 진행하는 것이 포인트

partition함수는 피봇(여기서는 중간 인덱스 값으로 했음)을 기준으로 경계를 리턴하는 함수

quickSort함수가 partition함수의 리턴값을 받아 경계를 기준으로 데이터가 있는 쪽에 정렬을 수행



