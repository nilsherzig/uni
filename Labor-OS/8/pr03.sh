[ ! -e "$1" ] && exit
while read c
do
    P1=$(cat $1)
    echo "$$ receive from $P1: $c"
    case $c in
        200|300)
        kill -STOP $P1
        sleep 10
        kill -CONT $P1 ;;
        400) kill -1 $P1 ;;
        500) kill $P1 ;;
        *) echo "$c = no match" ;;
    esac
    if [ $c -gt 600 ]
    then
        kill -9 $P1
    fi
done
