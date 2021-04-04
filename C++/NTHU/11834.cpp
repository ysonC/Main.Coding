#include <iostream>
#include <cmath>

using namespace std;


void hanoi(int n)
{
    if (n == 0)
        return;
    else if (n > 0)
    {
        hanoi(n-1);
        cout << n << endl;
        hanoi(n-1);
    }
}

int main()
{
    int n;
    cin >>  n;
    hanoi(n);
}