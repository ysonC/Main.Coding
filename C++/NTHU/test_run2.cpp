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
        cout << input[i] << "";
        if(input[i] == key[j] && j == key.size()-1)
        {
            cnt_final++;
            cout << "[i] = " << input[i] << endl;
        }
        else if(input[i] == key[j])
        {
            j++;
            start = i + 1;
            find(input, key, start, j);
        }
    }
    return;
}


int main()
{
    string input = ""; 
    string key = "";
    char store_end[10];
    int start;
    int j = 0;
    cin >> input;
    cin >> key;

    for (int i = 0; i< input.size(); i++)
    {
        if (input[i] == key[0])
        {
            start = i;
            find(input, key,start, j);
        }
    }
    
    cout << cnt_final << endl;
}