package bookmarket;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Delivery_table")
public class Delivery {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long orderId;
    private Long customerId;
    private String status;
    private String isMile;

    @PostPersist
    public void onPostPersist(){
        Shipped shipped = new Shipped();
        BeanUtils.copyProperties(this, shipped);
        shipped.publishAfterCommit();


    }

    @PreUpdate
    public void onPreUpdate(){
        DeliveryCanceled deliveryCanceled = new DeliveryCanceled();
        BeanUtils.copyProperties(this, deliveryCanceled);
        deliveryCanceled.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIsMile() {
        return isMile;
    }

    public void setIsMile(String isMile) {
        this.isMile = isMile;
    }
}
