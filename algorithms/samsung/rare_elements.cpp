/*


Samsung wants to explore some of the rare elements for its semiconductor manufacturing. Scientists use one
vehicle to explore the region in order to find
the rare elements. The vehicle can move only in explored region
where roads have already been constructed. The vehicle cannot move on unexplored
region where roads are not there. In the current situation, rare elements are present in explored region only.
Unexplored regions do not contain any rare elements.
Square region is provided for exploration.
Roads are represented by 1 and where roads are not present that area is represented by 0.
Rare elements will only be on the roads where regions have already been explored. Vehicle can move in four directions – up, down, left and right.
The shortest path for vehicle to a rare element position is called Moving Path. The longest of the paths to all rare elements from
a region called Longest Distance.
Scientists need to construct one research center so that the research center will be at the position where the longest path
to the rare elements will be shortest. This is called Shortest Longest Distance.
Constraints:

The region provided will be square region i.e. NxN (where 5 <= N <= 20).
There can be minimum of 2 rare elements and maximum of 4 rare elements, i.e. 2 <= C <= 4.
Roads are represented by 1 while no road area is represented by 0.
Vehicle can move only on roads in explored area.
The rare elements will only be present where road are there. Rare elements will not be present where roads are not present.
Vehicle can move in UP, DOWN, LEFT and RIGHT directions.
The starting index for rare element is considers as 1.

*/


#include<iostream>
using namespace std;


class QueueNode {
public:
	int x;
	int y;
	int level;
	QueueNode* next;
};

QueueNode* head = NULL;
QueueNode* tail = NULL;

int rare[4][2];
int arr[100][100];
bool visited[100][100];

int n,c;
int xMoves[] = {-1,0,0,1};
int yMoves[] = {0,1,-1,0};

int max(int a, int b) {
	if(a > b) return a;
	return b;
}

int min(int a, int b) {
	if(a > b) return b;
	return a;
}

bool isEmpty() {
	return (head == NULL);
}

void dequeue() {
	if(isEmpty()) return;
	QueueNode* temp = head;
	head = head->next;
	if(head == NULL) {
		tail = NULL;
	}
	delete(temp);
}

int frontX() {
	if(!isEmpty()) return head->x;
	return -1;
}

int frontY() {
	if(!isEmpty()) return head->y;
	return -1;
}

int frontLevel() {
	if(!isEmpty()) return head->level;
	return -1;
}

bool isValid(int x, int y) {
	if(x >= 0 && y >= 0 && x < n && y < n) {
		return true;
	}
	return false;
}

QueueNode* create_node(int x, int y, int level) {
	QueueNode* new_node = new QueueNode();
	new_node->x = x;
	new_node->y = y;
	new_node->level = level;
	new_node->next = NULL;
	return new_node;
}


void enqueue(int x, int y, int level) {
	QueueNode* new_node = create_node(x,y,level);
	if(head == NULL) {
		head = new_node;
		tail = new_node;
		return;
	}
	tail->next = new_node;
	tail = new_node;
	return;
}





int bfs(int start_x, int start_y, int end_x, int end_y) {
	enqueue(start_x,start_y,0);
	visited[start_x][start_y] = true;
	while(!isEmpty()) {
		int x = frontX();
		int y = frontY();
		int lev = frontLevel();
		if(x == end_x && y == end_y) {
            return lev;
		}
		dequeue();
		for(int index =0;index<4;index++) {
			int newX = x + xMoves[index];
			int newY = y + yMoves[index];
			int newL = lev + 1;
			if(isValid(newX,newY)) {
				if(!visited[newX][newY] && arr[newX][newY] == 1) {
					enqueue(newX,newY,newL);
					visited[newX][newY] = true;
				}
			}
		}
	}
}

int main() {
	int test;
	cin>>test;
	while(test--) {
		cin>>n;
		cin>>c;
		int i;
		head = NULL;
		tail = NULL;
		for(i=0;i<c;i++) {
			int x,y;
			cin>>x>>y;
			x--;
			y--;
			rare[i][0] = x;
			rare[i][1] = y;
		}
		int j;
		for(i=0;i<n;i++) {
			for(j=0;j<n;j++) {
				cin>>arr[i][j];
			}
		}
		int ans = 1e7;
		for(i=0;i<n;i++) {
			for(j=0;j<n;j++) {
                int temp;
				if(arr[i][j] == 1) {
                    temp = 0;
					for(int k=0;k<c;k++) {
                        for(int l =0; l<100; l++)for(int m =0; m<100; m++)visited[l][m] = false;
						head = NULL;
						tail = NULL;
						int res = bfs(i,j,rare[k][0],rare[k][1]);
						temp = max(temp,res);
					}
					ans = min(ans,temp);
				}
			}
		}
		cout<<ans<<endl;
	}
}
