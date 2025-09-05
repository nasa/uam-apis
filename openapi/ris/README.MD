# Resource Information Service API

## Description 
The Resource Information Service API exists to define the I/O contract between an application which implements this API and any requesting application. The API is also useful for automatic code generation using code generation tools.

More detailed information regarding the particular version of this API is available within the Resource Information service API yaml file. 

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
cd $REPO_BASE; mvn clean compile install -Pri-api

### Deploy Procedure
cd $REPO_BASE; mvn clean compile install deploy -Pri-api

## Installation Procedures
N/A

## Run Procedure
N/A
