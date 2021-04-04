#include<iostream>
#include<cstdlib>

using namespace std;
//12.題目：輸入三個整數x,y,z，請把這三個數由小到大輸出。
//1.程序分析：我們想辦法把最小的數放到x上，先將x與y進行比較，如果x>y則將x與y的值進行交換，
//然後再用x與z進行比較，如果x>z則將x與z的值進行交換，這樣能使x最小

int main ()
{
    int x,y,z,tmp;
    cin >> x;
    cin >> y;
    cin >> z;

    for (int i = 0 ; i < 3; i++)//3???
    {
        if (x > y)
        {
            tmp = x;
            x = y;
            y = tmp;
        }
        else if (x > z)
        {
            tmp = x;
            x = z;
            z = tmp;
        }
        else if (y > z)
        {
            tmp = y;
            y = z;
            z = tmp;
        }
    }
    cout << "x = "<< x << endl;
    cout << "y = " << y << endl;
    cout << "z = " << z << endl;
}