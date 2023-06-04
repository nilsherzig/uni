task411: 
	make compile dirname="./4.1.1" filename="411.c" outname="411.elf"
	make load filename="411.elf"
	make connect baud="4800"

task421: 
	make compile dirname="./4.2.1" filename="421.c" outname="421.elf"
	make load filename="421.elf"
	# make connect baud="9600"

task431: 
	make compile dirname="./4.3.1" filename="431.c" outname="431.elf"
	make load filename="431.elf"
	# make connect baud="9600"

compile:
	cd $(dirname) && msp430-elf-gcc -mmcu=msp430g2553  -Wall -Werror -g $(filename) -o ../build/$(outname)

load: 
	sudo mspdebug tilib "prog ./build/$(filename)"

connect: 
	TERM=xterm sudo minicom 