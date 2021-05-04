#include<iostream>
#include<math.h>
#include<string>

using namespace std;
//htisanaughtyboy ht
//abcabc abc

int start = 0;
int cnt_final = 0;
void find (string input, string key, int start, int j)
{
    if (start < input.length())
    {
        //cout << start << endl;
        for(int i = start; i < input.length(); i ++)
        {
            if (j == key.length() - 1)
            {
                cnt_final++;
            }
            if(input[i] == key[j])
            {
                cout << key[j] << " ";
                start = i;
                j++;
                find(input, key, start,j);
            }
        }
    }
}

int main()
{
    string input, key;
    cin >> input >> key;
    int j = 0;
    find(input, key, start,j);
    cout << cnt_final << endl;
}