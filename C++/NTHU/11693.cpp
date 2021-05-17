#include<iostream>
#include<math.h>
using namespace std;

int main()
{
    int panel[10][10];
    int top, bottom, height;
    cin >> top, bottom, height;

    for(int i= 0; i< 10; i++)
    {
        for(int j = 0; j < 10; j++)
        {
            panel[i][j] = 1;
            cout << panel[i][j];
        }
    }

    cout << panel;
}