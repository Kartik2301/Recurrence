vector <int> countDistinct (int A[], int n, int k) {
    unordered_map<int,int> freq;
    int i;
    vector<int> vec;
    for(i=0;i<k;i++) {
        freq[A[i]]++;
    }
    vec.push_back(freq.size());
    for(i=k;i<n;i++) {
        freq[A[i-k]]--;
        freq[A[i]]++;
        if(freq[A[i-k]] == 0) {
            freq.erase(A[i-k]);
        }
        vec.push_back(freq.size());
    }
    return vec;
}