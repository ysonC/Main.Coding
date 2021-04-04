#include<iostream>
#include<math.h>
using namespace std;


int counter (int a)
{
    a++;
    return a;
}

int main ()
{
    int a, b;
    int cnt = 0;
    cin >> a >> b;
    if (a > b)
         cnt = counter(cnt);

    cout << cnt;
}