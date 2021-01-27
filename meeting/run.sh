#!/bin/bash

case "$1" in
start)
   nohup java -classpath ".:./lib/*:./classes" -Dspring.profiles.active=dev com.whut.basiccentre.BasiccentreApiApplication  >/opt/logs/occam-api/output.log 2>&1 &
   echo $!>./run.pid
   cat run.pid
   ;;
stop)
   kill `cat ./run.pid`
   rm ./run.pid
   ;;
restart)
   $0 stop
   $0 start
   ;;
status)
   if [ -e ./run.pid ]; then
      echo occam-api.sh is running, pid=`cat ./run.pid`
   else
      echo occam-api.sh is NOT running
      exit 1
   fi
   ;;
*)
   echo "Usage: $0 {start|stop|status|restart}"
esac

exit 0

