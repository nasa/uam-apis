# Change Log for the PSU-PSU API
All notable changes to the PSU-PSU API will be documented in this file.

## Change Log Syntax
``[version] - <date/timestamp>``
``<change type> <change description>``

### Types of changes
__Added__ for new features.  
__Changed__ for changes in existing functionality.  
__Deprecated__ for soon-to-be removed features.  
__Removed__ for now removed features.  
__Fixed__ for any bug fixes.  
__Security__ in case of vulnerabilities.  

## Log
Change logging is descending by time.

### [3.0.0] - Fri Mar 29 21:45 UTC 2024
#### Changed
- ./psu_api.yml
   - Version change to reflect transition of work to AMP Project
- ./PSU_CHANGELOG.MD
- ./PSU_CHANGELOG_EXT.MD

### [2.0.1] - Fri Jul 21 14:34:46 PDT 2023
#### Changed
- ./external/psu/psu_api.yml
   - In ExchangeRecord schema, replace required field 'request_source' with 'response_time'. 'request_source' is not specified in schema properties.
- ./external/psu/PSU_CHANGELOG.MD
   - Version change

### [2.0.0] - Mon Feb 13 21:51:12 UTC 2023
#### Changed
- external/psu/psu_api.yml
   - Version change
- ./CHANGELOG.MD
   - Version change

### [2.0.0-alpha+3] - Fri Jan 20 01:12:18 UTC 2023
#### Changed
- external/psu/psu_api.yml
   - Version change
- ./CHANGELOG.MD
   - Change in autogen parameters which change the artifact

### [2.0.0-alpha+1] - Wed Dec 21 18:33:09 UTC 2022
#### Changed
- external/psu/PSU_CHANGELOG.md
- external/psu/psu_api.yml
    - Pre-release version update

### [0.2.0-uam] - 
#### Changed
- external/psu/PSU_CHANGELOG.md
- external/psu/psu_api.yml
    - Updated the file based on the Version 0.3.17 Commit ed1eac6 of the ASTM UTM API.

### [0.1.0-uam] - Mon Sep 13 13:41:08 PDT 2021
#### Added
- external/psu/PSU_CHANGELOG_EXT.md
#### Changed
- external/psu/PSU_CHANGELOG.md
- external/psu/psu_api.yml
    - Moved all DSS content to a separate file.
    - Updated to Version 0.3.15 Commit fde915a of the ASTM UTM API where applicable.
    - Occurences of 'USS' and 'UTM' where changed to 'PSU' and 'UAM' respectively in description fields.
    - Updated 'OperationState' for NonConforming to reflect use of 4DTs
    - Added description details to trajectory_property_array

### [0.0.2-uam]
#### Changed
- Updated to Version 0.3.15 Commit fde915a of the ASTM UTM API where applicable.
- Additional changes to schema names where needed to distinguish from the corresponding DSS schema

### [0.0.1-uam]
#### Added
- external/psu/PSU_CHANGELOG.md
#### Changed
- external/psu/psu_api.yml
    - This file is based on the Version 0.3.5 Commit 742454c of the ASTM UTM API. Changes from that version include:
        - Removed all content only applicable to PSU-DSS exchanges
        - Updated tags to only include tags for PSU
        - Updated 'OperationState' for NonConforming to reflect use of 4DTs
        - Added to the definition of 'time_start' and 'time_end' in the 'OperationReference' schema
        - Updated required properties in 'Circle' and 'Volume4D' schemas
        - All occurences of 'USS' and 'UTM' where changed to 'PSU' and 'UAM' respectively. Notable changes are:
            - 'psu_base_url' property name change
            - 'PsuBaseURL' schema name change
            - 'OperationPsuBaseURL' schema name change
            - 'ConstraintPsuBaseURL' schema name change
        - Updated 'OperationDetails' to require additional properties and replace 'volume' with 'trajectory'
        - Added 'TrajectoryPoint4D' schema and applicable  referenced schemas.
        - Updated description and required properties in 'VehicleTelemtry' schema
        - Updated required properties in 'Position' schema
        - Updated 'Velocity' schema to allow selectable ground or air speed, and units of meters/second or knots
        - Added description to the /psu/v1/operations/{entityuuid} GET path
        - Updated the /psu/v1/operations/{entityuuid}/telemetry GET path to alow this request in all vehicle states, not just off-nominal

