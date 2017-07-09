import numpy as np

def dijk(graph, origin, destin):
    visited = []

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
