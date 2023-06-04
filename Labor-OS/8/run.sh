#!/usr/bin/env sh
set -xe
# setup 
rm /tmp/p1.pid || true
rm ~/pipe1 || true

mkfifo ~/pipe1

# start pr01.sh in background as unpriv user
./pr01.sh /tmp/p1.pid ~/pipe1 &

# start pr02.sh and pipe output into pr03.sh as root
# ./pr02.sh ~/pipe1 foobar | ./pr03.sh /tmp/p1.pid
