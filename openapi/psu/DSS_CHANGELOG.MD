# Change Log for the DSS API
All notable changes to the DSS API will be documented in this file.

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
- ./dss_api.yml
   - Version change to reflect transition of work to AMP Project
- ./DSS_CHANGELOG.MD
- ./DSS_CHANGELOG_EXT.MD

### [2.0.0] - Mon Feb 13 21:51:12 UTC 2023
#### Changed
- external/psu/dss_api.yml
   - Version change
- ./CHANGELOG.MD
   - Version change

### [2.0.0-alpha+3] - Fri Jan 20 01:12:18 UTC 2023
#### Changed
- external/psu/dss_api.yml
   - Version change
- ./CHANGELOG.MD
   - Change in autogen parameters which change the artifact

### [2.0.0-alpha+1] - Wed Dec 21 18:33:09 UTC 2022
#### Changed
- external/psu/DSS_CHANGELOG.md
- external/psu/dss_api.yml
  - pre-release version update

### [0.2.0-uam] - 
#### Changed
- external/psu/DSS_CHANGELOG.md
- external/psu/dss_api.yml
    - Updated the file based on the Version 0.3.17 Commit ed1eac6 of the ASTM UTM API.

### [0.1.0-uam] - Mon Sep 13 13:41:08 PDT 2021
#### Added
- external/psu/DSS_CHANGELOG_EXT.md
#### Changed
- external/psu/DSS_CHANGELOG.md
- external/psu/dss_api.yml
    - This file is based on the Version 0.3.15 Commit fde915a of the ASTM UTM API and only contains DSS content.
    - Updated 'OperationState' for NonConforming to reflect use of 4DTs

### [0.0.2-uam]
#### Changed
- Updated to Version 0.3.15 Commit fde915a of the ASTM UTM API where applicable.

### [0.0.1-uam]
#### Added
- external/psu/DSS_CHANGELOG.md
- external/psu/dss_api.yml 
    - This file is based on the Version 0.3.5 Commit 742454c of the ASTM UTM API. Changes from that version include: 
        - Removed all content only applicable to PSU-PSU exchanges
        - Updated tags to only include tags for DSS
        - Updated 'OperationState' for NonConforming to reflect use of 4DTs
        - Added to the definition of 'time_start' and 'time_end' in the 'OperationReference' schema
        - Updated required properties in 'Circle' and 'Volume4D' schemas


