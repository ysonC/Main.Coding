#include<iostream>
#include<cstdlib>

using namespace std;
//22.題目：輸入兩個正整數m和n，求其最大公因數和最小公倍數。 （必須用迴圈完成）
//1.程序分析：利用輾轉相除法。

int main ()
{
    int i, m, n, a, x, y, input1, input2, lcm;
    cout << "m = ";
    cin >> input1;
    cout << "n = ";
    cin >> input2;

    m = input1;
    n = input2;

    // for (i = 2; i <= m; i++)
    // {
    //     if (m % i == 0 && n %i == 0)
    //     {
    //     cout << i << endl;
    //     }
    //     else
    //     continue;
    // }

//最大公因數
    for (i = 0; i <= 10; i++)//10???
    {
        if (m > n )
            m -= n;
        else
            n -= m;
        /*
        if(m>n)
            m-=n;
        else 
            n-=m;

        */
    }
    a = m;
    cout << "最大公因數 = " << a << endl; 

//最小公倍數
    x = input1 / a;
    y = input2 / a;
    lcm = x * y * a;
    cout << "最小公倍數 = " << lcm;
}