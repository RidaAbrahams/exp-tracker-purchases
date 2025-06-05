package za.co.sar.purchases.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PurchaseDTO {

    private Long id;
    private String vendor;
    private String date;
    private BigDecimal amount;

    public PurchaseDTO() {
    }

    public PurchaseDTO(Long id, String vendor, String date, BigDecimal amount) {
        this.id = id;
        this.vendor = vendor;
        this.date = date;
        this.amount = amount;
    }

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

    public PurchasesEntity toEntity() {
        PurchasesEntity purchasesEntity = new PurchasesEntity();
        purchasesEntity.setVendor(vendor);
        purchasesEntity.setDate(date);
        purchasesEntity.setAmount(amount);
        return purchasesEntity;
    }

    public static List<PurchaseDTO> toDTOList(List<PurchasesEntity> purchasesEntities) {
        List<PurchaseDTO> result = new ArrayList<>();
        for (PurchasesEntity purchasesEntity : purchasesEntities) {
            PurchaseDTO purchaseDTO = new PurchaseDTO();
            purchaseDTO.setId(purchasesEntity.getId());
            purchaseDTO.setVendor(purchasesEntity.getVendor());
            purchaseDTO.setDate(purchasesEntity.getDate());
            purchaseDTO.setAmount(purchasesEntity.getAmount());
            result.add(purchaseDTO);
        }
        return result;
    }

    @Override
    public String toString() {
        return "PurchaseDTO{" +
                "id=" + id +
                ", vendor='" + vendor + '\'' +
                ", date='" + date + '\'' +
                ", amount=" + amount +
                '}';
    }
}
