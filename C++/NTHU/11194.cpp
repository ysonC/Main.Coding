#include<iostream>
#include<math.h>
using namespace std;

//7 == 21
//1+1+1+1+1+1+1    ==> 1
//2+1+1+1+1+1      ==> (6!)/(5!)*(1!) = 6
//2+2+1+1+1        ==> (5!)/(2!)*(3!) = 10
//2+2+2+1          ==> (4!)/(3!)*(1!) = 4
int fac(int n)
{
    if(n > 1)
        return n * fac(n - 1);
    else
        return 1;
}

int fac_withstop(int n ,int stop) // 10! / 8! == 90; // work!!
{
    if(n > stop)
        return n * fac_withstop(n - 1, stop);

    else if (n == stop)
        return 1;
    else
        return stop;
}

int advanceFac(int a, int b) //fac(28 + 1) / (fac(28) * fac (1))
{
    int ans;
    if (a > b)
        return ans = fac_withstop((a+b), a) / fac(b);
    else
        return ans = fac_withstop((a+b), b) / fac(a);
}

int run(int nub)
{
//need : len of addition (n), number of 2 and 1 (two, one)
    float lvl = nub / 2;
    int cnt_two = 0;
    int ans = 1;
    for (int i = 0 ; i <= lvl ; i ++)
    {
        int cnt_one = 0;
        nub -=2;
        if (nub >= 0)
        {
            cnt_two++;
            //cout << "two == " << cnt_two << endl;
            int tmp = nub; 
            //cout << "one == ";
            for (int j = 0; tmp > 0; j ++)
            {
                tmp--;
                cnt_one++;
                //cout << cnt_one << ", ";
            }
            //cout <<"\n";
            //ans +=  (fac(cnt_one + cnt_two))/((fac(cnt_two))*(fac(cnt_one)));
            ans += advanceFac(cnt_one,cnt_two);
            //cout << "ans == " << ans << endl;
        }
        else break;
    }
    return ans;
}

int main()
{
    int numberOfTestCase, nub;
    int i = 0;
    cin >> numberOfTestCase;
    int tmp = numberOfTestCase;
    int store [numberOfTestCase];
    while(tmp--)
    {
        cin >> nub;
        store[i] = run(nub);
        i++;
    }
    for(int i = 0; i < numberOfTestCase; i++)
    {
        cout << store[i] << endl;
    }
}