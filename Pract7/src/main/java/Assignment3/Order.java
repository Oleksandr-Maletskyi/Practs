package Assignment3;

public record Order(int id, String userEmail, double totalCents){
    public Order {
        if(id <= 0){
            throw new IllegalArgumentException("Id must be > 0");
        }
        if(userEmail == null || !userEmail.contains("@")){
            throw new IllegalArgumentException("userEmail is empty or don't contain @");
        }
        if(totalCents < 0){
            throw new IllegalArgumentException("totalCents must be >= 0");
        }
    }
}
