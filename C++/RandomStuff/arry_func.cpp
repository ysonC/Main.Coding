#include<iostream>
#include<math.h>
using namespace std;

void compare(int a)
{
    if (a < 20)
    {
        cout << a*a*a << " ";
    }
    else
    {
        cout << a*a << " ";
    }
}

void input()
{
    int store[4];
    for (int i = 0; i < 4; i++)
    {
        cin >> store[i];
        compare(store[i]);
    }
    cout << endl;
}

int main()
{   
    input ();
}