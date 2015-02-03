#!/bin/bash

set -e

HOST="85.125.144.50"

WORKINGDIR=$1
if [ $WORKINGDIR = ""];
then
	WORKINGDIR="."
fi


if [ -f $WORKINGDIR/jvzlogger.jar ];
then

	echo "deleting on target: echo 'rm -Rf ~/jvzlogger.jar'  | ssh root@$HOST"
	echo "rm -Rf ~/jvzlogger.jar" | ssh root@$HOST

	echo "scp $WORKINGDIR/bin/jvzlogger.jar $WORKINGDIR/startvzlogger.sh root@$HOST:/root/"
	scp $WORKINGDIR/bin/jvzlogger.jar $WORKINGDIR/startvzlogger.sh root@$HOST:/root/

	echo "running (/root/startvzlogger.sh)..."
	echo "/root/startvzlogger.sh" | ssh root@$HOST

fi

exit 0
