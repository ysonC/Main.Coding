#include<iostream>
#include<math.h>
#include<string>

using namespace std;
//htisanaughtyboy ht
//abcabc abc

int cnt_final = 0;
void find (string input, string key, int start, int j)
{
    for(int i = start; i < input.length(); i++)
    {
        //start++;
        cout << input[i] << " ";
        start++;
        cout << "start = " << start << endl;
        if(input[i] == key[j])
        {
            cout << "key = " << key[j] <<endl;
            cout << endl;
            if (j == key.size()-1)
            {
                cnt_final++;
                break;
            }
            j++;
            find(input, key,start, j);
        }
    }
    return;
}

int main()
{
    string input = "", key;
    int start = 0, j = 0;
    cin >> input;
    cin >> key;

    find(input, key, start, j);
    cout << cnt_final << endl;
    //cout << key.size() << endl;
}