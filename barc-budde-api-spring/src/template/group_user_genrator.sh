#!/bin/sh


# create user
#username:$1
#password:$2
#groupname:$3

 read -p  $3 
   if grep -q $3 /etc/group
    then
         echo "group exists"
    else
	 echo "group does not exists"
	 echo "creating group $3 ....."
         groupadd $3
    fi


if grep -Fxq "Subsystem sftp /usr/lib/openssh/sftp-server" /etc/ssh/sshd_config
    then
      sed -i "s/Subsystem sftp \/usr\/lib\/openssh\/sftp-server/#Subsystem sftp \/usr\/lib\/openssh\/sftp-server/" /etc/ssh/sshd_config
    else
	echo " Subsystem sftp /usr/lib/openssh/sftp-server not there"
	
       
    fi


echo "#enable sftp"

 if grep -Fxq "Subsystem sftp internal-sftp" /etc/ssh/sshd_config
    then
     	echo " Subsystem sftp internal-sftp already there"
    else
	echo "Subsystem sftp internal-sftp"  >> /etc/ssh/sshd_config
	
       
    fi



if grep -Fxq  "Match Group $3"  /etc/ssh/sshd_config

 then
     	echo "$3 group detail present"


    else

	echo "Match Group $3
   ChrootDirectory %h #set the home directory
   ForceCommand internal-sftp
   X11Forwarding no
   AllowTCPForwarding no
   PasswordAuthentication yes" >> /etc/ssh/sshd_config
	
       
    fi


 service ssh restart



sudo adduser $1 --gecos "First Last,RoomNumber,WorkPhone,HomePhone" --disabled-password
echo "$1:$2" | sudo chpasswd

# prevent ssh login & assign SFTP group
sudo usermod -g $3 $1
sudo usermod -s /bin/nologin $1

# chroot user (so they only see their directory after login)
sudo chown root:$1 /home/$1
sudo chmod 755 /home/$1

sudo mkdir /home/$1/files
sudo chown $1:$1 /home/$1/files
sudo chmod 755 /home/$1/files
