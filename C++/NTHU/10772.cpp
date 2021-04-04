#include<iostream>
#include<math.h>
using namespace std;

int main ()
{
    char a[3]; // match value
    char store[10]; // test value
    int n, tmp, ans, b;

    ans = 0;
    tmp = 0;

    cin.getline(a,5); // store matching number ex. 12
    cin >> n;
    
    while(n--)//!!! not cnt<n
    {
        cin >> store; // enter test value ex. 1212 ==> 2
        for (int i = 0; i < 10; i++)
        {
            for(int j =0; j <= 3; j++)
            {
                if (store[i] == a[j])
                {
                    if (store[i+1] == a[j+1])
                    {
                        //cout << "found 12" << endl;
                        tmp++;
                    }
                    else
                    break;
                }
                else 
                break;
            }

        }
            if (tmp > ans)
            ans = tmp;
            tmp = 0;
    }

    cout << "The total " << a << " are " << ans;

}