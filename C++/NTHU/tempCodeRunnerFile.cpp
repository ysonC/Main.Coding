#include <iostream>
#include <cstring>

using namespace std;

// function :: oneWrong, oneSwitch, oneMissing, oneMore


// int checkRest(char right[], char wrong[],int rightLen, int wrongLen)
// {
//     int larger = abs(rightLen - wrongLen);
//     for(int i = 0; i < larger; i++)
//     {

//     }

// }

int oneMissing(char right[], char wrong[], int rightLen, int wrongLen)
{
    int missing;
    int cnt = 0;
    missing = rightLen - wrongLen;
    //cout << missing << endl;
    
    if (missing == 1)
    {
        for (int i = 0; i < rightLen; i++)
        {
            if (right[i] != wrong[i])
            {   
                for(int j = i+1; j < rightLen; j++)
                {
                    if (right[j] != wrong[j-1])
                    {
                        //cout << "More than one wrong" << endl;
                        cnt += 2;
                    }
                }
            }
        }
        //cout << "Only one missing or extra" << endl;
        cnt++;
    }

    else if (missing == -1)
    {
        for (int i = 0; i < wrongLen; i++)
        {
            if (wrong[i] != right[i])
            {   
                for(int j = i+1; j < wrongLen; j++)
                {
                    if (wrong[j] != right[j-1])
                    {
                        //cout << "More than one wrong" << endl;
                        cnt += 2;
                    }
                }
            }
        }
        //cout << "Only one missing or extra" << endl;
        cnt++;
    }

    // else if (missing == 0)
    //     cout << "None missing or added" << endl;

    return cnt;
}

// void oneWrong(char right[], char wrong[], int rightLen, int wrongLen)
// {
//     int missing;
//     int cnt;
//     cnt = 0;
//     missing = rightLen - wrongLen;
//     if (missing == 0)
//     {
//         for(int i = 0; i < rightLen; i++)
//         {
//             if (right[i] != wrong[i])
//             {
//                 cnt++;
//             }
//         }
//     }
//     if (cnt == 1)
//         cout << "one wrong" << endl;
//     else if (cnt == 0)
//         cout << "no wrong" << endl;
//     else
//         cout << "more than one wrong" << endl;
// }

int oneSwitch(char right[], char wrong[], int rightLen, int wrongLen)
{
    int missing;
    int cnt = 0;
    missing = rightLen - wrongLen;
    if (missing == 0)
    {
        for(int i = 0; i < rightLen; i++)
        {
            if (right[i] != wrong[i])
            {
                if (right[i] == wrong[i+1] && right[i+1] == wrong[i])
                {
                    //cout << "one switch" << endl;
                    i++;
                    cnt++;
                }
                else
                {
                    //cout << "one wrong" << endl;
                    cnt++;
                }

            }  
        }
    }
    // if (cnt == 1)
    //     cout << "only one switch or wrong" << endl;
    // else if (cnt == 0)
    //     cout << "None wrong" << endl;
    // else 
    //     cout << "More than one wrong" << endl;
    
    return cnt;
}
 
int addwhile()
{

    string input1;
    string input2;
    int checkMissing;
    int checkWrong;
    int checkYesOrNo;

    cin >> input1;
    cin >> input2;

    char right[input1.length()+1];
    strcpy (right, input1.c_str());
    char wrong[input2.length()+1];
    strcpy (wrong, input2.c_str());

    checkMissing = oneMissing(right,wrong,input1.length()+1,input2.length()+1);
    checkWrong = oneSwitch(right,wrong,input1.length()+1,input2.length()+1);
    checkYesOrNo = checkWrong + checkMissing;

    if (checkYesOrNo == 1)
        cout << "Yes" << endl;
    else 
        cout << "No" << endl;

    return 0;
    }

    int main()
    {
        int n;
        cin >> n;
        while(n--)
        {
            addwhile();
        }
    }

// int research()
// {   
//     string myWord = "myWord";
//     char myArray[myWord.size()+1];
//     strcpy(myArray, myWord.c_str());
// }