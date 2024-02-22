
class MarketInformation {
    private double commodityPrices;

 
    public MarketInformation(double commodityPrices) {
        this.commodityPrices = commodityPrices;
    }


    public double getCommodityPrices() {
        return commodityPrices;
    }
}


class CropMarketInformation extends MarketInformation {
    private String cropType;

    public CropMarketInformation(double commodityPrices, String cropType) {
        super(commodityPrices);
        this.cropType = cropType;
    }

    public String getCropType() {
        return cropType;
    }
}


class Customer {
    private String name;
    private CropMarketInformation cropBought;
    private int numberOfCropsBought;

 
    public Customer(String name, CropMarketInformation cropBought, int numberOfCropsBought) {
        this.name = name;
        this.cropBought = cropBought;
        this.numberOfCropsBought = numberOfCropsBought;
    }


    public String getName() {
        return name;
    }

    public CropMarketInformation getCropBought() {
        return cropBought;
    }

    public int getNumberOfCropsBought() {
        return numberOfCropsBought;
    }

    public double calculateTotalSpent() {
        return cropBought.getCommodityPrices() * numberOfCropsBought;
    }
}

public class FarmManagementApp {
    public static void main(String[] args) {
        CropMarketInformation crop1 = new CropMarketInformation(200, "Maize");
        CropMarketInformation crop2 = new CropMarketInformation(300, "Beans");
        CropMarketInformation crop3 = new CropMarketInformation(250, "Potatoes");

        Customer[] customers = {
            new Customer("John", crop1, 3),
            new Customer("Alice", crop2, 5), 
            new Customer("Kamau", crop3, 4)
        };

        double totalIncome = 0;

        for (Customer customer : customers) {
            double totalSpent = customer.calculateTotalSpent();
            totalIncome += totalSpent;

            System.out.println("Customer Name: " + customer.getName());
            System.out.println("Crop Bought: " + customer.getCropBought().getCropType());
            System.out.println("Number of Crops Bought: " + customer.getNumberOfCropsBought());
            System.out.println("Total Spent: Ksh " + totalSpent);
            System.out.println();
        }

        System.out.println("Total Income: Ksh " + totalIncome);
    }
}
