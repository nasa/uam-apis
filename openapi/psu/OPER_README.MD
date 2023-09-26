# Internal Provider of Service UAM (PSU) API

## Description 
The Internal PSU API exists to define the I/O contract between an application which implements this API and any requesting application. The API is also useful for automatic code generation using code generation tools.

More detailed information regarding the particular version of this API is available within the API yaml file.

The following files make up the internal PSU API:
- ./ddp-async-api.yml ***(inactive)***
- ./ddp-rest-api.yml ***(inactive)***
- ./uam-operator-streaming-api.yml ***(inactive)***
- ./uam_operator_api.yml

### Version
The current version of this file can be found within the API yaml file on the version line.

## Requirements

### Hardware
N/A 

### Software 
This API is used for I/O requirement contracts and the creation of code using auto code generation tools.

## Build
- OS
  - Linux
  - MacOS
- Maven
- OpenAPI Generator CLI

### Build Procedure
cd $REPO_BASE; mvn clean compile install -Puam-operator-api

### Deploy Procedure
cd $REPO_BASE; mvn clean compile install deploy -Puam-operator-api

## Installation Procedures
N/A

## Run Procedure
N/A

