Collections.sort() 은 Timsort이다. Timsort 의 경우 합병 및 삽입정렬 알고리즘을 사용한다. 이렇게 두 가지가 섞여있는 정렬 알고리즘을 **hybrid sorting algorithm** 이라고 하는데, 합병정렬(Merge Sort)의 경우 최선, 최악 모두 ***O(nlogn)*** 을 보장하고. 삽입정렬(Insertion sort)의 경우 최선의 경우는 ***O(n)*** , 최악의 경우는 ***O(n2)*** 이다. 그리고 두 정렬 모두 안정 정렬(stable sort)이기 때문에 Timsort를 **hybrid stable sorting algorithm**이라고도 한다.

즉, 합병정렬의 최악의 경우와 삽입정렬의 최선의 경우를 짬뽕한 알고리즘이 Timsort 라는 것이다. 실제로 파이썬이나 기타 정렬 알고리즘에서 가장 많이 쓰이는 알고리즘이기도 하다.

시간복잡도 ***O(n)*** ~ ***O(nlogn)*** 을 보장한다는 장점이 있다. 대신에 Collections.sort()를 사용하고자 한다면 가장 쉬운 방법으로는 일반적인 primitive 배열이 아닌 List 계열(ArrayList, LinkedList 등..)의 자료구조를 사용하여 정렬해야한다.