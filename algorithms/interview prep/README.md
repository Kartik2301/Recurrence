BFS Breadth First Search

Use Cases: Shortest path in an unweighted graph, Shortest path in a grid, Can be used to find the shortest weight in a graph with binary edge weights (https://cp-algorithms.com/graph/01_bfs.html)
  1. https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1?page=1&category=BFS&sortBy=submissions
  2. https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1?page=1&category=BFS&sortBy=submissions
  3. https://www.geeksforgeeks.org/problems/shortest-source-to-destination-path3544/1?page=1&category=BFS&sortBy=submissions
  4. https://www.geeksforgeeks.org/problems/knight-walk4521/1?page=1&category=BFS&sortBy=submissions

Spread / Fire Pattern: Pick the sources of fire and put them in the queue and start a multi source BFS
  1. https://leetcode.com/problems/rotting-oranges/description/
  2. https://leetcode.com/problems/as-far-from-land-as-possible/description/
  3. https://leetcode.com/problems/01-matrix/description/

DFS Depth First Search
Use Cases: Useful when traversing the graph matters more than traversing in a particular order.
  1. https://leetcode.com/problems/number-of-islands/description/
  2. https://www.geeksforgeeks.org/problems/replace-os-with-xs0052/1?
  3. https://leetcode.com/problems/number-of-closed-islands/description/

Cycle Detection

1. Undirected Graph: https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1 [BFS / DFS]
2. Directed Graph: https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1 DFS / [BFS (Kahn's algorithm)]
3. https://www.geeksforgeeks.org/problems/eventual-safe-states/1
4.  

 Time Complexity (BFS / DFS): O(V+E)
  
  Brief derivation: BFS will be called for all the vertices so O(V)
    
    => For each vertice we'll explore it's neighbors 
    
    TC: O(V) + O(x1) + O(X2) + ... + O(Xv)
      = O(V) + O(2E) : for undirected graph, as the edges are undirected so u -> v and v -> u are treated separately, hence the inner loop will run double the times
      = O(V) + O(E) for directed graph
