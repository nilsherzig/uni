# Protokoll 2

> Code files can also be found at [src](./src)

## 4 Experiment

### 4.1.1 Tasks

a) Write a C Program ...

c program: 

```c
//******************************************************************************
//   MSP430G2xx3 Demo UART
//
//   Description: UART_411a
//   ACLK = 32768 (virtual lab: n/a) , MCLK = SMCLK = 1MHz
//
//                MSP430G2xx3
//             -----------------
//         /|\|              XIN|-|
//          | |                 | =  32678 Hz (Virtual Lab: n/a)
//          --|RST          XOUT|-|
//            |                 |
//            |     P1.2/UCA0TXD|--------------->
//            |                 | 1200 - 8N1     normal
//            |                 | 4800 - 8N1     virtual
//            |                 |
//
//  U. Creutzburg
//  HS-Stralsund.
//  Subversion $Id: UART_411.c 530 2022-05-21 10:54:48Z UweCreutzburg $
//******************************************************************************

#include "UART_411.h"
#include <msp430.h>

int main(void) {
  WDTCTL = WDTPW + WDTHOLD; // Stop WDT

  // check for valid calibration data and set clock to 1MHz
  if (CALBC1_1MHZ == 0xFF)
    while (1)
      ;       // If calibration constant erased do not load, trap CPU!!
  DCOCTL = 0; // Select lowest DCOx and MODx settings
  BCSCTL1 = CALBC1_1MHZ; // Set DCO
  DCOCTL = CALDCO_1MHZ;

  // configure port for UART-mode
  P1SEL = XP1SEL_VAL;   // P1.2=TXD
  P1SEL2 = XP1SEL2_VAL; // P1.2=TXD

  // configure uart0 for 9600 Baud, 8 Bit, no parity, 1 stop bit
  UCA0CTL1 |= UCSSEL_2; // SMCLK
  UCA0BR0 = 104;        // 1MHz 9600
  UCA0BR1 = 0;          // 1MHz 9600
  UCA0MCTL = UCBRS_1;   // Modulation UCBRSx = 1
  UCA0CTL1 &= ~UCSWRST; // **Initialize USCI state machine**

  while (1) {
    UCA0TXBUF = 'a'; // send a
    while (!(XUCA0TX_BUFFER_READY))
      ;
    
    UCA0TXBUF = 'b'; // send a
    while (!(XUCA0TX_BUFFER_READY))
      ;

    __delay_cycles(15000);
  }
}
```


needed header file:

```c
//  Subversion $Id: UART_411.h 434 2020-05-03 19:48:17Z UweCreutzburg $
#ifndef _UART_411_h_
#define _UART_411_h_




#define XP1SEL_VAL (BIT2)
#define XP1SEL2_VAL (BIT2)

#define XUCA0CTL1_VAL (UCSSEL_2)

// 1200
//#define XUCA0BR0_VAL (52)
//#define XUCA0BR1_VAL (0)
//#define XUCA0MCTL_VAL (UCBRF_1 + UCBRS_0 + UCOS16)

// 4800
#define XUCA0BR0_VAL (13)
#define XUCA0BR1_VAL (0)
#define XUCA0MCTL_VAL (UCBRF_0 + UCBRS_0 + UCOS16)

#define XUCA0TX_BUFFER_READY (IFG2 & UCA0TXIFG)

#endif
```

Makefile using msp430-elf-gcc patch on fedora 38: 

```make
compile: 
	msp430-elf-gcc -mmcu=msp430g2553 -o current UART_411.c

run: 
	sudo mspdebug tilib "prog current" 

connect: 
	TERM=xterm sudo screen /dev/ttyACM1 9600

all: 
	make compile
	make run
	make connect
```
