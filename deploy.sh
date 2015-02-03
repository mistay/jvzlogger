#!/bin/bash

set -e

HOST="85.125.144.50"

WORKINGDIR=$1
if [ $WORKINGDIR = ""];
then
	WORKINGDIR="."
fi


if [ -f $WORKINGDIR/bin/jvzlogger.jar ];
then

	echo "mounting rw"
	echo "mount / -o remount,rw" | ssh root@$HOST

	echo "deleting on target: echo 'rm -Rf ~/jvzlogger.jar'  | ssh root@$HOST"
	echo "rm -Rf ~/jvzlogger.jar" | ssh root@$HOST

	echo "scp $WORKINGDIR/bin/jvzlogger.jar $WORKINGDIR/startjvzlogger.sh root@$HOST:/root/"
	scp $WORKINGDIR/bin/jvzlogger.jar $WORKINGDIR/startjvzlogger.sh root@$HOST:/root/

	#echo "killing all java processes ..."
	#echo "killall -9 java 2>/dev/null" | ssh root@$HOST
	
	
	echo "running (/root/startjvzlogger.sh)..."
	echo "/root/startjvzlogger.sh" | ssh root@$HOST

	echo "mounting ro"
	echo "mount / -o remount,ro" | ssh root@$HOST

fi

echo "done"

exit 0
