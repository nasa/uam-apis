# Data Collection for NASA X3 Event

## NASA Data Collection's implementation relative to the ASTM spec

1. The NASA Data Pipeline (NDP) validation differs from the ASTM spec in the following:
  * exclusive min/max validation is not enforced [Irene, I reversed the sense of this as it was originally written. Seemed like a typo]
  * anyOf is ignored [but moot: all anyOf in ASTM 0.3.5 contain just a single entry. Used for documentation purposes: allow a Description key]
  * For the operations model, for volume start times and durations that are outside of the overall operation start and duration, NDP will emit "OPERATION VOLUME END TIME OUTSIDE OF OPERATION TIMES FOR OPERATION ID <operation id>"
  * compliant with ASTM 0.3.5 spec, altitude ranges are enforced. [Irene, this was: For altitude ranges, NDP does not enforce)
  * NDP validation for timestamps is not ASTM compliant: only a particular variety of RFC3339 timestamp is allowod, and nanosecond accuracy is not available.
    See ./NDPValidation.txt for details.
    NDP will emit error message "is invalid against requested date format(s) [yyyy-MM-dd'T'HH:mm:ssZ, yyyy-MM-dd'T'HH:mm:ss.SSSZ" [Irene, what is the provenance of this message?]
  * Compliant with ASTM 0.3.5 spec, NDP enforces "The winding order shall be interpreted as the order which produces the smaller area." (Green's law, CCW winding)

2. HTTP Response error messages may contain extraneous information along with essential.  An example of extraneous is ""[format attribute \"double\" not supported, , format attribute \"int32\" not supported]"

