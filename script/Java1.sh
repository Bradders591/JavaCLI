#!/bin/bash

#set -x
export JAVACMD=`which java`
export CLASSPATH=target/__artifact_id__-__version__-jar-with-dependencies.jar

if [ "$1" != "" ]; then
  if [ "$1" = "-v" ]; then
    echo "__artifact_id__  __version__ __build_number__  __timestamp__"
    exit
  fi
fi

exec ${JAVACMD} -classpath ${CLASSPATH} -Duser.language=en -Duser.region=GB __group_id__.__artifact_id__ ${1+"$@"}
