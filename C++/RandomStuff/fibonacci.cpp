#include <iostream>
#include <cmath>

using namespace std;

// n == > 10 n-1 ==> 9
// fib ==> 0 1 1 2 3 5 8 13 21 34
// 1 2 3 4 5 6 7
// 1 1 2 3 5 8 13 21
//213


int fib(int n)
{
    if (n == 0)
        return 1;

    else if (n > 0)
        return (fib (n-1) + fib(n-2));
    return 0;
}

int main()
{
    int n, cnt;
    int a, b, c;
    a = 0;
    b = 1;
    cin >> n;
    cout << fib(n-2);

    for (int i = 0; i < n-2; i++)
    {
        c = a + b;
        a = b;
        b = c;

    }
    cout << "\n" << c << endl;
}