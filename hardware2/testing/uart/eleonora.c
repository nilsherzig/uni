#include <msp430g2553.h>

int main()
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
  UCA0MCTL = UCBRS_0;
  UCA0CTL1 &= ~UCSWRST;

  for (;;)
  {
    while (!(IFG2 & UCA0RXIFG))
      ;
    while (!(IFG2 & UCA0TXIFG))
      ;
    UCA0TXBUF = UCA0RXBUF;
  }
}
