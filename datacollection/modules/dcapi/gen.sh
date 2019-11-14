#!/usr/bin/env bash

set -x
set -o errexit
set -o pipefail

RLSTAG=$1

find ./src/main/java/gov/nasa/uamdc -name *Api.java -exec rm {} \;
find ./src/main/java/gov/nasa/uamdc/model -name *.java -exec rm {} \;


#CODEGEN=./lib/swagger-codegen-cli-3.0.0.jar
CODEGEN=./lib/swagger-codegen-cli-3.0.13.jar

GENONLY=" -Dmodels -Dapis -DmodelDocs=false -DapiDocs=false"


GENERATE="java  $GENONLY -jar $CODEGEN generate  -l spring --config codegen_config.json"

$GENERATE -i ../../openapi/v3/api/api-uam-ussexchange.yaml


exit
