#!/usr/bin/env sh
# takes clipboard content, removes spaces in front of lines and simulates a keyboard writing the modified text
# mainly used to get text into vpl
# i would recommend keybinding this script

set -xe
if [ "$#" -eq 1 ]; then
    text="$(cat $1 | sed 's/^ *//')"
else
    text="$(wl-paste | sed 's/^ *//')"
fi



echo "$text"

# if youre not using gnome, make sure your input is qwerty using another way
# gsettings set org.gnome.desktop.input-sources sources "[('xkb', 'en')]" || true
# 
# pkill ydotoold || true
# sleep 1
# ydotoold & 
# sleep 1
# ydotool key 29:1 30:1 30:0 29:0                 # select all 
# ydotool type -d 0 "$text"                       # replace with 
# ydotool key 42:1 109:1 109:0 42:0 14:1 14:0     # remove everything after last char (vpl auto backets f.ex.)
# 
# # change your input layout back
# gsettings set org.gnome.desktop.input-sources sources "[('xkb', 'de')]" || true
# 
# pkill ydotoold

sleep 2 
wtype -M ctrl a -m ctrl -P BACKSPACE -p BACKSPACE
wtype "$text"
wtype -M shift -P NEXT -p next -m shift -P backspace -p backspace
