import collections

def solution(bridge_length, weight, truck_weights):
    bridge = collections.deque([0] * bridge_length)
    total_weight = 0
    time = 0
    
    truck_weights = collections.deque(truck_weights)
    while truck_weights or total_weight > 0:
        time += 1
        exiting_truck = bridge.popleft()
        total_weight -= exiting_truck
        
        if truck_weights:
            if total_weight + truck_weights[0] <= weight:
                next_truck = truck_weights.popleft()
                bridge.append(next_truck)
                total_weight += next_truck
            else:
                bridge.append(0)
    return time
            
        