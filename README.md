jvzlogger
=========
java volkszaehler logger


logs every 1wire sensor into volkszaehler by adding magic uuid part 'f81d4fae-7dec-11d0-a7', e.g.
1wire sensor with id: 28-000006082d10 is uploaded to volkszaehler uuid f81d4fae-7dec-11d0-a728-000006082d10.

no configuration is any sensor required. they're all read and uploaded.

installation
============
compile src file with eclipse or command line, copy binaries onto target host. start with

cd jvzlogger
./starjvzlogger.sh

build
=====
/path/to/jvzlogger $ ls
README.md		bin			build.sh		manifest.txt		src			startjvzlogger.sh
/path/to/jvzlogger $ ./build.sh 
WORKINGDIR: .
Manifest wurde hinzugef?gt.
Hinzuf?gen von: config/Config.class (ein = 2004) (aus = 1139) (komprimiert 43 %)
Hinzuf?gen von: helpers/Easyfile.class (ein = 1434) (aus = 791) (komprimiert 44 %)
Hinzuf?gen von: helpers/Easyhttp.class (ein = 1548) (aus = 897) (komprimiert 42 %)
Hinzuf?gen von: helpers/Volkszaehler.class (ein = 654) (aus = 396) (komprimiert 39 %)
Hinzuf?gen von: log/Log.class (ein = 1194) (aus = 735) (komprimiert 38 %)
Hinzuf?gen von: main/Main.class (ein = 475) (aus = 341) (komprimiert 28 %)
Hinzuf?gen von: samplers/Sampler.class (ein = 2189) (aus = 1280) (komprimiert 41 %)
successfully built ./bin/jheating.jar



configuration
=============
config file: /etc/jvzlogger.conf (currently this path is hardcoded, so cannot be changed)

Samplersleeptimeinseconds=60
LOGFILE=/var/log/jvzlogger.log
OnewireDir=/sys/bus/w1/devices
ENABLELOG=false
BASEURL=http://vz.example.com/middleware.php/data/
