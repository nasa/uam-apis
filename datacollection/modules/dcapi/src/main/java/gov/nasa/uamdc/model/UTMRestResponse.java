package gov.nasa.uamdc.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UTMRestResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-11-14T14:04:30.458-08:00[US/Pacific]")
public class UTMRestResponse   {
  @JsonProperty("http_status_code")
  private Integer httpStatusCode = null;

  @JsonProperty("message")
  private String message = null;

  public UTMRestResponse httpStatusCode(Integer httpStatusCode) {
    this.httpStatusCode = httpStatusCode;
    return this;
  }

  /**
   * Get httpStatusCode
   * minimum: 100
   * maximum: 599
   * @return httpStatusCode
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

  @Min(100) @Max(599)   public Integer getHttpStatusCode() {
    return httpStatusCode;
  }

  public void setHttpStatusCode(Integer httpStatusCode) {
    this.httpStatusCode = httpStatusCode;
  }

  public UTMRestResponse message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
  **/
  @ApiModelProperty(example = "{\"http_status_code\":400,\"message\":\"Bad Request. Invalid JSON?\"}", required = true, value = "")
      @NotNull

  @Size(max=500)   public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UTMRestResponse utMRestResponse = (UTMRestResponse) o;
    return Objects.equals(this.httpStatusCode, utMRestResponse.httpStatusCode) &&
        Objects.equals(this.message, utMRestResponse.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(httpStatusCode, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UTMRestResponse {\n");
    
    sb.append("    httpStatusCode: ").append(toIndentedString(httpStatusCode)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
