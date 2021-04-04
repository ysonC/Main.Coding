#include <iostream>
#include <cstring>

using namespace std;

int main()
{
    string myWord = "myWord";
    char myArray[myWord.size()+1];
    strcpy(myArray, myWord.c_str());
    cout << myWord.size() << endl;
    cout << myWord.length() << endl;
}