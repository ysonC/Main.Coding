#include <iostream>
#include <math.h>

using namespace std;

//求一元二次方程式 ax2+bx+c=0 的根 ==> (-b+-√b^2-4ac) / 2a
//Two different roots x1=?? , x2=??
//Two same roots x=??
//No real root
//PS: 答案均為整數，若有兩個根則大者在前

int main()
{
    int a, b, c, x1, x2, x;

    cin >> a >> b >> c;

    // cout << a << endl; 
    // cout << b << endl;
    // cout << c << endl;
    // int s = sqrt(b*b - (4*a*c));
    // cout << s << endl;

    x1 = (-b + (sqrt(b*b - (4*a*c)))) / (2*a);
    x2 = (-b - (sqrt(b*b - (4*a*c)))) / (2*a);

    x = (b*b - 4*a*c);

    if (x < 0)
    cout << "No real root";

    else if((x1 == x2) && (b^2 - 4*a*c > 0))
    cout << "Two same roots x=" << x1;

    else if (x1 != x2 )
    cout << "Two different roots x1=" << x1 << " , x2=" << x2;
    
}
