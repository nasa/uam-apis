# Change Log for the Operations Planning Service API
The following log describes the changes to the Operations Planning Service API.  
  
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
### [2.0.3] - Tue Sep  5 12:49:22 PDT 2023
#### Changed
- internal/psu/uam_operator_api.yml
   - Add ovn_array to ResourcesSchedulingResponse schema.
- internal/psu/CHANGELOG.MD

### [2.0.2] - 06 Jul 2023
#### Changed
- internal/psu/uam_operator_api.yml
   - Changed version number from 2.0.1 to 2.0.2
- internal/psu/CHANGELOG.MD

### [2.0.1] - Fri Apr 21 15:04:59 PDT 2023
#### Changed
- internal/psu/uam_operator_api.yml
   - Removed nullable: true for ovn_array attribute
- internal/psu/CHANGELOG.MD

### [2.0.0] - Mon Feb 13 21:51:12 UTC 2023
#### Changed
- internal/psu/uam_operator_api.yml
   - Version change
- internal/psu/CHANGELOG.MD
   - Version change

### [2.0.0-alpha+4] - Tue Jan 31 00:49:27 UTC 2023
#### Changed
- ./uam_operator_api.yml
  - Plural available_time_intervals, ovn_array is nullable and update TrajectoryPointPropertyType to match PSU-to-PSU API.

### [2.0.0-alpha+3] - Fri Jan 20 01:12:18 UTC 2023
#### Changed
- ./uam_operator_api.yml
   - Version change
- ./CHANGELOG.MD
   - Change in autogen parameters which change the artifact  

### [2.0.0-alpha+1] - Wed Dec 21 18:33:09 UTC 2022
#### Changed
- ./uam_operator_api.yml
  - pre-release version update
- ./CHANGELOG.MD
- ./README.MD

