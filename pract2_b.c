#include <stdio.h>
#include <math.h>
#include <limits.h>
#include <stdbool.h>

#define V 4

double distance(double x1, double y1, double x2, double y2)
{
    return sqrt(((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)));
}

int minKey(double key[],bool inMST[])
{
    double min = INT_MAX;
    int min_index = -1;
    for (int v = 0; v < V; v++)
    {
        if (!inMST[v] && key[v] < min)
        {
            min = key[v];
            min_index = v;
        }
    }
    return min_index;
}

void primMST(double graph[V][V],char city[V][30])
{
    int parent[V];
    double key[V];
    bool inMST[V];

    for (int i = 0; i < V; i++)
    {
        key[i] = INT_MAX;
        inMST[i] = false;
    }
    key[0] = 0;
    parent[0] = -1;

    for (int count = 0; count < V - 1; count++)
    {
        int u = minKey(key, inMST);
        inMST[u] = true;

        for (int v = 0; v < V; v++)
        {
            if (graph[u][v] && !inMST[v] && graph[u][v] < key[v])
            {
                parent[v] = u;
                key[v] = graph[u][v];
            }
        }
    }

    double total = 0;
    printf("From - To : Dist\n");
    for (int i = 1; i < V; i++)
    {
        printf("%s - %s : %0.2f\n", city[parent[i]], city[i], graph[i][parent[i]]);
        total += graph[i][parent[i]];
    }
    printf("\nTotal cost: %0.2f\n", total);
}

int main()
{
    char city[V][30];
    double lat[V], long[V];
    double graph[V][V];

    printf("Enter details for %d cities (different states):\n", V);
    for (int i = 0; i < V; i++)
    {
        printf("\nCity %d name: ", i + 1);
        scanf("%s", city[i]);
        printf("Latitude: ");
        scanf("%lf", &lat[i]);
        printf("Longitude: ");
        scanf("%lf", &long[i]);
    }
   
    for (int i = 0; i < V; i++)
    {
        for (int j = 0; j < V; j++)
        {
            if (i == j)
            {
                graph[i][j] = 0;
            }
            else
            {
                graph[i][j] = distance(lat[i], long[i], lat[j], long[j]);
            }
        }
    }

    primMST(graph, city);
    return 0;
}