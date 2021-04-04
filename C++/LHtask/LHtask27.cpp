#include <iostream>

using namespace std;

int main() 
{
    int a, i, tmp, j;
    cin >> a;

    for (i = 1; i <= a; i += 2)
    {
        tmp = i;
        while(tmp > 0)
        {
            cout << "*";
            tmp--;
        }
        cout << "\n";
    }

    for (j = a - 2; j >= 0; j -= 2)
    {
        tmp = j;
        while(tmp > 0)
        {
            cout << "*";
            tmp--;
        }
        cout << "\n";
    }
}