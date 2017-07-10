import numpy as np

def dijk(graph, origin, destin):
    visited = []
    distance = []

    distance[origin] = 0

    while True:
        n = -1

        for i in range(destin):
            if not visited[i] and (n == -1 or distance[i] < distance[n]):
                n = i
        if n == -1:
            break

        visited[n] = 1

        for i in range(destin):
            if(dis[i] > dis[n] + graph[n, i]):
                dis[i] = dis[n] + graph[n, i]

    return 0

buff = raw_input().split(' ')
n, m = int(buff[0]), int(buff[1])

graph = np.zeros(shape=(n + 2, n + 2))

for i in range(m):
    buff = raw_input().split(' ')
    buff = map(lambda x: int(x), buff)

    graph[buff[0], buff[1]] = graph[buff[1], buff[0]] = buff[2]

print graph
# print dijk(graph, 0, n + 2)
