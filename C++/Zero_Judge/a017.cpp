#include <iostream>
#include <sstream>

using namespace std;

int main()
{
    
    stringstream ss;
    int number  = 123456;
    ss << number; //把int型態變數寫入到stringstream

    cout << "int to string" <<endl;
    string convert_str;
    ss >>  convert_str;  //透過串流運算子寫到string類別即可

    cout << "number:" << number <<endl;
    cout << "convert to str type:" << convert_str <<endl;
    cout << "string to int" <<endl;

    string a;
    cin >> a;
    ss << a;
    int testnumber;
    ss >> testnumber;
    cout << testnumber;

}