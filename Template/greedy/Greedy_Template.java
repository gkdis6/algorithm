import java.io.*;
import java.util.*;

class Greedy_Template {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    // 활동 선택 문제 (Activity Selection Problem)
    static class Activity {
        int start, end;
        
        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    // 활동 선택 - 가장 많은 활동 선택하기
    static int activitySelection(Activity[] activities) {
        // 종료 시간을 기준으로 정렬
        Arrays.sort(activities, (a, b) -> a.end - b.end);
        
        int count = 1;
        int lastEnd = activities[0].end;
        
        for (int i = 1; i < activities.length; i++) {
            if (activities[i].start >= lastEnd) {
                count++;
                lastEnd = activities[i].end;
            }
        }
        
        return count;
    }
    
    // 분할 가능한 배낭 문제 (Fractional Knapsack)
    static class Item {
        int weight, value;
        double ratio;
        
        Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
            this.ratio = (double) value / weight;
        }
    }
    
    static double fractionalKnapsack(Item[] items, int capacity) {
        // 가치/무게 비율로 내림차순 정렬
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));
        
        double totalValue = 0;
        int currentWeight = 0;
        
        for (Item item : items) {
            if (currentWeight + item.weight <= capacity) {
                // 전체 아이템 추가
                currentWeight += item.weight;
                totalValue += item.value;
            } else {
                // 일부만 추가
                int remainingCapacity = capacity - currentWeight;
                totalValue += item.value * ((double) remainingCapacity / item.weight);
                break;
            }
        }
        
        return totalValue;
    }
    
    // 동전 교환 문제 (Coin Change - 그리디)
    static int coinChange(int[] coins, int amount) {
        // 큰 동전부터 사용 (내림차순 정렬)
        Arrays.sort(coins);
        int n = coins.length;
        
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            while (amount >= coins[i]) {
                amount -= coins[i];
                count++;
            }
        }
        
        return amount == 0 ? count : -1;
    }
    
    // 회의실 배정 문제 (Meeting Room Assignment)
    static class Meeting {
        int start, end;
        
        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    static int maxMeetings(Meeting[] meetings) {
        // 종료 시간 기준으로 정렬
        Arrays.sort(meetings, (a, b) -> a.end - b.end);
        
        int count = 1;
        int lastEnd = meetings[0].end;
        
        for (int i = 1; i < meetings.length; i++) {
            if (meetings[i].start >= lastEnd) {
                count++;
                lastEnd = meetings[i].end;
            }
        }
        
        return count;
    }
    
    // 최소 스패닝 트리 - 크루스칼 알고리즘
    static class Edge {
        int src, dest, weight;
        
        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
    
    static class UnionFind {
        int[] parent, rank;
        
        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }
        
        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        
        boolean union(int x, int y) {
            int px = find(x);
            int py = find(y);
            
            if (px == py) return false;
            
            if (rank[px] < rank[py]) {
                parent[px] = py;
            } else if (rank[px] > rank[py]) {
                parent[py] = px;
            } else {
                parent[py] = px;
                rank[px]++;
            }
            return true;
        }
    }
    
    static int kruskal(Edge[] edges, int n) {
        // 가중치 기준으로 정렬
        Arrays.sort(edges, (a, b) -> a.weight - b.weight);
        
        UnionFind uf = new UnionFind(n);
        int mstWeight = 0;
        int edgeCount = 0;
        
        for (Edge edge : edges) {
            if (uf.union(edge.src, edge.dest)) {
                mstWeight += edge.weight;
                edgeCount++;
                if (edgeCount == n - 1) break;
            }
        }
        
        return mstWeight;
    }
    
    // 허프만 코딩 (Huffman Coding)
    static class HuffmanNode {
        char ch;
        int freq;
        HuffmanNode left, right;
        
        HuffmanNode(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
        
        HuffmanNode(int freq) {
            this.freq = freq;
        }
    }
    
    static HuffmanNode buildHuffmanTree(char[] chars, int[] freqs) {
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>((a, b) -> a.freq - b.freq);
        
        for (int i = 0; i < chars.length; i++) {
            pq.offer(new HuffmanNode(chars[i], freqs[i]));
        }
        
        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();
            
            HuffmanNode merged = new HuffmanNode(left.freq + right.freq);
            merged.left = left;
            merged.right = right;
            
            pq.offer(merged);
        }
        
        return pq.poll();
    }
    
    // 작업 스케줄링 (Job Scheduling)
    static class Job {
        int id, deadline, profit;
        
        Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }
    
    static int jobScheduling(Job[] jobs) {
        // 이익 기준으로 내림차순 정렬
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);
        
        int maxDeadline = 0;
        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }
        
        boolean[] timeSlot = new boolean[maxDeadline + 1];
        int totalProfit = 0;
        
        for (Job job : jobs) {
            for (int i = job.deadline; i >= 1; i--) {
                if (!timeSlot[i]) {
                    timeSlot[i] = true;
                    totalProfit += job.profit;
                    break;
                }
            }
        }
        
        return totalProfit;
    }
    
    public static void main(String[] args) throws IOException {
        // 활동 선택 문제 예시
        Activity[] activities = {
            new Activity(1, 4),
            new Activity(3, 5),
            new Activity(0, 6),
            new Activity(5, 7),
            new Activity(3, 8),
            new Activity(5, 9),
            new Activity(6, 10),
            new Activity(8, 11),
            new Activity(8, 12),
            new Activity(2, 13),
            new Activity(12, 14)
        };
        
        System.out.println("최대 선택 가능한 활동 수: " + activitySelection(activities));
        
        // 분할 가능한 배낭 문제 예시
        Item[] items = {
            new Item(10, 60),
            new Item(20, 100),
            new Item(30, 120)
        };
        int capacity = 50;
        
        System.out.println("최대 가치: " + fractionalKnapsack(items, capacity));
        
        // 동전 교환 문제 예시
        int[] coins = {1, 5, 10, 25};
        int amount = 67;
        
        System.out.println("최소 동전 개수: " + coinChange(coins, amount));
        
        // 회의실 배정 문제 예시
        Meeting[] meetings = {
            new Meeting(1, 3),
            new Meeting(2, 4),
            new Meeting(3, 5),
            new Meeting(4, 6),
            new Meeting(5, 7)
        };
        
        System.out.println("최대 회의 수: " + maxMeetings(meetings));
        
        // 최소 스패닝 트리 예시
        Edge[] edges = {
            new Edge(0, 1, 10),
            new Edge(0, 2, 6),
            new Edge(0, 3, 5),
            new Edge(1, 3, 15),
            new Edge(2, 3, 4)
        };
        
        System.out.println("최소 스패닝 트리 가중치: " + kruskal(edges, 4));
        
        // 작업 스케줄링 예시
        Job[] jobs = {
            new Job(1, 4, 20),
            new Job(2, 1, 10),
            new Job(3, 1, 40),
            new Job(4, 1, 30)
        };
        
        System.out.println("최대 이익: " + jobScheduling(jobs));
    }
}