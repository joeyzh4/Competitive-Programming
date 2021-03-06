#include <bits/stdc++.h>
#include <fstream>

#define mp make_pair
#define pb push_back
#define INF 1<<30
#define MOD 1000000007
#define rint(x) scanf("%d", &(x))
#define rlong(x) scanf("%lld", &(x))

#define VSIZE 50500
#define ESIZE 100000

using namespace std;
typedef long long ll;
typedef pair<int, int> pi;
typedef pair<ll, ll> pll;

int startIndex, endIndex;
vector<int> vCurr (VSIZE);
vector<int> vLeft (VSIZE);

vector<pi> e;
set<pi> setE;

void insertEdge(int a, int b){
    if(a > b)
        swap(a, b);
    e.pb(mp(a, b));
    setE.insert(mp(a, b));
}

int getIndex(){
    return rand()%(endIndex+1);
}
void vinsert(vector<int>& v, int x){
    v[startIndex++] = x;
}
void vdelete(vector<int>& v, int i){
    swap(v[i], v[endIndex]);
    v[endIndex] = -1;
    endIndex--;
}

int main(){

    int edges[] = {10, 100, 2000, 5000, 10000, 25000, 50000, 75000, 88888, 100000};
    int vertices[] = {6, 40, 1337, 2500, 5000, 7654, 10000, 20000, 25000, 50000};
    int cost[] = {100, 100, 500, 500, 1000, 1000, 5000, 5000, 10000, 10000};
    for(int x = 0; x < 10; x++){
        ostringstream ss;
        ss << (x+1);
        ofstream out("C:\\Documents and Settings\\Name\\Desktop\\UTS Open\\out" + ss.str() + ".txt");

        e.clear();
        setE.clear();
        startIndex = 0;
        endIndex = vertices[x]-1;
        for(int x = 0; x < VSIZE; x++){
            vCurr[x] = -1;
            vLeft[x] = -1;
        }

        out << vertices[x] << " " << edges[x] << endl;

        for(int x = 0; x < vertices[x]; x++)
            vLeft[x] = x;

        int nextElement = getIndex();
        vinsert(vCurr, vLeft[nextElement]);
        vdelete(vLeft, nextElement);

        while(endIndex != -1){
            int vertexIndex = rand()%startIndex;
            int nextIndex = getIndex();
            insertEdge(vCurr[vertexIndex], vLeft[nextIndex]);

            vinsert(vCurr, vLeft[nextIndex]);
            vdelete(vLeft, nextIndex);
        }
        for(int x = 0; x < edges[x] - (vertices[x] - 1);){
            int a = rand()%vertices[x];
            int b = rand()%vertices[x];
            if(a > b)
                swap(a, b);
            if(a != b && !setE.count(mp(a, b))){
                insertEdge(a, b);
                x++;
            }
        }
        for(int x = 0; x < e.size(); x++){
            int c = rand()%cost[x];
            int isSwap = rand()%2;
            if(isSwap)
                out << (e[x].first+1) << " " << (e[x].second+1) << " " << c << endl;
            else
                out << (e[x].second+1) << " " << (e[x].first+1) << " " << c << endl;
            printf("%d -- %d [label = %d]\n", (e[x].first+1), (e[x].second+1), c);
        }
        printf("\n");
    }
}
