## Overview

The National Campaign (NC)-1 Strategic Conflict Management (SCM) Simulation, dubbed “X4”, was conducted between July 2021 and June 2022 by NASA with the FAA and industry to evolve the Provider of Services for UAM (PSU) that will be needed to ensure initial UAM operations can scale in the National Airspace System (NAS). 

To continue evolving strategic conflict management capabilities for cooperative Midterm operations, NASA Air Traffic Management eXploration (ATM-X) UAM Airspace Subproject developed a set of updated Application Programming Interfaces (APIs) and conducted internal simulations with NASA-developed prototypes to support Demand-Capacity Balancing and Sequencing & Scheduling capabilities for UAM operations.

The set of APIs referenced in this documentation were tested and validated using the NASA-developed prototypes during June to September 2023 and may be used to inform future industry standards development and concept validation activities.

## Scope
The APIs were built from the “X4” version of the API ([github link](https://github.com/nasa/uam-apis/blob/x4/openapi/)) that was shared and tested with seven industry airspace partners during the activity.

Below diagram defines the system scope and boundaries of the system for which these APIs were defined.
NOTE: There are different Resource Planning Services (RPS) for Demand-Capacity Balancing versus Sequencing and Scheduling.

![UAM System Scope and Boundaries](./images/system_scope_boundaries.png)  
<sup>Figure 1.1 UAM System Scope and Boundaries</sup>

Functional description for each component, from left to right:

-   **FAA-Industry Data Exchange Protocol (FIDXP)** - Provides a gateway for PSU and FAA to share relevant operational information
    
-   **Discovery and Synchronization Service (DSS)** - Enables third-party services to discover relevant information and ensures that data shared among them are synchronized
    
-   **Resource Registry (RR)** - Provides connectivity  information for third-party resource management services (Demand-Capacity Balancing, Sequencing and Scheduling) that PSUs would communicate with
    
-   **Authentication & Authorization (FIMS-AZ)** - Authenticates and authorizes PSUs and other third-party services
    
-   **Aeronautical Information (ASDS)** - Provides airspace structure definitions for UAM, these definitions include vertiport, routes, corridors, arrival and departure procedures
    
-   **Capacity Information (CIS)** - Provides capacity and constraint information about resources that are shared among PSUs

-   **Demand-Capacity Balancing (RPS)** - Obtains capacity information at shared resources from CIS and provides availability information at resources for UAM Fleet Managers, via the PSU, for demand-capacity balancing functions
    
-   **Sequencing and Scheduling (RPS)** - Obtains constraint information at shared resources from CIS and provides availability information at resources for UAM Fleet Managers, via the PSU, for sequencing and scheduling functions
    
-   **Provider of Services for UAM (PSU)** - Manages sharing of relevant operational plan information among UAM Fleet Managers. Acts as an interface for UAM Fleet Managers to obtain  common resource  and aeronautical information from other third-party services
    
-   **UAM Fleet Manager** – Manages the creation or modification of operational plans that meet the strategic conflict management requirements. Interfaces with the PSU to share and obtain relevant operation plans, resource, and aeronautical information
  

## Comparison with X4 Version

These remain the same:

-   Same airspace adaptation from “X4” was provided through ASDS.    
-   Same version of the DSS from “X4” was used (DSS v3.17)
    

Major updates:

-   A new service, Demand-Capacity Balancing (DCB), provides information for PSU to coordinate operations at vertiports. A new API (rps/rps_dcb_api.yml) defines the information exchange requirements between the service and PSU.
    
-   A new service, Sequencing & Scheduling, provides information for PSU to coordinate operations at selected corridor entry and exit points. A new API (rps/rps_ss_api.yml) defines the information exchange requirements between the service and PSU.
    
-   A new file, Registration Registry (RR), provides connectivity information about services (i.e., endpoint) that PSU would communicate with. This file provides an interim method to discover dynamic services until a more appropriate mechanism is identified.

-   The Capacity Information Service (CIS) file is updated to include additional information about corridor entry and exit points and associated constraint definitions for Sequencing & Scheduling.
    
-   A new service, FAA-Industry Data Exchange Prototype Service (FIDXP), provides an initial connection to FAA systems for PSU. A new API (fidxp/fidxp_api.xml) defines initial information exchange requirements between the FIDXP and PSU.
   
-   The Airspace Authorization (AA) service along with the API (aa/airspace_authorization_api.yml) was removed

-   A new API, PSU-Fleet Operator API (psu/uam_operator_api.yml), defines the information exchange between NASA PSU and NASA UAM Operator prototypes. This API is specific to NASA implementation and included only as a reference.

```