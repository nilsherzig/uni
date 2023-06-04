compile: 
	msp430-elf-gcc -fno-stack-protector -mmcu=msp430g2553 -o current -ggdb -O0 -g3 -gdwarf-2 eleonora.c

run: 
	sudo mspdebug tilib "prog current"

connect: 
	TERM=xterm sudo minicom 

all: 
	make compile
	make run
	make connect

debug: 
	make compile 
	sudo mspdebug tilib "prog current"
	sudo mspdebug tilib "gbd"
