#include<iostream>
#include<cstdlib>

using namespace std;
//23.題目：一個數如果恰好等於它的因子之和，這個數就稱為「完美數(Perfect Number)」。例如6=1＋2＋3.編程
//找出1000以內的所有完美數(Perfect Number)。
int main()
{
    int i, j, pf, max, min; // pf == perfect number

    cout << "Input for the range:" << endl;
    cout << "Min : ";
    cin >> min;
    cout << "Max : ";
    cin >> max;

    pf = 0;

    for (j = min; j <= max; j++)
    {
        for (i = 2; i <= j; i++)
        {
            if (j % i == 0 && j != i)
            {
                pf += i; // pf = pf + i
            }
            else
                continue;
        }

        pf += 1; // +1 == every (1 * )

        if (pf == j)
        {
            cout << j << " = Perfect number" << endl;
        }

        pf = 0;
    }


}