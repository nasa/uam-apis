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
 * MetaDataDmpUss
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-11-14T14:04:30.458-08:00[US/Pacific]")
public class MetaDataDmpUss   {
  @JsonProperty("data_collection")
  private Boolean dataCollection = null;

  @JsonProperty("call_sign")
  private String callSign = null;

  @JsonProperty("uss_name")
  private String ussName = null;

  @JsonProperty("test_run")
  private Integer testRun = null;

  public MetaDataDmpUss dataCollection(Boolean dataCollection) {
    this.dataCollection = dataCollection;
    return this;
  }

  /**
   * If true these data are intended for Data Collection. Essentially stating if particular data should be ignored during analysis. This may be modified after submission in the case that there was an issue during execution of the test/experiment that would invalidate the data that were collected.
   * @return dataCollection
  **/
  @ApiModelProperty(required = true, value = "If true these data are intended for Data Collection. Essentially stating if particular data should be ignored during analysis. This may be modified after submission in the case that there was an issue during execution of the test/experiment that would invalidate the data that were collected.")
      @NotNull

    public Boolean isDataCollection() {
    return dataCollection;
  }

  public void setDataCollection(Boolean dataCollection) {
    this.dataCollection = dataCollection;
  }

  public MetaDataDmpUss callSign(String callSign) {
    this.callSign = callSign;
    return this;
  }

  /**
   * Get callSign
   * @return callSign
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

  @Size(min=1,max=100)   public String getCallSign() {
    return callSign;
  }

  public void setCallSign(String callSign) {
    this.callSign = callSign;
  }

  public MetaDataDmpUss ussName(String ussName) {
    this.ussName = ussName;
    return this;
  }

  /**
   * This is a unique string that identifies the USS that is supporting this operation.  It is the same identifier used in the basic authentication mechanism required to obtain a token from FIMS (Flight Information Management System).  It is also the subject claim that identifies the principal that is the subject of the JWT.
   * @return ussName
  **/
  @ApiModelProperty(required = true, value = "This is a unique string that identifies the USS that is supporting this operation.  It is the same identifier used in the basic authentication mechanism required to obtain a token from FIMS (Flight Information Management System).  It is also the subject claim that identifies the principal that is the subject of the JWT.")
      @NotNull

  @Size(min=1,max=1000)   public String getUssName() {
    return ussName;
  }

  public void setUssName(String ussName) {
    this.ussName = ussName;
  }

  public MetaDataDmpUss testRun(Integer testRun) {
    this.testRun = testRun;
    return this;
  }

  /**
   * An identifier for a specific run of a test_card.  In many cases, a test_card may be only run once.  However, it is possible that a test_card is run multiple times.
   * @return testRun
  **/
  @ApiModelProperty(required = true, value = "An identifier for a specific run of a test_card.  In many cases, a test_card may be only run once.  However, it is possible that a test_card is run multiple times.")
      @NotNull

    public Integer getTestRun() {
    return testRun;
  }

  public void setTestRun(Integer testRun) {
    this.testRun = testRun;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MetaDataDmpUss metaDataDmpUss = (MetaDataDmpUss) o;
    return Objects.equals(this.dataCollection, metaDataDmpUss.dataCollection) &&
        Objects.equals(this.callSign, metaDataDmpUss.callSign) &&
        Objects.equals(this.ussName, metaDataDmpUss.ussName) &&
        Objects.equals(this.testRun, metaDataDmpUss.testRun);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dataCollection, callSign, ussName, testRun);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MetaDataDmpUss {\n");
    
    sb.append("    dataCollection: ").append(toIndentedString(dataCollection)).append("\n");
    sb.append("    callSign: ").append(toIndentedString(callSign)).append("\n");
    sb.append("    ussName: ").append(toIndentedString(ussName)).append("\n");
    sb.append("    testRun: ").append(toIndentedString(testRun)).append("\n");
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
