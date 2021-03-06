#!/bin/bash

set -e

WORKINGDIR=$1
if [ "$WORKINGDIR" == "" ];
then
	WORKINGDIR="."
fi
echo "WORKINGDIR: $WORKINGDIR"
cd $WORKINGDIR

if [ -d bin ];
then
	rm -Rf bin
fi

mkdir bin

cd src
javac main/Main.java -d ../bin/

cd ../bin
jar cvmf ../manifest.txt jvzlogger.jar */*.class */*/*.class

if [ -f "jvzlogger.jar" ];
then
	echo "successfully built $WORKINGDIR/bin/jvzlogger.jar"
fi

exit 0
