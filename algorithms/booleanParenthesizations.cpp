unordered_map<string,int> mp;
long mod = 1e3 + 3;
int solve(string s, int i, int j, bool isTrue){
    if(i > j) {
        return 0;
    }
    if(i == j) {
        if(isTrue) {
            return s[i] == 'T';
        } else {
            return s[i] == 'F';
        }
    }
    
    string temp = to_string(i);
    temp.push_back(' ');
    temp.append(to_string(j));
    temp.push_back(' ');
    temp.append(to_string(isTrue));
    if(mp.find(temp) != mp.end()) {
        return mp[temp]%mod;
    }
    int answer = 0;
    for(int k = i+1; k<=j-1; k+=2) {
        int lT = solve(s,i,k-1,true);
        int lF = solve(s,i,k-1,false);
        int rT = solve(s,k+1,j,true);
        int rF = solve(s,k+1,j,false);
        if(s[k] == '&') {
            if(isTrue) {
                answer += lT*rT;
            } else {
                answer += lF*rT + lF*rF + lT*rF;
            }
        } else if(s[k] == '|') {
            if(isTrue) {
                answer += lT*rT + lT*rF + lF*rT;
            } else {
                answer += lF*rF;
            }
        } else if(s[k] == '^') {
            if(isTrue) {
                answer += lT*rF + lF*rT;
            } else {
                answer += lF*rF + lT*rT;
            }
        }
    }
    return mp[temp] = answer%mod;
}
int main() {
     mp.clear();
     string s = "T^F&T";
     cout<<solve(s,0,s.length()-1,true)%mod<<endl;
     s = "T|T&F^T";
     cout<<solve(s,0,s.length()-1,true)%mod<<endl;
}
