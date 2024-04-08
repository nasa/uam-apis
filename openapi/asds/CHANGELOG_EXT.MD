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

### [3.0.0] - Fri Mar 29 21:45 UTC 2024
#### Changed
- ./asds_api.yml
   - Version change to reflect transition of work to AMP Project
- ./CHANGELOG.MD
- ./CHANGELOG_EXT.MD
  
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

### [1.1.0-uam] - 10/28/2021
#### Changed
* The 'servers' section was removed.
* Bearer authorization security scheme was added for all operation.
* Added more error responses
    * 401 - invalidate token
    * 403 - unauthorized operation
* Added more fields to ErrorResponse schema
    * status - response status code
    * error - a short description of the error

### [1.2.0-uam] - 12/21/2021
#### Changed

* Several typo corrections in the descriptions.
* The enumerator, "RNP_0_1", was changed to "RNP_0.1".
* The 'altitude' property in Vertiport schema was changed to 'ground_level_altitude'.
* The 'altitude' property in Waypoint schema was changed to 'cruising_altitude'.
* The descriptions of existing altitude properties were improved.
* Existing altitude properties were changed to end with "_egm96" to indicate that they are in reference to the EGM96 geoid model.
* Added new altitude properties and they end with "_wgs84" to indicate that they are in reference to the WGS84 ellipsoid model.
* Corrected a typo in the property name, 'adapation_hash' in the Adaptation schema.
* Corrected the regular expression for UUID.
  * The first digit of the fourth part was changed from '[8-b]' to '[89abAB]'.
* The description of the 'fimsAzAuth' security scheme was update to clarify the audience name for ASDS.
