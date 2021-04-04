#include <iostream>

using namespace std;

int main()
{
    int cases, n,tmp;

    cin >> cases;
    while (cases--)
    {
        int store[100];
        cin >> n;

            for (int i = 0; i < n ; i++)
            {
                cin >> store[i];
            }
            for (int i = 0; i < n -1; i++)
            {
                if (store[i] > store[i+1])
                {
                    tmp = store[i+1];
                    store[i+1] = store[i];
                    store[i] = tmp;
                    i = -1;
                }
            }

            for (int i = 0; i < n-1; i++)
            {
                cout << store[i] << " ";
            }
            cout << store[n-1];
            cout << endl;
    }
}