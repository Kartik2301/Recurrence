string intToStr(int x, int afterPoints) {
    string temp = "";
    while(x) {
        temp += ((x % 10) + '0');
        x /= 10;
    }
    if(afterPoints > 0) {
        afterPoints -= temp.length();
    }
    while(afterPoints > 0) {
        temp += '0';
        afterPoints--;
    }
    int low = 0;
    int high = temp.length()-1;
    while(low < high) {
        char a = temp[low];
        temp[low] = temp[high];
        temp[high] = a;
        low++;
        high--;
    }
    return temp;
}
string ftoa(float n, int afterPoints) {
    int iPart = (int) n;
    float fPart = n - (float) iPart;
    string res = "";
    res += intToStr(iPart,0);
    if(afterPoints != 0) {
        res += ".";
        fPart = fPart*pow(10,afterPoints);
        res += intToStr((int) fPart,afterPoints);
    }
    return res;
}
int main() {
    string res = "";
    float n = 233.007;
    cout<<ftoa(n,4)<<endl;
}