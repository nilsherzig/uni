#!/usr/bin/env sh
set -xe
./pr02.sh ~/pipe1 "-E 200|300|400" | ./pr03.sh /tmp/p1.pid
