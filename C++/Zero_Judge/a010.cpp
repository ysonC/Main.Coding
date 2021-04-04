#include<iostream>
#include<cstdlib>

using namespace std;
//
int main()
{
    int i, a, n;

    cout << "Enter a number: ";

    cin >> a;

    for (i = 2; i <= a * 2; i++)
    {
        if (a % i == 0)
        {
            n++;
            a /= i;
            cout << i;   
            i = 1;
            if (a > i)
                cout << " * ";
        }
    }

    if (n == 0)
    {
        cout << a;
    }

}