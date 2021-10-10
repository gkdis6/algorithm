# 너비 우선 탐색(BFS)

## 너비 우선 탐색이란

루트 노드(혹은 다른 임의의 노드)에서 시작해서 인접한 노드를 먼저 탐색하는 방법

- 시작 노드로부터 가까운 노드를 먼저 방문하고 멀리 떨어져 있는 노드를 나중에 방문하는 순회 방법
- 깊게 탐색하기 전에 넓게 탐색하는 것
- 사용하는 경우 : 두 노드 사이의 최단 경로 혹은 임의의 경로를 찾고 싶을 때 이 방법을 선택
- 너비 우선 탐색(BFS)이 깊이 우선 탐색(DFS)보다 좀 더 복잡하다.

## 특징

- 직관적이지 않다.
- 재귀적으로 동작하지 않는다.
- 그래프 탐색의 경우 어떤 노드를 방문했었는지 여부를 검사 해야 한다.
- 차례로 저장하고 꺼낼 수 있는 자료구조인 큐를 사용
- FIFO 원칙으로 탐색
- 'Prim', 'Dijkstra' 알고리즘과 유사

```java
public class Solution {
	public static void solution(int nodesNum, int[][] edge, int rootNode) {
		int[] distance = new int[nodesNum + 1];
		boolean[][] map = new boolean[nodesNum + 1][nodesNum + 1];

		for (int i = 0; i < edge.length; i++) {
			map[edge[i][0]][edge[i][1]] = map[edge[i][1]][edge[i][0]] = true;
		}

		Queue<Integer> nodes = new LinkedList<Integer>();
		nodes.add(rootNode);

		int maxDist = 0;
		while (!nodes.isEmpty()) {
			int i = nodes.poll();

			for (int j = 1; j <= nodesNum; j++) {
				if (j == rootNode)
					continue;
				if (distance[j] == 0 && map[i][j]) {
					distance[j] = distance[i] + 1;
					nodes.add(j);
					maxDist = Math.max(maxDist, distance[j]);
				}
			}
		}
		for (int i = 1; i < nodesNum + 1; i++) {
			System.out.println(distance[i]);
		}
	}

	public static void main(String[] args) {
		int[][] net = {{1,2}, {2,1}, {3,4}, {2,3}, {1,4}};
		solution(4, net, 1);

	}
}

```

