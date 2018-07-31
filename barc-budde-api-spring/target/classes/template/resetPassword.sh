#!/bin/sh


# create user
#username:$1
#newPassword:$2




# Does User exist?
id $1 &> /dev/null
if [ $? -eq 0 ]; then
echo "$1 exists... changing password."
else
echo "$1 does not exist - Password could not be updated for $1"; exit 
fi

# Change password
echo "$1:$2" | sudo chpasswd


