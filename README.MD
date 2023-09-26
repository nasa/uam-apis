<h1 align="center"> UAM API  </h1>

[![version](https://img.shields.io/badge/version-2.0.0-yellow.svg?style=flat-square)](https://img.shields.io)

## Table of Contents

- [Introduction](#introduction)
- [Software](#software)
- [Downloads](#downloads)
- [Feedback](#feedback)
- [Contributors](#contributors)
- [Acknowledgments](#acknowledgments)

## Introduction

This repository stores APIs and defines functionality for API auto code generation.  All API definition in their YAML form are stored as the following:
- [External](./external/)
  - APIs which would be known to all players within the federated PSU network
- [Internal](./internal/)
  - APIs which are internal to NASA's implementation and execution of a PSU and execution.   

Overview description of APIs can be found in OVERVIEW.MD

The list below references the directories for the various APIs within this repository.  Each section has a README.MD file specific to the API.

__Internal__
* ETA Generator ([etag](./internal/etag/))
* Operations Planning Service ([ops](./internal/ops/))
* Provider of Service UAM ([psu](./internal/psu/))
* UAM Constraints ([uam-constraints](./internal/uam-constraints/))
  
__External__
* Airspace Authorization ([aa](./external/aa/))
* Airspace Structure Definition Service ([asds](./external/asds/))
* Constraint Information Service ([cis](./external/cis/))
* Data Collection ([data](./external/data/))
* FAA Industry Data Exchange Protocol ([fidxp](./external/fidxp/))
* FIMS Authorization ([fims-authz](./external/fims-authz/))
* Provider of Service UAM ([psu](./external/psu/))
* Resource Planning Service ([rps](./external/rps/))
* Resource Registry ([rr](./external/rr/))
* Timeline Data Provider ([tdp](./external/tdp/))
* XTGUI ([xtgui](./external/xtgui/))

## Software

### Version

The version associated with this software commit can be determined through multiple ways:

* Code Versions
  * Check the software version by examining the artifact version information in the [pom.xml](./pom.xml).
* Artifact
  * Find the software *.jar file and un-compress the jar.  The software version will be found in the META-INF/MANIFEST.MF file.

### Requirements

- Hardware
[![Intel CPU Machine](https://img.shields.io/badge/intel-i7-green.svg?style=flat-square)](https://img.shields.io)
-  Operating System
[![MacOS Ventura 13.4](https://img.shields.io/badge/macos-Ventura_13.4-green.svg?style=flat-square)](https://img.shields.io)
[![Redhat Release 8.8 (Ootpa)](https://img.shields.io/badge/redhat-Ootpa_8.8-green.svg?style=flat-square)](https://img.shields.io)
[![Oracle Linux Server release 8.8](https://img.shields.io/badge/oracle-Linux_Server_8.8-green.svg?style=flat-square)](https://img.shields.io)
- Compiler
[![Java version 11.0.9](https://img.shields.io/badge/java-11.0.9-green.svg?style=flat-square)](https://img.shields.io)
- Build
[![Maven 3.8.5](https://img.shields.io/badge/maven-3.8.5-green.svg?style=flat-square)](https://img.shields.io)

### Building the Software
Run the following command from the repository base to build the software.  
  
`mvn clean compile install -s <settings.xml>`

## Downloads
<p align="left">
Downloads of the code and repositories are available through Bitbucket.
  <a href="https://atmjira.arc.nasa.gov:7443/stash">
    <img alt="Bitbucket" title="Bitbucket" src="https://wac-cdn.atlassian.com/assets/img/favicons/bitbucket/favicon-32x32.png" width="30">
  </a>
  <br>
Downloads of the software artifacts are available through the JFrog Artifactory.
  <a href="https://b52.arc.nasa.gov/ui/packages">
    <img alt="Download from JFrog Artifactory" title="JFrog Artifactory" src="https://speedmedia.jfrog.com/08612fe1-9391-4cf3-ac1a-6dd49c36b276/https://media.jfrog.com/wp-content/uploads/2021/12/29113553/jfrog-logo-2022.svg/w_1024" width="30">
  </a>
</p>

### Access
Access to this code base is controlled by the project software manager.  Contact the project software manager for consent of any access and distribution of this software.

## Feedback

Feel free to contact our product owner [Hanbong Lee](mailto:hanbong.lee@nasa.gov) or [file an issue](https://atmjira.arc.nasa.gov/projects/UAMX/summary).  Feature requests are always welcome.  

Our [Contributors](#contributors) are also great points of contacts for our software.

## Contributors
Thanks to our contributors this software has been made possible:
- [Annie Cheng](mailto:annie.w.cheng@nasa.gov) - Concept & Design
- [Hanbong Lee](mailto:hanbong.lee@nasa.gov) - Product Owner
- [Chin Seah](mailto:chin.h.seah@nasa.gov) - Design & Tester
- [Chu Han Lee](mailto:chu.h.lee@nasa.gov) - Scrum Master/Developer
- [Stephen Chu](fu-sheng.chu@nasa.gov) - Developer

Please contact project management if we have left someone out.

## Acknowledgments

- Badge & Shields from [Shields.io](https://img.shields.io) 

## Resources

### Related Documents
- [Known Issues](./documents/KNOWN_ISSUES.MD)

### Confluence Documentation
- [UAM Application Programming Interface (API)](https://atmconfluence.arc.nasa.gov/pages/viewpage.action?pageId=118489726)



