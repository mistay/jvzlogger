#!/bin/bash

set -e

#HOST="rpi01.langhofer.net"
HOST="10.0.10.98"

WORKINGDIR=$1
cd $WORKINGDIR

if [ -d bin ];
then
	rm -Rf bin
fi

mkdir bin

cd src
javac main/Main.java -d ../bin/
cd ../bin
jar cvmf ../manifest.txt jheating.jar */*.class

echo "deleting on target: echo 'rm -Rf ~/jheating.jar'  | ssh root@$HOST"
echo "rm -Rf ~/jheating.jar" | ssh root@$HOST

echo "scp $WORKINGDIR/bin/jheating.jar $WORKINGDIR/startheating.sh root@$HOST:/root/"
scp $WORKINGDIR/bin/jheating.jar $WORKINGDIR/startheating.sh root@$HOST:/root/

echo "running (/root/startheating.sh)..."
echo "/root/startheating.sh" | ssh root@$HOST

exit 0
