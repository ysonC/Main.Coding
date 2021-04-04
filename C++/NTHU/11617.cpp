#include <iostream>
#include <cmath>

using namespace std;

int main () 

{
    int n,m;
    int input,tmp;
    cin >> n >> m;
    int store[n];
    store[0] = 1;

    // for(int i = 0; i < m; i++)
    // {
    //     cin >> input[i];
    // }

    for (int i = 1; i <= n; i++)
    {
        store[i] = i+1;
    }
    while(m--)
    {
        cin >> input;

        for (int i = 0; i <= n; i++)
        {
            if (input == store[i])
            {
                tmp = store [i];
                store [i] = store[0];
                store [0] = tmp;

                for (int j = 1; j < i; j++)
                {
                    tmp = store [i];
                    store [i] = store[j];
                    store[j] = tmp;
                }
            }
        }
    }
    cout << "\n";
    for (int i = 0; i < n; i++)
    {
        cout << store[i];

    }
}