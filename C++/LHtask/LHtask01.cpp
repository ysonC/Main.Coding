#include <iostream>
#include <math.h>
using namespace std;
//求N! （如:5!=1*2*3*4*5）
//Q.4: 輸入兩個數字(EX: 2 5 -> 2+22+222+2222+22222 )
int main()
{
//     int n, ans, i;
//     cin >> n;
//     ans = 1;
//     for (i=1; i != n; i++ )
//     {
//         ans *= i;
//         // ans = ans * (n-i)

//     }
//     cout << ans;
// // n * (n-1).. (n- (n-1))
//

        int a, n, i, ans, k;
        cin >> a; // 2
        cin >> n; // 5       --> 2+22+222
        k = 0;
        ans = 0;
        for (i =0 ; i < n; i++)
        {
            k += (pow(10,i))*a;
            cout << k << endl;
            ans += k;
        }
        cout << ans << endl;
        system ("pause");

}