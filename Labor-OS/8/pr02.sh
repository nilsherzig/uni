[ -z "$2" ] && exit
if [ -p "$1" ]
then

    a="-E 00|25|50|75"
    b="$2"
    loop=1

    while [ $loop -eq 1 ]
    do
        grep $a $1 | grep -v $b
    done
else
    echo "no pipe ..."
fi
