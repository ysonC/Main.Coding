#include<iostream>
#include<cstdlib>

using namespace std;
//18.題目：判斷101-200之間有多少個質數，並輸出所有質數。 （必須用迴圈完成）
//1.程序分析：判斷質數的方法：用一個數分別去除2到sqrt(這個數)，如果能被整除，則表明此數不是質數，反之是質數。

int main()
{
    int i, a, n;
    
    for (a = 101; a <= 200; a++)
    {
        for (i = 2; i <= a; i++ )
            {
                if ((a%i == 0) && a != i)
                {  
                    cout << a << " = ";
                    cout << "no\n";
                    break;
                }   

                else if (i == a)
                {
                    cout << a << " = ";
                    cout << "yes\n";
                    n++;
                    break;
                }
            
                else if (a%i != 0)continue;
            } 
    }

    cout << "Total prime # = " << n;
}