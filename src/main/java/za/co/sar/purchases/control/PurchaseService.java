package za.co.sar.purchases.control;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import za.co.sar.purchases.entity.PurchaseDTO;
import za.co.sar.purchases.entity.PurchasesEntity;

import java.util.List;

@RequestScoped
public class PurchaseService {

    @Inject
    EntityManager em;
    @RestClient
    ReceiptsResource receiptsResource;

    @Transactional
    public void savePurchase(PurchaseDTO purchase) {
        // API call to get receipt before persisting...
        System.out.println(receiptsResource.getReceipt());
        em.persist(purchase.toEntity());
    }

    public List<PurchaseDTO> allPurchases() {
        return PurchaseDTO.toDTOList(em
                .createNamedQuery(PurchasesEntity.PURCHASES_FIND_ALL, PurchasesEntity.class)
                .getResultList());
    }

    public List<PurchaseDTO> allPurchasesByVendor(String vendor) {
        return PurchaseDTO.toDTOList(em
                .createNamedQuery(PurchasesEntity.PURCHASES_FIND_BY_VENDOR, PurchasesEntity.class)
                .setParameter("vendor", vendor)
                .getResultList());
    }

}
