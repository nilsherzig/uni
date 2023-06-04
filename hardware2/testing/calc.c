#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
    char input[] = "123+543=";
    char *token;
    int num1, num2;

    // Splitting the string based on '+'
    token = strtok(input, "+");
    if (token != NULL)
    {
        num1 = atoi(token);
        token = strtok(NULL, "=");
        if (token != NULL)
        {
            num2 = atoi(token);

            printf("First number: %d\n", num1);
            printf("Second number: %d\n", num2);
        }
    }

    return 0;
}