package za.co.sar.purchases.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "purchase")
@NamedQueries({
        @NamedQuery(name= PurchasesEntity.PURCHASES_FIND_ALL, query =
            """
            select p from PurchasesEntity p
            order by vendor
            """),
        @NamedQuery(name = PurchasesEntity.PURCHASES_FIND_BY_VENDOR, query =
            """
            select p from PurchasesEntity p
            where p.vendor = :vendor
            order by p.vendor
            """)
})
public class PurchasesEntity {

    private Long id;
    private String vendor;
    private String date;
    private BigDecimal amount;

    public static final String PURCHASES_FIND_ALL = "Purchases.findAll";
    public static final String PURCHASES_FIND_BY_VENDOR = "Purchases.findByVendor";

    public PurchasesEntity() {
    }

    public PurchasesEntity(Long id, String vendor, String date, BigDecimal amount) {
        this.id = id;
        this.vendor = vendor;
        this.date = date;
        this.amount = amount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "PurchasesEntity{" +
                "id=" + id +
                ", vendor='" + vendor + '\'' +
                ", date='" + date + '\'' +
                ", amount=" + amount +
                '}';
    }
}
