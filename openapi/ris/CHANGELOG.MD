# Change Log for RIS API
  
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

### [3.1.0] - Sun Feb 16 15:50:36 PST 2025
For SDS Sequence Diagrams for ADR.7 Managing Dynamic Updates to Reduction of Resource Capacity.
Based on these ASTM committee's draft APIs as of Feb 13, 2025:
- astm-uam-psu-ris-0.0.0.yaml
- astm-uam-psu-dss-0.0.0.yaml
- astm-uam-psu-oim-0.0.0.yaml
- astm-uam-psu-dcb-0.0.0.yaml
#### Added
- ./ris_api.yml
  - initial pre-release version
- ./CHANGELOG.MD
- ./README.MD

