# Change Log for the PSU-PSU API
All notable changes to the PSU-PSU API for X4 will be documented in this file.

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


### [0.1.0-uam] - Mon Sep 13 13:41:08 PDT 2021
#### Added
- openapi/psu/PSU_CHANGELOG.md
#### Changed
- openapi/psu/psu_api.yml
    - Moved all DSS content to a separate file.
    - Updated to Version 0.3.15 Commit fde915a of the ASTM UTM API where applicable.
    - Occurences of 'USS' and 'UTM' where changed to 'PSU' and 'UAM' respectively in description fields.
    - Updated 'OperationState' for NonConforming to reflect use of 4DTs
    - Added description details to trajectory_property_array

### [0.0.1]
#### Added
- openapi/psu/psu_api.yml
