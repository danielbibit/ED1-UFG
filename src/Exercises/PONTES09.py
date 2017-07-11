import numpy as np

def dijk(graph, origin, destin):
    visited = []
    distance = [None for i in range(graph.shape[0])]

    for i in range(graph.shape[0]):
        distance[i] = float('inf')
        visited.append(i)

    distance[origin] = 0

    while visited:
        current_vertex = float('inf')
        # print 'visited:', visited
        # print 'distance:', distance

        for i in range(graph.shape[0]):
            if distance[i] < current_vertex and i in visited:
                current_vertex = i

                # print 'current_vertex:', current_vertex

        visited.remove(current_vertex)

        for i in range(graph.shape[0]):
            if graph[current_vertex, i] != 0:
                alternate_path = distance[current_vertex] + graph[current_vertex, i]
                if alternate_path < distance[i]:
                    distance[i] = alternate_path

    # return int(distance[destin-1])
    return int(distance[destin])

buff = raw_input().split(' ')
n, m = int(buff[0]), int(buff[1])

graph = np.zeros(shape=(n + 2, n + 2))

for i in range(m):
    buff = raw_input().split(' ')
    buff = map(lambda x: int(x), buff)

    graph[buff[0], buff[1]] = graph[buff[1], buff[0]] = buff[2]

print dijk(graph, 0, n + 1)
