# Change Log for the Constraint Identification Service (CIS) Model
All notable changes to the CIS data model for UAM activities will be documented in this file.

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

### [2.0.1] - Thu May 25 19:02:45 2023 -0700
#### Changed
- ./cis_model.yml
   - Replace use of ASDS with adaptation
   - Use bullet list for descriptions to increase maintainability.
   - Added Constraint types: FLOW_RATE_CONSTANT, SEQUENCE
   - Modified all enums to be uppercase per best practice
   - Added Property type: DEPENDENCY_POINT
   - Added Property unit: STRING
   - Modified property_value type to string
     - property_values may be of any type


### [2.0.0] - Mon Feb 13 21:51:12 UTC 2023
#### Changed
- ./cis_model.yml
   - Version change
- ./CHANGELOG.MD
   - Version change

### [2.0.0-alpha+3] - Fri Jan 20 01:12:18 UTC 2023
#### Changed
- ./cis_model.yml
   - Version change
- ./CHANGELOG.MD
   - Change in autogen parameters which change the artifact

### [2.0.0-alpha+1] - Wed Dec 21 18:33:09 UTC 2022
#### Changed
- ./cis_model.yml
  - Modification to house various constraints utilized within the route network.
- ./CHANGELOG.MD
- ./CHANGELOG_EXT.md

### [1.1.0-uam] - Wed Apr 20 17:34:15 PDT 2022
#### Changed
- external/cis/CHANGELOG.MD
  - Added sample get path
  - Added description

### [1.0.0-uam] - Thu Jan 20 11:03:00 PDT 2022
#### Added
- external/cis/CHANGELOG.MD
- external/cis/cis_model.yml
