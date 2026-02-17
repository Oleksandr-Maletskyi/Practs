package Assignment1;

public class GodShopService {
    // TODO: split responsibilities into separate services.
    public void registerUser(String email) {
    }

    public void addProduct(String name, double price) {
    }

    public void createOrder(String userEmail, String productName) {
    }

    public void payOrder(long orderId) {
    }

    public void sendEmail(String email, String message) {
    }

    public void exportReport(String fromDate, String toDate) {
    }
}
/*Я виніс registerUser в ShopUserService,
  addProduct createOrder payOrder в ShopOrderService,
  sendEmail в ShopNotificationService і
  exportReport в ShopReportingService
*/
