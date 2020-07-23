# Data Collection for NASA X3 Event

## NASA Data Collection's (NDC) implementation relative to the ASTM spec

1. The NASA Data Pipeline (NDP) validation differs from the ASTM spec in the following:
  * exclusive min/max validation is not enforced 
  * anyOf has no effect -- the ASTM authors used this as a workaround to inject documentation
  * For the operations model, for volume start times and durations that are outside of the overall operation start and duration, NDP will emit "OPERATION VOLUME END TIME OUTSIDE OF OPERATION TIMES FOR OPERATION ID <operation id>"
  * compliant with ASTM 0.3.5 spec, altitude ranges are enforced by NDP 
  * NDP validation for timestamps is a subset of ATSM's RFC3339.  Only a particular variety of RFC3339 timestamp is allowod, and nanosecond accuracy is not available.
    See ./NDPValidation.txt for details.
  * Compliant with ASTM 0.3.5 spec description, NDP enforces "The winding order shall be interpreted as the order which produces the smaller area." (Green's law, CCW winding)

2. HTTP Response error messages may contain extraneous information along with essential.  An example of extraneous is ""[format attribute \"double\" not supported, , format attribute \"int32\" not supported]"

