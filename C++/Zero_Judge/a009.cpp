#include <iostream>

using namespace std;

int main()
{
// ascii -7;
// "1"(49) --> "*"(42)

    char str [1000];
    char final;
    int i, totalchar, a;
    totalchar = 0;
    
    cout << "Please enter the string for count characters\n";

    cin.getline(str,1000);

    for (i=0; str[i] != '\0'; i++)
    {    
        totalchar++;   
    }

    cout<<"The total characters of the given string= "<<totalchar;
    
    getchar();
    
    for (a = 0; a != totalchar; a++)
    {
        int ans = str[a];
        int add = ans + (-7);
        char final = add;
        cout << final;
    }

    cout << "\n";

    system("pause");
    
    return 0;
}
