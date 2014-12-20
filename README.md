jvzlogger
=========
java volkszaehler logger


logs every 1wire sensor into volkszaehler by adding magic uuid part 'f81d4fae-7dec-11d0-a7', e.g.
1wire sensor with id: 28-000006082d10 is uploaded to volkszaehler uuid f81d4fae-7dec-11d0-a728-000006082d10.

no configuration is any sensor required. they're all read and uploaded.

installation
============
compile src file with eclipse or command line, copy binaries onto target host. start with

cd jvzlogger/bin
screen -d -m java main.Main


configuration
=============
config file: /etc/jvzlogger.conf (cannot be changed currently)

Samplersleeptimeinseconds=60
LOGFILE=/var/log/jvzlogger.log
OnewireDir=/sys/bus/w1/devices
ENABLELOG=false
BASEURL=http://vz.example.com/middleware.php/data/
