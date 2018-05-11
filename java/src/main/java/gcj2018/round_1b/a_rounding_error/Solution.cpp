//============================================================================
// Name        : HelloWorld.cpp
// Author      : Spaich
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <cstdio>
#include <queue>
#include <vector>
#include <cmath>
using namespace std;

int N, L;
struct Elem {
    int value;
    bool operator<(const Elem &e) const {
        int moa = value * 100 % N;
        int mob = e.value * 100 % N;

        if(2 * moa >= N) moa -= N;
        if(2 * mob >= N) mob -= N;
        return moa < mob;
    }
};

int round_user(int A, int B) {
    int div = A / B, mod = A % B;
    if(mod * 2 >= B) div++;
    return div;
}

int main() {
    int T; scanf("%d", &T);
    for(int z=1; z<=T; z++) {
        scanf("%d%d", &N, &L);

        priority_queue<Elem> que;
        int ans = 0, rest = N;
        for(int i=0; i<L; i++) {
            int A; scanf("%d", &A);
            rest -= A;
            que.push(Elem{A});
        }

        while(rest--) {
            Elem cur = que.top(); que.pop();
            if(cur < Elem{0}) {
                que.push(cur);
                que.push(Elem{1});
            }
            else {
                que.push(Elem{cur.value + 1});
            }
        }

        while(que.size()) {
            int v = que.top().value; que.pop();
            ans += round_user(v * 100, N);
        }
        printf("Case #%d: %d\n", z, ans);
    }
    return 0;
}
