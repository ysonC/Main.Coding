#include<iostream>
#include<math.h>
using namespace std;

int main()
{
    char num[3];
    cin.getline(num,4);

    for (int i = 0; i < 3; i++)
    {
        switch (num[i])
        {
            case '1':
                cout << 'A';
                break;
            case '2':
                cout << 'B';
                break;
            case '3':
                cout << 'C';
                break;
            case '4':
                cout << 'D';
                break;
            case '5':
                cout << 'E';
                break;
            case '6':
                cout << 'F';
                break;
            case '7':
                cout << 'G';
                break;
            case '8':
                cout << 'H';
                break;
            case '9':
                cout << 'I';
                break;
        }
    }

    cout << "\n" << "other version : " << endl;
    //65 ==> A
    //73 ==> I
    //49 ==> 1
    //57 ==> 9
    for (int j = 0; j < 3; j++)
    {
        int b = num[j] + 16; 
        char prt = b;
        cout << prt;
    }


}