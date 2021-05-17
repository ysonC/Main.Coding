     for(int i = start; i < input.length(); i++)
        {
            //start++;
            cout << "start = " << start << endl;
            cout << input[i] << " ";
            if(input[i] == key[j])
            {
                cout << key[j] <<endl;
                if (j == key.size()-1)
                {
                    cnt_final++;
                    return;
                }
                j++;
                find(input, key,start, j);
                start = i;
            }
        }