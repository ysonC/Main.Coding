#include<iostream>
#include<iomanip>
#include<math.h>
using namespace std;
// 42 == *
// 43 == + 
// 45 == -
// 47 == /
// - 48 ==> int
int main()
{
    string input;
    cin >> input;
    int n = input.size() -1 ;
    int tmp = n;
    //cout <<n << endl;
    char flip[10];
    char store[10];
    char sym[10];
    double numb[10];
    for(int i = 0; i <n; i++)
    {
        store[i] = input[i];
        //cout <<  store[i] << " ";
    }
    //cout << "\n";
    for(int i = n -1, j = 0; i >= 0; i--,j++)
    {
        flip[j] = input[i];
        //cout << flip[j] << " ";
    }
    //cout << "\n";
    for(int i = 0, j = 0; i < n; i++)
    {
        
        if (flip[i] < 48)
        {
            sym[j] = flip[i];
            //cout << sym[j] << " ";
            j++;
        }
    }
    //cout << "\n";
    for(int i = 0, j = 0; i < n; i++)
    {   
        if (flip[i] > 47)
        {
            numb[j] = flip[i] - 48;
            //cout << numb[j] << " ";
            j++;
        }
    }
    //cout << "\n";
    for(int i = 0, j = 0; i < n; i++)
    {
        if (sym[i] == 43)
        {
            numb[j+1] = numb[j]+numb[j+1];
            //cout << numb[j+1] << endl;
            j++;
            continue;
        }
        else if (sym[i] == 45)
        {
            numb[j+1] = numb[j+1] - numb[j];
            //cout << numb[j+1] << endl;
            j++;
            continue;
        }
        else if (sym[i] == 42)
        {
            numb[j+1] = numb[j] * numb[j+1];
            //cout << numb[j+1] << endl;
            j++;
            continue;
        }
        else if (sym[i] == 47)
        {
            numb[j+1] = numb[j+1] / numb[j];
            //cout << numb[j+1] << endl;
            j++;
            continue;
        }
        cout<<fixed<<setprecision(3)<<numb[j];

        // cout.setf(ios::fixed,ios::floatfield);//???
        // cout.precision(3);/4*2+13
        // cout << numb[j];
        break;
    }
}