# Change Log for the Data Collection API
All notable changes to the Data Collection API will be documented in this file.

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
- ./data_collection_api.yml
   - Version change to reflect transition of work to AMP Project
- ./CHANGELOG.MD
- ./CHANGELOG_EXT.MD

### [0.5.0-uam] - Thu Mar 24 10:37:48 PDT 2022
#### Changed
- Correct misspelling
- Increase OVN max array to 400

### [0.4.0-uam] - Thu Feb 24 12:52:00 PDT 2022
#### Changed
- Added description details to PSULogSet
- Added maxItems to arrays
- Added securitySchemes
- Added HTTP 413 response
- Removed HTTP 200 response

### [0.3.0-uam] - Mon Jan 31 8:54:00 PDT 2022
#### Changed
- Updated path to '/psu_log_sets'

### [0.2.0-uam] - Wed Dec 22 11:04:00 PDT 2021
#### Changed
- Added the InitialOperationalIntent to the PSULogSet Schema 

### [0.1.0-uam] - Wed Oct 20 11:07:40 PDT 2021
#### Added
- openapi/data/CHANGELOG.md
- openapi/data/data_collection_api.yml
