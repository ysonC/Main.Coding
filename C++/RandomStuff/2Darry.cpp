#include <iostream>

using namespace std;

int main()
{
    int a, b, z, t;
    //cin >> a >> b;

    // int ROWS = a;
    // int COLUMNS = b;
    //int maze[ROWS][COLUMNS]; // 3   5 
    int columns[100];
    int rows[100];
    
    for (z = 0; z < 5; z ++)
    {
        cin >> columns[z];
    }

    for (t = 0; t < 5; t++)
    {
        cin >> rows[t];
    }

     for (z = 0; z < 5; z ++)
    {
        cout << columns[z] << " ";
    }
        cout << endl;

     for (t = 0; t < 5; t++)
    {
        cout << rows[t] << " ";
    }
    return 0;
    
}