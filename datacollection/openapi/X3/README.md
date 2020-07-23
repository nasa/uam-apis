# Data Collection for NASA X3 Event

## NASA Data Collection's implementation relative to the ASTM spec

1. The NASA Data Pipeline (NDP) validation differs from the ASTM spec in the following:
  * exclusive min/max validation is enforced
  * anyOf is ignored
  * For Time ranges (begin and end time) NDP will emit "OPERATION VOLUME END TIME OUTSIDE OF OPERATION TIMES FOR OPERATION ID 4e62f6ca-6fa5-4bee-86fb-b28c2f1a9c33"
  * For altitude ranges, NDP does not enforce 
  * The ASTM date-time specifies RFC 3339 but is vague WRT 1) 'T' is optional or required? 2) Nanoseconds precision.  NDP will emit error message "is invalid against requested date format(s) [yyyy-MM-dd'T'HH:mm:ssZ, yyyy-MM-dd'T'HH:mm:ss.SSSZ"
  * For ASTM Polygon, NDP enforces "The winding order shall be interpreted as the order which produces the smaller area."

2. HTTP Response error messages may contain extraneous information along with essetial.  An example of extraneous is ""[format attribute \"double\" not supported, , format attribute \"int32\" not supported]"
