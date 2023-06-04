#include <msp430g2553.h>

#include <stdio.h>  // sprintf
#include <string.h> // strtok
#include <stdlib.h> // atoi

char inputCharArray[20];
int result;

void setup(void)
{
  WDTCTL = WDTPW + WDTHOLD;

  while (CALBC1_1MHZ == 0xFF)
    ;
  DCOCTL = 0;
  BCSCTL1 = CALBC1_1MHZ;
  DCOCTL = CALDCO_1MHZ;

  P1SEL = BIT1 + BIT2;
  P1SEL2 = BIT1 + BIT2;

  UCA0CTL1 = UCSWRST + UCSSEL_2;
  UCA0BR0 = 104;
  UCA0BR1 = 0;
  UCA0MCTL = UCBRS0;
  UCA0CTL1 &= ~UCSWRST;
}

void printNewLine()
{
  while (!(IFG2 & UCA0TXIFG))
    ;
  UCA0TXBUF = '\r';
  while (!(IFG2 & UCA0TXIFG))
    ;
  UCA0TXBUF = '\n';
}

void read()
{
  int ucContinue = 1;
  int ucCount = 0;

  while (ucContinue)
  {
    while (!(IFG2 & UCA0RXIFG))
      ;
    inputCharArray[ucCount] = UCA0RXBUF;

    while (!(IFG2 & UCA0TXIFG))
      ;
    UCA0TXBUF = inputCharArray[ucCount];

    ucContinue = (inputCharArray[ucCount] != '=');
    ucCount++;
    inputCharArray[ucCount] = 0;
  }
  printNewLine();
}

void compute()
{
  char *split;
  int num1, num2;

  split = strtok(inputCharArray, "+");
  if (split != NULL)
  {
    num1 = atoi(split);
    split = strtok(NULL, "=");
    if (split != NULL)
    {
      num2 = atoi(split);
    }
  }

  result = (num1 + num2);
}

void write()
{
  int ucContinue;
  int ucCount;

  char s[10];
  sprintf(s, "%d", result);

  ucCount = 0;
  ucContinue = (s[ucCount] != 0);
  while (ucContinue)
  {
    while (!(IFG2 & UCA0TXIFG))
      ;
    UCA0TXBUF = s[ucCount];
    ucCount++;
    ucContinue = (s[ucCount] != 0);
  }
  printNewLine();
}

int main()
{
  setup();
  for (;;)
  {
    read();
    compute();
    write();
  }
  return 0;
}
