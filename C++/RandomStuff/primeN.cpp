#include <iostream>

using namespace std;

int main()
{
    int i, a, n;
    
    cin >> n;

    for (int a = 1; n > 0; a++)
    {
        if (a == 2)
            {
                cout << a << " ";
                n--;
            }
        else
        {
            for (i = 2; i <= a; i++ )
            {
                if ((a%i == 0) && a != i)
                {  
                    break;
                }

                else if (i == a)
                {
                    cout << a << " ";
                    n--;
                    break;
                }
                
                else if (a%i != 0)continue;
            }
        }
    }
}