package mobile.order.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Order
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-07-07T15:38:07.949Z")

public class Order   {
  @JsonProperty("customer")
  private Customer customer = null;

  @JsonProperty("listPhones")
  @Valid
  private List<Phone> listPhones = null;

  public Order customer(Customer customer) {
    this.customer = customer;
    return this;
  }

  /**
   * Get customer
   * @return customer
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Order listPhones(List<Phone> listPhones) {
    this.listPhones = listPhones;
    return this;
  }

  public Order addListPhonesItem(Phone listPhonesItem) {
    if (this.listPhones == null) {
      this.listPhones = new ArrayList<Phone>();
    }
    this.listPhones.add(listPhonesItem);
    return this;
  }

  /**
   * Get listPhones
   * @return listPhones
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Phone> getListPhones() {
    return listPhones;
  }

  public void setListPhones(List<Phone> listPhones) {
    this.listPhones = listPhones;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Order order = (Order) o;
    return Objects.equals(this.customer, order.customer) &&
        Objects.equals(this.listPhones, order.listPhones);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customer, listPhones);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Order {\n");
    
    sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
    sb.append("    listPhones: ").append(toIndentedString(listPhones)).append("\n");
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

