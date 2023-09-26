# Resource Registry Model

## Description 
The Resource Registry model is a defined schema used to support mapping of strategic airspace points to resource planning services.  The Resource Registry model exists to define the I/O contract between an application which implements this API and any requesting application. The API is also useful for automatic code generation using code generation tools.

The API is currently not used to define a server application.  It's primary use is to manage the data formats that would result from a resource registery.  This data syntax is followed in the creation of associated files used as input into applications which would have requested it.

More detailed information regarding the particular version of this model is available within the yaml file. 


### Version
The current version of this file can be found within the API yaml file on the version line.
Though the version is defined in the file, the artifact versions are delegated by the artifact pom files.  Because this file references an externally controlled file, their versioning my not coincide with the versioning used within the UAM subproject.

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
cd $REPO_BASE; mvn clean compile install -Prr-api

### Deploy Procedure
cd $REPO_BASE; mvn clean compile install deploy -Prr-api

## Installation Procedures
N/A

## Run Procedure
N/A


