#include<iostream>
#include<iomanip>
#include<math.h>
using namespace std;

int main ()
{
    // (y1-y2)/(x1-x2)
    double x1,x2,y1,y2;
    char temp1,temp2,temp3;
    double p1,p2, ans;
    double a, c;

    cin >> temp1 >> x1 >> temp2 >> y1 >> temp3;
    cin >> temp1 >> x2 >> temp2 >> y2 >> temp3;
    cin >> temp1 >> p1 >> temp2 >> p2 >> temp3;

    a = (y1-y2)/(x1-x2);  // a = slop

    c = (y1 - a * x1);

    //y = mx + t
    // t = y - mx  // t == c
    
    // mx - y + t = 0
    // ax + by + c = 0

    ans = ((a) * p1 + (-1) * p2 + (c)) / (sqrt((a*a) + 1));
    
    // cout.precision(2);
    // cout << ans * ans << endl;

    cout << fixed;
    cout << setprecision(2);
    cout << ans * ans << endl;;
    
    //printf("%.2f", ans*ans);


    
}