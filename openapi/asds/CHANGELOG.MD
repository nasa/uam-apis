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

### [1.8.0-uam] - Tue Jun 14 23:49:59 PDT 2022
#### Changed

* 'inner_radius' and 'outer_radius' in Vertiport became optional.
* 'Transition' and 'Navigational' were removed from WaypointType.
* Descriptions were improved for the following properties and schemas.
  * 'transition_max_speed'
  * 'transition_min_speed'
  * 'Vertiport'
* Corrected a typo.
* A link to an external document was updated.

### [1.2.0-uam] - Mon Aug  9 16:48:16 PDT 2021  
#### Added
* Public release version change
    * ./asds.yaml
    * ./CHANGELOG.MD  
  
  
### [1.1.2-uam] - 12/21/2021

#### Changed

* The 'altitude' property in Vertiport schema was changed to 'ground_level_altitude'.
* The 'altitude' property in Waypoint schema was changed to 'cruising_altitude'.
* The descriptions of existing altitude properties were improved.
* Existing altitude properties were changed to end with "_egm96" to indicate that they are in reference to the EGM96 geoid model.
* Added new altitude properties and they end with "_wgs84" to indicate that they are in reference to the WGS84 ellipsoid model.
* Corrected a typo in the property name, 'adapation_hash' in the Adaptation schema.
* Corrected the regular expression for UUID.
  * The first digit of the fourth part was changed from '[8-b]' to '[89abAB]'.


### [1.1.1-uam] - 11/04/2021
#### Changed
* Several typo corrections in the descriptions.
* The enumerator, "RNP_0_1", was changed to "RNP_0.1".
  

### [1.0.2-uam] - 10/14/2021
#### Changed
* Bearer authorization security scheme was added for all operation.
* Added more error responses
    * 401 - invalidate token
    * 403 - unauthorized operation
* Added more fields to ErrorResponse schema
    * status - response status code
    * error - a short description of the error
  

### [1.0.1-uam] - 10/06/2021
#### Changed
* The 'servers' section was removed.
  

### [1.0.0-uam] - 09/17/2021
#### Changed
* version update from 0.1.2-uam to 1.0.0-uam
  

### [0.1.2-uam] - 09/13/2021
#### Changed
* ./asds.yaml changed
    * Enroute & transition max & min airpseeds were added to PerformanceRequirements

### [0.1.1-uam] - 09/07/2021
#### Changed
* ./asds.yaml changed
    * the 'configuration' in Adaptation is not required any more
    * the min/max size of Polygon adjusted
  

### [0.1.0-uam] - Mon Aug  9 16:48:16 PDT 2021  
#### Added
* Initial file additions
    * ./asds.yaml
    * ./README.MD
    * ./CHANGELOG.MD  
