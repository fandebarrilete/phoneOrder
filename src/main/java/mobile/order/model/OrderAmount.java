package mobile.order.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * OrderAmount
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-07-07T15:38:07.949Z")

public class OrderAmount   {
  @JsonProperty("totalAmount")
  private Double totalAmount = null;

  @JsonProperty("listPhoneAmount")
  @Valid
  private List<PhoneAmount> listPhoneAmount = null;

  public OrderAmount totalAmount(Double totalAmount) {
    this.totalAmount = totalAmount;
    return this;
  }

  /**
   * Get totalAmount
   * @return totalAmount
  **/
  @ApiModelProperty(value = "")


  public Double getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(Double totalAmount) {
    this.totalAmount = totalAmount;
  }

  public OrderAmount listPhoneAmount(List<PhoneAmount> listPhoneAmount) {
    this.listPhoneAmount = listPhoneAmount;
    return this;
  }

  public OrderAmount addListPhoneAmountItem(PhoneAmount listPhoneAmountItem) {
    if (this.listPhoneAmount == null) {
      this.listPhoneAmount = new ArrayList<PhoneAmount>();
    }
    this.listPhoneAmount.add(listPhoneAmountItem);
    return this;
  }

  /**
   * Get listPhoneAmount
   * @return listPhoneAmount
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<PhoneAmount> getListPhoneAmount() {
    return listPhoneAmount;
  }

  public void setListPhoneAmount(List<PhoneAmount> listPhoneAmount) {
    this.listPhoneAmount = listPhoneAmount;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderAmount orderAmount = (OrderAmount) o;
    return Objects.equals(this.totalAmount, orderAmount.totalAmount) &&
        Objects.equals(this.listPhoneAmount, orderAmount.listPhoneAmount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalAmount, listPhoneAmount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderAmount {\n");
    
    sb.append("    totalAmount: ").append(toIndentedString(totalAmount)).append("\n");
    sb.append("    listPhoneAmount: ").append(toIndentedString(listPhoneAmount)).append("\n");
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

