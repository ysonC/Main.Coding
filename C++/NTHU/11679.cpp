#include<iostream>
#include<math.h>
using namespace std;

//4  2 6  1 3 5 7 
//1  2 3  4 5 6 7

//8     4 12     2 6 10 14      1 3 5 7 9 11 13 15
//1 2 3 4 5 6 7 8 9 10 11 12 13 14 15

//0 1 2 3 4 5 6
//

int main()
{
    char input[100];
    char stored[100];
    int length, lvl;

    cin >> length;
    int mid = (length-1) / 2;
    cin >> input;

    lvl = log2(length+1) -1;

//2^3 2^2  2^1
//4  2 6  1 3 5 7 
//1  2 3  4 5 6 7
    int number;
    int arrayN = 1;
    int cnt = 2;

    /**
    for (int i = 1; i <= pow(2,lvl); i*=2) // j = 1, 2, 4
    {
        number = pow(2,lvl);
        cout << number << endl;
        for (int j = 1; j > i; j++) // j = 1,2,3,4 
        {
            stored[arrayN] = input[number];
            cout << arrayN << ""; 
            arrayN += cnt;
            number++;
        }
        arrayN = 0;
        arrayN += cnt;
        cnt++;

        number /= 2;
    }
    **/

    for (int i = pow(2,lvl); lvl >= 0; i/=2) // i = 4 , 2, 1
    {
        //cout << "i = " << i << endl;
        //cout << "lvl = " << lvl << endl;
        number = i - 1;
        for (int j = 1; j > i; j++) // j = 1,2,3,4 
        {
            stored[arrayN] = input[number];
            cout << arrayN << ""; 
            arrayN += cnt;
            number++;
        }
        arrayN = 0;
        arrayN += cnt;
        cnt++;

        lvl--;
    }

    cout << "\n";
    cout << stored << endl;
}

// int func(int a, int b, int c1 , int c2)
// {
//     char redo[10];
//     char dothis[10] = {4,2,6,1,3,5,7};
//     int mid = 3;
//     int lvl = 2;
//     for (int i = 0; i < 100; i++)
//     {
//         if (i == 0)
//             redo[mid - lvl] = dothis[i];
        
//     }
// }
// int main()
// {
//     string input;
//     string stored;
//     int length, lvl;
//     int a,b;

//     cin >> length;
//     int mid = (length-1) / 2;
//     cin >> input;

//     lvl = log2(length+1) -1;
//     cout << "lvl = " << lvl << endl;
//     cout << "mid = " << mid << endl;

//     // stored[0] = input[mid];

//     int j = 0;



//     for (int i = 1; i < input.length(); i = pow(2,i))
//     {
//         for (int j; i <= i; j ++)
//         {
//             if (j == 0)
//                 stored[j] = input[mid];
//             else if (j == 1)
//                 stored[j] = input[mid -= lvl];
//             else if (j % 2 == 0)
//                 stored[j] = input[mid += lvl];
//             else
//                 stored[j] = input[mid -= lvl];
//         }
//         lvl--;
//     }

//     cout << stored << endl;
//}