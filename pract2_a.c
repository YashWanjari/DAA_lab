#include <stdio.h>
#include <limits.h>
#include <stdbool.h>

#define V 4

int minKey(int key[], bool inMST[]) {
    int min = INT_MAX, min_index = -1;
    for (int v = 0; v < V; v++) {
        if (!inMST[v] && key[v] < min) {
            min = key[v];
            min_index = v;
        }
    }
    return min_index;
}

void primMST(int graph[V][V]) {
    int parent[V];
    int key[V]; // edge weights
    bool inMST[V];

    for (int i = 0; i < V; i++) {
        key[i] = INT_MAX;
        inMST[i] = false;
    }

    key[0] = 0;
    parent[0] = -1;

    for (int count = 0; count < V - 1; count++) {
        int u = minKey(key, inMST);
        inMST[u] = true;

        for (int v = 0; v < V; v++) {
            if (graph[u][v] && !inMST[v] && graph[u][v] < key[v]) {
                parent[v] = u;
                key[v] = graph[u][v];
            }
        }
    }

    int totalCost = 0;
    printf("S   D  Cost\n");
    for (int i = 1; i < V; i++) {
        printf("%d - %d   %d\n", parent[i], i, graph[i][parent[i]]);
        totalCost += graph[i][parent[i]];
    }
    printf("Total cost of MST: %d\n", totalCost);
}

int main() {
    int graph[V][V];
    printf("Enter the edge costs:\n");
    printf("Make sure diagonal elements are 0\n");
    for (int i = 0; i < V; i++) {
        for (int j = 0; j < V; j++) {
            printf("Enter the weight at (%d,%d): ", i, j);
            scanf("%d", &graph[i][j]);
        }
    }
    primMST(graph);
    return 0;
}