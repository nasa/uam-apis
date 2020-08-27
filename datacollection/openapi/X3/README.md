# Data Collection for NASA X3 Event

## NASA Clarifications to the ASTM spec

NASA's clarifications to the ASTM interface spec are documented in ![this base doc copied from ASTM](https://github.com/nasa/uam-apis/blob/master/datacollection/nasa-astm-utm.yaml)

You can compare the ASTM interface spec with NASA's clarifications using ![this compare URL](https://github.com/nasa/uam-apis/compare/implementation_2020q2_752454c..master)

Data Pipeline is hosted by AWS API Gateway which has restrictions ![as documented here](https://docs.aws.amazon.com/apigateway/latest/developerguide/api-gateway-known-issues.html).  In particular date-time is
validated against this ECMA 262 regex:

```
 ^([0-9]{4})-(1[0-2]|0[1-9])-(3[01]|0[1-9]|[12][0-9])T(2[0-3]|[01][0-9]):([0-5][0-9]):([0-5][0-9])(\\.[0-9]{3})Z$
```
