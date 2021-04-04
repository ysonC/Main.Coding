#include <iostream>
#include <cmath>

using namespace std;

int prime(int n)
{
    int i, a, ans;

    for (int a = 1; n > 0; a++)
    {
        if (a == 2)
            {
                n--;
                if (n == 0)
                ans = i;
            }
        else
        {
            for (i = 2; i <= a; i++ )
            {
                if ((a%i == 0) && a != i)
                {
                    break;
                }

                else if (i == a)
                {
                    n--;
                    if (n == 0)
                    ans = i;
                    break;
                }
                else if (a%i != 0)continue;
            }
        }
    }
    return ans;
}

int fac(int a, int b)
{
    int cnt1, cnt2, ans;
    cnt1 = 0;
    cnt2 = 0;

    for (int i = a; i <= b; a++)
    {
        for (int i = 1; i <= a; i++)
        {
            if (a % i == 0)
            {
                //cout << i << " ";
                cnt1++;
            }
            else
            continue;

            if (cnt1 > cnt2)
            {
                cnt2 = cnt1;
                ans = a;
            }

        }

        // for (int i = 1; i <= b; i++)
        // {
        //     if (b % i == 0)
        //     {
        //         //cout << i << " ";
        //         cnt2++;
        //     }
        //     else
        //     continue;
        // }
    }

    // if (cnt1 > cnt2)
    //     return a;
    // else
    //     return b;
    return ans;

}

int main()
{
    int L[20], R[20];
    int t;

    cin >> t;

    for (int i = 0; i < t; i++)
    {
        cin >> L[i] >> R[i];
    }
    cout << "\n" << "::" << endl;
    for (int i = 0; i < t; i++)
    {
        cout << fac(L[i],R[i]) << endl;

    }

}