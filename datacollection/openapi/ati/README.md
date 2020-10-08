# NASA Data Pipeline for API data collection

Models needed for the NC events fall into 2 categories, ASTM-published and NASA-published.  

NASA has defined a small set of changes to the ASTM spec needed for Data Collection.  These are either clarifications in a model's 'description' field or promotions of a property from option to required.  You can use NASA's "Diff URL" to view these additions.

## ASTM-published Models and NASA's Clarifications to those models

https://raw.githubusercontent.com/astm-utm/Protocol/implementation_2020q2/utm.yaml  # ASTM 03.5  
https://github.com/nasa/uam-apis/compare/implementation_2020q2_752454c..x3   # NASA clarifications (diff URL)

NASA's clarifications to the ASTM interface spec are documented in ![this base doc copied from ASTM](https://github.com/nasa/uam-apis/blob/master/datacollection/nasa-astm-utm.yaml).  You can compare the ASTM interface spec with NASA's clarifications using the above compare URL.

### PUT telemetry for nominal operations
https://github.com/nasa/uam-apis/blob/x3/datacollection/openapi/X3/utm-telemetry.yaml  

## NASA-published models

### ATI Data Pipeline Interfaces
https://github.com/nasa/uam-apis/blob/x3/datacollection/openapi/X3/uam-data-collection-X3.yaml  #non-astm models  
https://github.com/nasa/uam-apis/blob/master/datacollection/openapi/ati/nc.yaml # ADSB

### File Upload Interface

https://github.com/nasa/uam-apis/blob/master/datacollection/openapi/ati/unstructured-data-upload.yaml
