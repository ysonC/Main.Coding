#include <iostream>
#include <math.h>
using namespace std;

int main()
{
    int a, n, p, ans;
    long long int pwr;
    int cases;
    cin >> cases;
    while (cases--)
    {
        cin >> a >> n >> p;
        pwr = pow(a,n);
        ans = pwr % p;
        cout << ans << endl;
    }
}