package za.co.sar.purchases.boundary;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import za.co.sar.purchases.control.PurchaseService;
import za.co.sar.purchases.entity.PurchaseDTO;

import java.util.List;

import static jakarta.ws.rs.core.Response.Status.CREATED;

@Path("/purchases")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PurchasesResource {

    @Inject
    PurchaseService purchaseService;

    @POST
    @Transactional
    public Response createPurchase(PurchaseDTO purchase) {
        purchaseService.savePurchase(purchase);
        return Response.status(CREATED).build();
    }

    @GET
    public Response allPurchases() {
        return Response.ok(purchaseService.allPurchases()).build();
    }

    @GET
    @Path("/{vendor}")
    public Response purchasesByVendor(@PathParam("vendor") String vendor) {
        return Response.ok(purchaseService.allPurchasesByVendor(vendor)).build();
    }

}
