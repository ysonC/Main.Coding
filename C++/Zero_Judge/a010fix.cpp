#include<iostream>
#include<cstdlib>

using namespace std;

int main ()
{
     int i, a, n, tmp;

    cin >> a;
    tmp = a;

    for (i = 2; i <= a; i++)
    {
        if (tmp % i == 0)
        {
            while (tmp % i == 0)
            {
                tmp/= i; // tmp = tmp / i  ==> decreasing to 1 to end loop
                n++; // count power
            }
            if (n > 1)
            {
                cout << i << "^" << n;
                if (tmp > 1) // prevent last *
                cout << " * ";
                n = 0;
                continue;
            }
            n = 0;
            cout << i;
            if (tmp > i) // prevent last *
            cout << " * "; 
        }
    }   

}