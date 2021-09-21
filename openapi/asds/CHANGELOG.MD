# Change Log for the Airspace Structure Definition Service API
The following log describes the changes to the Airspace Structure Definition Service API.  
  
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
  
### [0.1.0-uam] - Mon Aug  9 16:48:16 PDT 2021  
#### Added
* Initial file additions
    * ./asds.yaml
    * ./README.MD
    * ./CHANGELOG.MD  
    
### [1.0.0-uam] - 09/17/2021
#### Changed
* ./asds.yaml changed
    * the 'configuration' in Adaptation is not required any more
    * adjusted the min/max size of Polygon
    * Enroute & transition max & min airpseeds were added to PerformanceRequirements
