[ $# != 2 ] && exit
trap 'c=20' 1
trap 'c=10' 2 15

echo $$ > $1

out=/dev/stdout

[ -p "$2" ] && out=$2

for((c=20;c>15;c++))
do 
    sleep 0.01
    echo "$$ send: $c"
    echo $c > $out
done

echo "normal exit ..."
