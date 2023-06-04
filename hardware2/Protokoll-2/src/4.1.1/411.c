#include <msp430g2553.h>

int main(void)
{
  WDTCTL = WDTPW + WDTHOLD;

  if (CALBC1_1MHZ == 0xFF)
    while (1)
      ;
  DCOCTL = 0;
  BCSCTL1 = CALBC1_1MHZ;
  DCOCTL = CALDCO_1MHZ;

  P1SEL = BIT2;
  P1SEL2 = BIT2;

  UCA0CTL1 |= UCSSEL_2;
  UCA0BR0 = 13;
  UCA0BR1 = 0;
  UCA0MCTL = UCOS16;
  UCA0CTL1 &= ~UCSWRST;

  while (1)
  {
    UCA0TXBUF = 'a';
    while (!(IFG2 & UCA0TXIFG))
      ;

    __delay_cycles(15000);
  }
}
