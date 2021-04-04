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

int calc(int L)
{   
    int n, ans;
    ans = 1;

    for (int i = 1; i < 10; i++)
    {
        if (L % prime(i) == 0)
        {
            while (L % prime(i) == 0)
            {
                L /= prime(i);
                n++; 
                //cout << n << endl;
            }
            if (n >= 1)
            {
                ans *= (n + 1);
            }

            if (n == 0)
            {
                ans *= 2;
            }
            n = 0;
        }
    }
    return ans;
}

int main()
{
    int T, n, ans;
    int L[20], R[20];
    ans = 1;
    cin >> T;
    
    for (int i = 0; i < T; i++)
    {
        cin >> L[i] >> R[i];
    }

    for (int i = 0; i < T; i++)
    {
        if (calc(L[i] > calc(R[i])))
            cout << calc(L[i]) << endl;
        else 
            cout << calc(R[i]) << endl;
    }


}