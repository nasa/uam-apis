# Airspace Structure Definition Service API
## Overview
X4 Airspace Architecture represents a future-state UAM environment. The Airspace Structure Definition Service (ASDS) is a component of the X4 simulation environment which is responsible for, in part, providing various airspace structure definition information to X4 participants to help facilitate the safe and efficient transit of UAM vehicles.

## Application Description
The purpose of this X4 ASDS API is to establish initial interface definitions, at a high level, between the Airspace Structure Definition Service (ASDS) and X4 participants, e.g. Provider of Services for UAM (PSU), for use in the National Campaign X-Series X4 Simulation. Descriptions herein are subject to evolve over time as research results and new information becomes available. It is expected that the descriptions and definitions contained herein will be updated after further testing is completed.

## Adaptation Description
The X4 airspace of interest is the Dallas-Fort Worth (DFW) Class Bravo and surrounding Addison Class Delta surface areas. The ASDS airspace structure and design parameters will be provided to X4 participants to assist in planning their UAM operations. ASDS airspace structure and associated performance requirements are communicated to X4 participants upon request, for example: Corridors within Class B/C/D airspace, Tracks, Waypoints, and Vertiport locations along with associated Performance Requirements for Corridors, Track Waypoints, and Final Waypoints. 

## X4 Participant(s)
### ASDS Request Procedures
* X4 Participants need to get FIMS token for using the API defined functionality.   
* Get access token from FIMS-AZ by providing required data to identify the client   
* Build & send HTTP GET request with the valid access token in the header   
* Identify the adaptation ID of your interest from the response   
* Build and send HTTP request with the valid access token in the header     
* Upon participant data request,
  * Request is logged   
  * FIMS_AZ confirms participant token validity     
  * ASDS sends airspace structure data to participant    
