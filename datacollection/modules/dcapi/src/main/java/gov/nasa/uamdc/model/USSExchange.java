package gov.nasa.uamdc.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import gov.nasa.uamdc.model.MetaDataDmpUss;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.UUID;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * This model captures performance and interoperability data for a USS. since these data are not captured explicitly in the USS network, it is important to have USSs self report on these elements.  This information may inform future performance requirements and forensics of certain incidents. This may be an initial model that will be required operationally in terms of a USSs need to log interactions with other USSs.
 */
@ApiModel(description = "This model captures performance and interoperability data for a USS. since these data are not captured explicitly in the USS network, it is important to have USSs self report on these elements.  This information may inform future performance requirements and forensics of certain incidents. This may be an initial model that will be required operationally in terms of a USSs need to log interactions with other USSs.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-11-14T14:04:30.458-08:00[US/Pacific]")
public class USSExchange   {
  @JsonProperty("metaDataDmpUss")
  private MetaDataDmpUss metaDataDmpUss = null;

  @JsonProperty("measurement_id")
  private UUID measurementId = null;

  @JsonProperty("event_id")
  private String eventId = null;

  @JsonProperty("exchanged_data_pk")
  private UUID exchangedDataPk = null;

  /**
   * Gets or Sets exchangedDataType
   */
  public enum ExchangedDataTypeEnum {
    OPERATION("OPERATION"),
    
    POSITION("POSITION"),
    
    UTM_MESSAGE("UTM_MESSAGE"),
    
    CONSTRAINT_MESSAGE("CONSTRAINT_MESSAGE"),
    
    NEGOTIATION_MESSAGE("NEGOTIATION_MESSAGE"),
    
    USS_INSTANCE("USS_INSTANCE"),
    
    DISCOVERY("DISCOVERY"),
    
    OTHER_SEE_COMMENT("OTHER_SEE_COMMENT");

    private String value;

    ExchangedDataTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ExchangedDataTypeEnum fromValue(String text) {
      for (ExchangedDataTypeEnum b : ExchangedDataTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("exchanged_data_type")
  private ExchangedDataTypeEnum exchangedDataType = null;

  @JsonProperty("source_uss")
  private String sourceUss = null;

  @JsonProperty("target_uss")
  private String targetUss = null;

  /**
   * An enum indicating if the USS providing these data was the one that initiated the request (SOURCE_USS) or the USS that received the request (TARGET_USS).
   */
  public enum ReportingUssRoleEnum {
    SOURCE_USS("SOURCE_USS"),
    
    TARGET_USS("TARGET_USS");

    private String value;

    ReportingUssRoleEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ReportingUssRoleEnum fromValue(String text) {
      for (ReportingUssRoleEnum b : ReportingUssRoleEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("reporting_uss_role")
  private ReportingUssRoleEnum reportingUssRole = null;

  @JsonProperty("time_request_initiation")
  private Date timeRequestInitiation = null;

  @JsonProperty("time_request_completed")
  private Date timeRequestCompleted = null;

  @JsonProperty("endpoint")
  private String endpoint = null;

  /**
   * The HTTP method used in this exchange.
   */
  public enum HttpMethodEnum {
    GET("GET"),
    
    POST("POST"),
    
    PUT("PUT"),
    
    DELETE("DELETE"),
    
    HEAD("HEAD"),
    
    TRACE("TRACE"),
    
    OPTIONS("OPTIONS"),
    
    CONNECT("CONNECT"),
    
    PATCH("PATCH");

    private String value;

    HttpMethodEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static HttpMethodEnum fromValue(String text) {
      for (HttpMethodEnum b : HttpMethodEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("http_method")
  private HttpMethodEnum httpMethod = null;

  @JsonProperty("expected_http_response")
  private Integer expectedHttpResponse = null;

  @JsonProperty("actual_http_response")
  private Integer actualHttpResponse = null;

  @JsonProperty("comments")
  private String comments = null;

  public USSExchange metaDataDmpUss(MetaDataDmpUss metaDataDmpUss) {
    this.metaDataDmpUss = metaDataDmpUss;
    return this;
  }

  /**
   * Get metaDataDmpUss
   * @return metaDataDmpUss
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    @Valid
    public MetaDataDmpUss getMetaDataDmpUss() {
    return metaDataDmpUss;
  }

  public void setMetaDataDmpUss(MetaDataDmpUss metaDataDmpUss) {
    this.metaDataDmpUss = metaDataDmpUss;
  }

  public USSExchange measurementId(UUID measurementId) {
    this.measurementId = measurementId;
    return this;
  }

  /**
   * A UUID assigned by the reporting USS for this instance of USSExchange.
   * @return measurementId
  **/
  @ApiModelProperty(example = "00000000-0000-4444-8888-feeddeadbeef", required = true, value = "A UUID assigned by the reporting USS for this instance of USSExchange.")
      @NotNull

    @Valid
    public UUID getMeasurementId() {
    return measurementId;
  }

  public void setMeasurementId(UUID measurementId) {
    this.measurementId = measurementId;
  }

  public USSExchange eventId(String eventId) {
    this.eventId = eventId;
    return this;
  }

  /**
   * A string provided by the owner of the overall test (likely NASA) that identifies the event within which this data exchange occurs. NASA will define a pattern for this for consistency across tests.
   * @return eventId
  **/
  @ApiModelProperty(example = "USS_SPRINT1_SIM_20180723_RUN5", required = true, value = "A string provided by the owner of the overall test (likely NASA) that identifies the event within which this data exchange occurs. NASA will define a pattern for this for consistency across tests.")
      @NotNull

  @Size(min=3,max=100)   public String getEventId() {
    return eventId;
  }

  public void setEventId(String eventId) {
    this.eventId = eventId;
  }

  public USSExchange exchangedDataPk(UUID exchangedDataPk) {
    this.exchangedDataPk = exchangedDataPk;
    return this;
  }

  /**
   * The primary key of the data that were exchanged.  For example, if an Operation was exchanged, then this field would contain the gufi. In the case that multiple data elements were exchanged (as in a GET to the Operations endpoint resulting in multiple Operations returned) then just populate this field with one of the primary keys. As a best practice, choose the first one in the array as they were sent between USSs.
   * @return exchangedDataPk
  **/
  @ApiModelProperty(example = "00000000-0000-4444-8888-feeddeadbeef", required = true, value = "The primary key of the data that were exchanged.  For example, if an Operation was exchanged, then this field would contain the gufi. In the case that multiple data elements were exchanged (as in a GET to the Operations endpoint resulting in multiple Operations returned) then just populate this field with one of the primary keys. As a best practice, choose the first one in the array as they were sent between USSs.")
      @NotNull

    @Valid
    public UUID getExchangedDataPk() {
    return exchangedDataPk;
  }

  public void setExchangedDataPk(UUID exchangedDataPk) {
    this.exchangedDataPk = exchangedDataPk;
  }

  public USSExchange exchangedDataType(ExchangedDataTypeEnum exchangedDataType) {
    this.exchangedDataType = exchangedDataType;
    return this;
  }

  /**
   * Get exchangedDataType
   * @return exchangedDataType
  **/
  @ApiModelProperty(example = "POSITION", required = true, value = "")
      @NotNull

    public ExchangedDataTypeEnum getExchangedDataType() {
    return exchangedDataType;
  }

  public void setExchangedDataType(ExchangedDataTypeEnum exchangedDataType) {
    this.exchangedDataType = exchangedDataType;
  }

  public USSExchange sourceUss(String sourceUss) {
    this.sourceUss = sourceUss;
    return this;
  }

  /**
   * This is the uss_name of the source_uss. See MetaDataDmpUssId for definition of uss_name.
   * @return sourceUss
  **/
  @ApiModelProperty(example = "uss.provider123.net", required = true, value = "This is the uss_name of the source_uss. See MetaDataDmpUssId for definition of uss_name.")
      @NotNull

    public String getSourceUss() {
    return sourceUss;
  }

  public void setSourceUss(String sourceUss) {
    this.sourceUss = sourceUss;
  }

  public USSExchange targetUss(String targetUss) {
    this.targetUss = targetUss;
    return this;
  }

  /**
   * This is the uss_name of the target_uss. See MetaDataDmpUssId for definition of uss_name.
   * @return targetUss
  **/
  @ApiModelProperty(example = "utm.cool-uss-team.com", required = true, value = "This is the uss_name of the target_uss. See MetaDataDmpUssId for definition of uss_name.")
      @NotNull

    public String getTargetUss() {
    return targetUss;
  }

  public void setTargetUss(String targetUss) {
    this.targetUss = targetUss;
  }

  public USSExchange reportingUssRole(ReportingUssRoleEnum reportingUssRole) {
    this.reportingUssRole = reportingUssRole;
    return this;
  }

  /**
   * An enum indicating if the USS providing these data was the one that initiated the request (SOURCE_USS) or the USS that received the request (TARGET_USS).
   * @return reportingUssRole
  **/
  @ApiModelProperty(example = "SOURCE_USS", value = "An enum indicating if the USS providing these data was the one that initiated the request (SOURCE_USS) or the USS that received the request (TARGET_USS).")
  
    public ReportingUssRoleEnum getReportingUssRole() {
    return reportingUssRole;
  }

  public void setReportingUssRole(ReportingUssRoleEnum reportingUssRole) {
    this.reportingUssRole = reportingUssRole;
  }

  public USSExchange timeRequestInitiation(Date timeRequestInitiation) {
    this.timeRequestInitiation = timeRequestInitiation;
    return this;
  }

  /**
   * If SOURCE_USS, this is the time that the request is sent to the TARGET_USS. If TARGET_USS, this is the time that the request was received from the SOURCE_USS. Same formatting rules as in other UTM exchanges (ms, 'Z').
   * @return timeRequestInitiation
  **/
  @ApiModelProperty(example = "2015-08-20T14:11:56.118Z", required = true, value = "If SOURCE_USS, this is the time that the request is sent to the TARGET_USS. If TARGET_USS, this is the time that the request was received from the SOURCE_USS. Same formatting rules as in other UTM exchanges (ms, 'Z').")
      @NotNull

    @Valid
    public Date getTimeRequestInitiation() {
    return timeRequestInitiation;
  }

  public void setTimeRequestInitiation(Date timeRequestInitiation) {
    this.timeRequestInitiation = timeRequestInitiation;
  }

  public USSExchange timeRequestCompleted(Date timeRequestCompleted) {
    this.timeRequestCompleted = timeRequestCompleted;
    return this;
  }

  /**
   * If SOURCE_USS, this is the time that the response was received from the TARGET_USS. If TARGET_USS, this is the time that the request was sent back to the SOURCE_USS. Same formatting rules as in other UTM exchanges (ms, 'Z').
   * @return timeRequestCompleted
  **/
  @ApiModelProperty(example = "2015-08-20T14:11:56.118Z", required = true, value = "If SOURCE_USS, this is the time that the response was received from the TARGET_USS. If TARGET_USS, this is the time that the request was sent back to the SOURCE_USS. Same formatting rules as in other UTM exchanges (ms, 'Z').")
      @NotNull

    @Valid
    public Date getTimeRequestCompleted() {
    return timeRequestCompleted;
  }

  public void setTimeRequestCompleted(Date timeRequestCompleted) {
    this.timeRequestCompleted = timeRequestCompleted;
  }

  public USSExchange endpoint(String endpoint) {
    this.endpoint = endpoint;
    return this;
  }

  /**
   * The endpoint to which the data request was initially sent.
   * @return endpoint
  **/
  @ApiModelProperty(example = "https://utm.cool-uss-team.com/operations", required = true, value = "The endpoint to which the data request was initially sent.")
      @NotNull

    public String getEndpoint() {
    return endpoint;
  }

  public void setEndpoint(String endpoint) {
    this.endpoint = endpoint;
  }

  public USSExchange httpMethod(HttpMethodEnum httpMethod) {
    this.httpMethod = httpMethod;
    return this;
  }

  /**
   * The HTTP method used in this exchange.
   * @return httpMethod
  **/
  @ApiModelProperty(example = "PUT", required = true, value = "The HTTP method used in this exchange.")
      @NotNull

    public HttpMethodEnum getHttpMethod() {
    return httpMethod;
  }

  public void setHttpMethod(HttpMethodEnum httpMethod) {
    this.httpMethod = httpMethod;
  }

  public USSExchange expectedHttpResponse(Integer expectedHttpResponse) {
    this.expectedHttpResponse = expectedHttpResponse;
    return this;
  }

  /**
   * The expected HTTP response code. This is required ONLY if the reporting_uss_role is SOURCE_USS.
   * minimum: 100
   * maximum: 599
   * @return expectedHttpResponse
  **/
  @ApiModelProperty(example = "204", value = "The expected HTTP response code. This is required ONLY if the reporting_uss_role is SOURCE_USS.")
  
  @Min(100) @Max(599)   public Integer getExpectedHttpResponse() {
    return expectedHttpResponse;
  }

  public void setExpectedHttpResponse(Integer expectedHttpResponse) {
    this.expectedHttpResponse = expectedHttpResponse;
  }

  public USSExchange actualHttpResponse(Integer actualHttpResponse) {
    this.actualHttpResponse = actualHttpResponse;
    return this;
  }

  /**
   * The actual HTTP response code sent by the TARGET_USS to the SOURCE_USS. Must be reported by USSs in either role.
   * minimum: 100
   * maximum: 599
   * @return actualHttpResponse
  **/
  @ApiModelProperty(example = "204", required = true, value = "The actual HTTP response code sent by the TARGET_USS to the SOURCE_USS. Must be reported by USSs in either role.")
      @NotNull

  @Min(100) @Max(599)   public Integer getActualHttpResponse() {
    return actualHttpResponse;
  }

  public void setActualHttpResponse(Integer actualHttpResponse) {
    this.actualHttpResponse = actualHttpResponse;
  }

  public USSExchange comments(String comments) {
    this.comments = comments;
    return this;
  }

  /**
   * Any additional comments that could aid in analysis involving these data.
   * @return comments
  **/
  @ApiModelProperty(example = "This test was good.", value = "Any additional comments that could aid in analysis involving these data.")
  
  @Size(max=1000)   public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    USSExchange usSExchange = (USSExchange) o;
    return Objects.equals(this.metaDataDmpUss, usSExchange.metaDataDmpUss) &&
        Objects.equals(this.measurementId, usSExchange.measurementId) &&
        Objects.equals(this.eventId, usSExchange.eventId) &&
        Objects.equals(this.exchangedDataPk, usSExchange.exchangedDataPk) &&
        Objects.equals(this.exchangedDataType, usSExchange.exchangedDataType) &&
        Objects.equals(this.sourceUss, usSExchange.sourceUss) &&
        Objects.equals(this.targetUss, usSExchange.targetUss) &&
        Objects.equals(this.reportingUssRole, usSExchange.reportingUssRole) &&
        Objects.equals(this.timeRequestInitiation, usSExchange.timeRequestInitiation) &&
        Objects.equals(this.timeRequestCompleted, usSExchange.timeRequestCompleted) &&
        Objects.equals(this.endpoint, usSExchange.endpoint) &&
        Objects.equals(this.httpMethod, usSExchange.httpMethod) &&
        Objects.equals(this.expectedHttpResponse, usSExchange.expectedHttpResponse) &&
        Objects.equals(this.actualHttpResponse, usSExchange.actualHttpResponse) &&
        Objects.equals(this.comments, usSExchange.comments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(metaDataDmpUss, measurementId, eventId, exchangedDataPk, exchangedDataType, sourceUss, targetUss, reportingUssRole, timeRequestInitiation, timeRequestCompleted, endpoint, httpMethod, expectedHttpResponse, actualHttpResponse, comments);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class USSExchange {\n");
    
    sb.append("    metaDataDmpUss: ").append(toIndentedString(metaDataDmpUss)).append("\n");
    sb.append("    measurementId: ").append(toIndentedString(measurementId)).append("\n");
    sb.append("    eventId: ").append(toIndentedString(eventId)).append("\n");
    sb.append("    exchangedDataPk: ").append(toIndentedString(exchangedDataPk)).append("\n");
    sb.append("    exchangedDataType: ").append(toIndentedString(exchangedDataType)).append("\n");
    sb.append("    sourceUss: ").append(toIndentedString(sourceUss)).append("\n");
    sb.append("    targetUss: ").append(toIndentedString(targetUss)).append("\n");
    sb.append("    reportingUssRole: ").append(toIndentedString(reportingUssRole)).append("\n");
    sb.append("    timeRequestInitiation: ").append(toIndentedString(timeRequestInitiation)).append("\n");
    sb.append("    timeRequestCompleted: ").append(toIndentedString(timeRequestCompleted)).append("\n");
    sb.append("    endpoint: ").append(toIndentedString(endpoint)).append("\n");
    sb.append("    httpMethod: ").append(toIndentedString(httpMethod)).append("\n");
    sb.append("    expectedHttpResponse: ").append(toIndentedString(expectedHttpResponse)).append("\n");
    sb.append("    actualHttpResponse: ").append(toIndentedString(actualHttpResponse)).append("\n");
    sb.append("    comments: ").append(toIndentedString(comments)).append("\n");
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
