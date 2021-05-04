#include<iostream>
#include<math.h>
#include<string>

using namespace std;
//htisanaughtyboy ht
//abcabc abc

int cnt_final = 0;

void advanceFind(int start, string input, string key, int k)
{
    if (start < input.length())
    {
        for(int i = start; i < input.length(); i++)
        {
            if (input[i] == key[k])
            {   
                start++;
                advanceFind(start,input,key,k);
                if(k == key.length()-1) 
                    cnt_final++;
                k++;
                cout << key[k];
            }
        }
    }
    //need start point
                //start++;
}

void find(int start, string input, string key)
{
    cout << "\n" << start << endl;   
    int cnt = 0;
    for (int i = start, j = 0; i < input.length(); i++)
    {
        if (input[i] ==key[j])
        {
            cout << key[j] << " ";
            if (j == key.length() - 1) // == last 
            {
                //cout << key[j];
                cnt_final++;
                cout << key[j] << " : " <<cnt_final << " ";
                j--;
            }
            j++;
        }
    }
}

int main()
{
    static string input, store, newstring;
    string key = "";
    int cnt = 0;
    int start = 0;
    char match [10];
    cin >> input;
    cin >> key;
    //cout << "key.length() = " << key.length() << endl;

    int k = 0;
    for (int i = 0, j = 0; i < input.length(); i++)
    {
        if (input[i] == key[0])
        {
            //find(start, input, key);
            //j++;
            advanceFind(start,input,key,k);
        }
        start++;
    }
    //cout << "ans = " << cnt_final << endl;
    cout << cnt_final  << endl;
}