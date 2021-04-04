#include<iostream>
#include<cstdlib>

using namespace std;
// s ==> 115
// app ==>97 112 112 
int main()
{
    char string[100];
    int n;//!!!
    cin.getline(string,100); 

    for (int m = 0; string[m] != '\0'; m++)
        n++;   
    
    
    for(int i=0; i<100 && string[i]!='\0'; i++)
    {
        int a = int(string[i]);//?

        if (a == 115) 
        {
            cout << "there is a s" << endl;
            break;
        }

        else if  (a != 115 && i != (n-1)) //
        continue;
        
        else
            cout << "there is no s" << endl;
    }

    for(int k=0; k<100 && string[k]!='\0'; k++)
    {
        int b = int(string[k]);
        int c = int(string[k+1]);
        int d = int(string[k+2]);

        if (b == 97 && c == 112 && d == 112) 
        {
            cout << "there is a app" << endl;
            break;
        }

        else if ((b != 97 || c != 112 || d != 112 ) && k != (n-1))// when line 40 = false and k != the last #
         continue;

        else
        {
            cout << "there is no app" << endl;
            break;
        }
    }

    system("pause");
    return 0;
}