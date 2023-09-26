# FIMS Authorization Server (FIMS-Authz) with Signature Authentication

## Description 
The FIMS-Authz API exists to define the I/O contract between an application which implements this API and any requesting application. The API is also useful for automatic code generation using code generation tools.

More detailed information regarding the particular version of this API is available within the resource planning service API yaml file. 

This API resides here https://github.com/nasa/utm-apis/tree/1.0.0-uam/fimsauthz-api

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
cd $REPO_BASE; mvn clean compile install -Pfims-az-api

### Deploy Procedure
cd $REPO_BASE; mvn clean compile install deploy -Pfims-az-api

## Installation Procedures
N/A

## Run Procedure
N/A
