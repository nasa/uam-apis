# Change Log for RPS DCB and RPS SS APIs
  
## Change Log Syntax
``<changelog> ::= <changeentry> | <changelog><changeentry>``  
``<changeentry> ::= <changeheader><change>``  
``<changeheader ::= [<version>] - <changetime>``  
``<change> ::= <changetype><changedescription> | <change><changetype><changedescription>``  
``<version> ::= string``  
``<changetime> ::= date/timestamp``  
``<changetype> ::= 'Added'|'Changed'|'Deprecated'|'Removed'|'Fixed'|'Security'``  
``<changedescription> ::= string``
  
### Types of changes
__Added__ for new features.  
__Changed__ for changes in existing functionality.  
__Deprecated__ for soon-to-be removed features.  
__Removed__ for now removed features.  
__Fixed__ for any bug fixes.  
__Security__ in case of vulnerabilities.  
__Known Issues__ in the software.

## Log
Change logging is descending by time.

### [3.0.0] - Fri Mar 29 21:45 UTC 2024
#### Changed
- ./rps_dcb_api.yml
- ./rps_ss_api.yml
   - Version change to reflect transition of work to AMP Project
- ./CHANGELOG.MD

### [2.0.5] - Tue Sep 5 11:33:44 PDT 2023
#### Changed
- external/rps/rps_ss_api.yml
   - add ovn_array to ResourcesSchedulingResponse schema.

### [2.0.4] - Wed Jun 14 5:20:57 PDT 2023
#### Changed
- external/rps/rps_api.yml
  - Renamed to external/rps/rps_dcb_api.yml
  - Minor modifications for release 2
#### Added
- external/rps/rps_ss_api.yml
  - Initial version of sequence and spacing API for X5 release 2.
#### Known Issues
- none

### [2.0.3] - Fri Apr 21 15:04:59 PDT 2023
#### Changed
- external/rps/rps_api.yml
   - Removed nullable: true for ovn_array attribute
- external/rps/CHANGELOG.MD

### [2.0.2] - Tue Mar  7 09:46:32 PST 2023
#### Changed
- ./rps_api.yml
   - Change comment to remove restriction that query start time has to be later than current time. Start time can be earlier or later than current time for availability time window query.

### [2.0.1] - Mon Feb 27 15:43:38 PST 2023
#### Changed
- ./rps_api.yml
   - Change comment for get operations end-point.

### [2.0.0] - Mon Feb 13 21:51:12 UTC 2023
#### Changed
- ./rps_api.yml
   - Version change
- ./CHANGELOG.MD
   - Version change

## Changes
### [2.0.0-alpha+4] - Tue Jan 31 00:49:27 UTC 2023
#### Changed
- ./rps_api.yml
  - Change ovn_array to be nullable.

### [2.0.0-alpha+3] - Fri Jan 20 01:12:18 UTC 2023
#### Changed
- ./rps_api.yml  
   - Version change
- ./CHANGELOG.MD
   - Change in autogen parameters which change the artifact  

### [2.0.0-alpha+1] - Wed Jan 4 21:51:30 UTC 2023
#### Changed    
- ./rps_api.yml  
  - Add TimeParam schema to RPS API, where date-time is a simple string, for GET operations end-point.  
  - Change Time schema in RPS API to match schema in DSS and PSU APIs.  

### [2.0.0-alpha+1] - Wed Dec 21 18:33:09 UTC 2022
#### Added
- ./rps_api.yml
  - initial pre-release version
- ./CHANGELOG.MD
- ./README.MD

