#include<iostream>
#include<math.h>
using namespace std;

int main()
{
    int input[100];
    int stored[100];
    int length, lvl;

    cin >> length;
    for (int i = 1; i <= length; i++)
    {
        cin >> input[i];
    }

    lvl = log2(length+1) -1;
    int max = pow(2,lvl + 1);
    //cout << "lvl = " << lvl << endl;

    for (int i = 1; i < max; i*=2) // i = 1, 2, 4
    {
        int number = pow(2,lvl);
        //cout << number << endl;
        //cout << "i = " << i << endl;
        int tmp = i;
        for (int j = 1; j <= pow(2,lvl); j++) // j = 1,2,3,4 
        {
            if (j == 1)
            {
                stored[tmp] = input [number];
                number++;
                tmp += i * 2; //tmp += pow(2,i);
                continue;
            }
            stored[tmp] = input[number];
            number++;
            tmp += i * 2; // tmp += pow(2,i);
        }
        lvl --;
    }
    for (int i = 1; i <= length; i++)
    {
       cout << stored[i] << " ";
    }
    cout << "\n";
}