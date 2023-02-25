int main() {
    int arr[] = {3,4,-7,3,1,3,1,-4,-2,-2};
    unordered_set<int> st;
    st.insert(0);
    int i;
    int n = 10;
    int runner = 0;
    bool flag = false;
    for(i=0;i<n;i++) {
        runner += arr[i];
        if(st.find(runner) != st.end()) {
            flag = true;
            break;
        } else {
            st.insert(runner);
        }
    }
    cout<<boolalpha<<flag<<endl;
}


// prefix sum;
// 3 7 0 3 4 7 8 4 2 0