# Data Collection for NASA X3 Event

## Exceptions to the ASTM spec

1. The NASA Data Pipeline validation differs from the ASTM spec in the following:
  a) exclusive min/max validation is not supported
  b)  anyOf is not supported
  c) The ASTM time specifies only RFC 3339, but for NASA Pipeline,
       'T' is mandatory

       Nanoseconds -- NASA accepts 3 places else none

2. HTTP Response error messages may contain extraneous information along with essetial.  An example of extraneous is ""[format attribute \"double\" not supported, , format attribute \"int32\" not supported]"
