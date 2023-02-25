#include<iostream>
using namespace std;
int n,m;
int sx,sy,dx,dy;
bool visited[100][100];

int xMoves[] = {-2,-2,2,2,-1,-1,1,1};
int yMoves[] = {1,-1,1,-1,2,-2,2,-2};

class QueueNode {
	public:
		int x;
		int y;
		int level;
		QueueNode* next;
};

QueueNode* head = NULL;
QueueNode* tail = NULL;

bool isEmpty() {
	return (head == NULL);
}

QueueNode* create(int x, int y,int level) {
	QueueNode* new_node = new QueueNode();
	new_node->x = x;
	new_node->y = y;
	new_node->level = level;
	new_node->next = NULL;
	return new_node;
}

void enqueue(int x, int y, int level) {
	QueueNode* new_node = create(x,y,level);
	if(head == NULL) {
		head = new_node;
		tail = new_node;
		return;
	}
	tail->next = new_node;
	tail = new_node;
	return;
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
	return (x >= 0 && y >= 0 && x < n && y < m);
}

int solve() {
	enqueue(sx,sy,0);
	visited[sx][sy] = true;
	while(!isEmpty()) {
		int x = frontX();
		int y = frontY();
		int level = frontLevel();
		dequeue();
		if(x == dx && y == dy) return level;
		for(int index=0;index<8;index++) {
			int newX = x + xMoves[index];
			int newY = y + yMoves[index];
			if(isValid(newX,newY)) {
				if(!visited[newX][newY]) {
					visited[newX][newY] = true;
					enqueue(newX,newY,level+1);
				}
			}
		}
	}
	return 0;
}


int main() {
	int test;
	cin>>test;
	while(test --) {
		int i,j;
		for(i=0;i<100;i++) {
			for(j=0;j<100;j++) {
				visited[i][j] = false;
			}
		}
		cin>>n>>m;
		cin>>sx>>sy>>dx>>dy;
		head = NULL;
		tail = NULL;
		cout<<solve()<<endl;
	}
}
