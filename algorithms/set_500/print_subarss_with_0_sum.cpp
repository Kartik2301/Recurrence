int main() {
    int arr[] = {3,4,-7,3,1,3,1,-4,-2,-2};
    unordered_multimap<int,int> map;
    map.insert({0,-1});
    int i;
    int n = 10;
    int runner = 0;
    bool flag = false;
    for(i=0;i<n;i++) {
        runner += arr[i];
        if(map.find(runner) != map.end()) {
            auto it = map.find(runner);
            while(it != map.end() && it->first == runner) {
                cout<<"[ "<<it->second+1<<" "<<i<<" ]"<<endl;
                it++;
            }
        }
        map.insert({runner,i});
    }
    cout<<boolalpha<<flag<<endl;
}


// prefix sum;
// 3 7 0 3 4 7 8 4 2 0