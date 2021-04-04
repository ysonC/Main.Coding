#include <iostream>
#include <cmath>

using namespace std;
//0000 ==> 00:00 a.m.
//1200  ==> 12:00 p.m.
// 0 ==> 48
// hr1 = convert(time[0])

int convert(int temp)
{
    int ans = temp - 48;
    temp = ans;
    return temp;
    
}

// void hours(int hr1, int hr2)
// {
//     if (hr1 == 1 && hr2 > 2)
//     {
//         hr1 -= 1;
//         hr2 -= 2;
//     }
//     else if (hr1 == 2)
//     {
//         if (hr2 < 2)
//         {
//             hr1 -= 2;
//             hr2 += 8;
//         }
//         else
//         {
//             hr1 -= 1;
//             hr2 -= 2;
//         }
//     }
// }

int main()
{
    char time[4];
    int temp, min1, min2, hr1, hr2;
    string dn;
    int hr, min;
    cin >> time;
    dn = "a";

    hr1 = convert(time[0]);
    hr2 = convert(time[1]);
    min1 = convert(time[2]);
    min2 = convert(time[3]);
    
    //cout << hr1 << hr2 << ":" << min1 << min2 << endl;
    
    if (hr1 == 1 && hr2 == 2)
    {
        dn = "p";
        hr1 -= 1;
        hr2 -= 2;
    }   

    if (hr1 == 1 && hr2 > 2)
    {
        hr1 -= 1;
        hr2 -= 2;
        dn = "p";
    }
    else if (hr1 == 2)
    {
        if (hr2 < 2)
        {
            hr1 -= 2;
            hr2 += 8; 
        }
        else
        {
            hr1 -= 1;
            hr2 -= 2;
        }
        dn = "p";
    }
    

    cout << hr1 << hr2 << ":" << min1 << min2 << " " << dn + ".m.";

}