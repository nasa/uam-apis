# Discovery Synchronization Service and Provider of Services UAM API

## Description 
The Discover Sychronization Service (DSS) and Provider of Services UAM (PSU) API exist to define the contract between an application which implements this API and any requesting application.  The API is useful for code generation using automatic code generation tools.

This repository contains the working copy of the PSU-DSS and PSU-PSU API.

The API available for external participants is in the front facing git repository here:
- https://github.com/nasa/uam-apis/blob/x4/openapi/psu/psu_api.yml
- https://github.com/nasa/uam-apis/blob/x4/openapi/psu/dss_api.yml

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
cd $REPO_BASE; mvn clean compile install -Pdss-api
cd $REPO_BASE; mvn clean compile install -Ppsu-api

### Deploy Procedure
cd $REPO_BASE; mvn clean compile install deploy -Pdss-api
cd $REPO_BASE; mvn clean compile install deploy -Ppsu-api

## Installation Procedures
N/A

## Run Procedure
N/A
