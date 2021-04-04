#include <iostream>

using namespace std;

int main()
{
   
    int i, t;
    int a, b, c, d, e;
    int add, mul;

    cin >> t;
    cin >> a >> b >> c >> d;

    if( t > 20 || t < 0)
    return (1);

    else
    {
        if (b - a == d - c)
        {
            add = b - a;
            e = d + add;
        }

        else if (b/a == d/c)
        {
            mul = d/c;
            e = mul * d;
        }

    cout << a << " " << b << " " << c << " " << d << " " << e << endl;
    }
    

}
