//******************************************************************************
//   MSP430G2xx3 Demo UART
//
//   Description: UART_421a
//   ACLK = n/a, MCLK = SMCLK = 1MHz (DCO)
//
//                MSP430G2xx3
//             -----------------
//         /|\|              XIN|-
//          | |                 | n/a
//          --|RST          XOUT|-
//            |                 |
//            |     P1.2/UCA0TXD|--------------->
//            |                 | 9600 - 8N1       MAX3232 an PC oder Jumper
//            |     P1.1/UCA0RXD|<--------------
//            |                 |
//            |                 |
//
//  U. Creutzburg
//  HS-Stralsund.
//  Subversion $Id: UART_421.c 361 2018-09-10 07:55:06Z UweCreutzburg $
//******************************************************************************

#include <msp430.h>
#include "UART_421.h"

int main(void)
{
  WDTCTL = WDTPW + WDTHOLD;                 // Stop WDT

  // check for valid calibration data and set clock to 1MHz
  if (CALBC1_1MHZ==0xFF) while(1);         // If calibration constant erased do not load, trap CPU!!
  DCOCTL  = 0;                              // Select lowest DCOx and MODx settings
  BCSCTL1 = CALBC1_1MHZ;                    // Set DCO
  DCOCTL  = CALDCO_1MHZ;

  // configure port for UART-mode
  P1SEL   = XP1SEL_VAL;                     // P1.1 = RXD, P1.2=TXD
  P1SEL2  = XP1SEL2_VAL;                    // P1.1 = RXD, P1.2=TXD

  // configure UART-module 9600,8,n,1
  UCA0CTL1 |= UCSSEL_2;                     // SMCLK
  UCA0BR0   = XUCA0BR0_VAL;                 // 9600 @ 1MHz
  UCA0BR1   = XUCA0BR1_VAL;                 // 9600 @ 1MHz
  UCA0MCTL  = XUCA0MCTL_VAL;                // Modulation UCBRSx
  UCA0CTL1 &= ~UCSWRST;                     // **Initialize USCI state machine**

  while(1)
    {
    // wait for UART send/receive done
    while ( !XUCA0TX_BUFFER_READY );        // USCI_A0 TX buffer ready?
    while ( !XUCA0RX_BUFFER_READY );        // USCI_A0 RX buffer ready (may wait forever)?
    
    UCA0TXBUF = UCA0RXBUF-XASCIIUP2LO;       // start process, TX a character
    }
}
