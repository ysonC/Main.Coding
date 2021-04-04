#include <iostream> 
#include <math.h>
using namespace std; 


void no_root(int x)
{
    if (x < 0)
    cout << "No real root";

}

void two_root(int x1, int x2, int b, int a, int c)
{
    if((x1 == x2) && (b^2 - 4*a*c > 0))
        cout << "Two same roots x=" << x1;
}

void same_root(int x1, int x2)
{
    if (x1 != x2 )
    cout << "Two different roots x1=" << x1 << " , x2=" << x2;
}

int main() 
{
    int a, b, c, x1, x2, x;

    cin >> a >> b >> c;

    x1 = (-b + (sqrt(b*b - (4*a*c)))) / (2*a);
    x2 = (-b - (sqrt(b*b - (4*a*c)))) / (2*a);

    x = (b*b - 4*a*c);

    no_root(x);
    same_root(x1, x2);
    two_root(x1, x2, b, a, c);

    // if (x < 0)
    // cout << "No real root";

    // else if((x1 == x2) && (b^2 - 4*a*c > 0))
    // cout << "Two same roots x=" << x1;

    // else if (x1 != x2 )
    // cout << "Two different roots x1=" << x1 << " , x2=" << x2;
    
}