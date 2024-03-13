import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class FarmManagementApp extends JFrame implements ActionListener {
    private JButton calculateButton;
    private JButton weatherButton;
    private JButton exitButton;
    private JTextField nameField;
    private JComboBox<String> commodityComboBox;
    private JTextField quantityField;

    public FarmManagementApp() {
        setTitle("Farm Management App");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        nameField = new JTextField(15);
        commodityComboBox = new JComboBox<>(new String[]{"Maize", "Beans", "Potatoes"});
        quantityField = new JTextField(5);
        calculateButton = new JButton("Calculate Total Income");
        weatherButton = new JButton("View Weather Information");
        exitButton = new JButton("Exit");

        calculateButton.addActionListener(this);
        weatherButton.addActionListener(this);
        exitButton.addActionListener(this);

        add(new JLabel("Name: "));
        add(nameField);
        add(new JLabel("Commodity Bought: "));
        add(commodityComboBox);
        add(new JLabel("Quantity Bought: "));
        add(quantityField);
        add(calculateButton);
        add(weatherButton);
        add(exitButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            calculateTotalIncome();
        } else if (e.getSource() == weatherButton) {
            displayWeatherInformation();
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

    private void calculateTotalIncome() {
        String name = nameField.getText();
        String commodity = (String) commodityComboBox.getSelectedItem();
        int quantity = Integer.parseInt(quantityField.getText());

        CropMarketInformation cropBought = new CropMarketInformation(getCommodityPrice(commodity), commodity);
        Customer customer = new Customer(name, cropBought, quantity);

        // Calculate total spent by the customer
        double totalSpent = customer.calculateTotalSpent();

        // Display customer details and total spent
        JOptionPane.showMessageDialog(this,
                "Customer Name: " + customer.getName() + "\n" +
                        "Crop Bought: " + customer.getCropBought().getCropType() + "\n" +
                        "Number of Crops Bought: " + customer.getNumberOfCropsBought() + "\n" +
                        "Total Spent: Ksh " + totalSpent);
    }

    private void displayWeatherInformation() {
        // Implement weather information display here
        JOptionPane.showMessageDialog(this, "Weather information not available yet.");
    }

    private double getCommodityPrice(String commodity) {
        // Dummy method to retrieve commodity price based on commodity type
        switch (commodity) {
            case "Maize":
                return 200;
            case "Beans":
                return 300;
            case "Potatoes":
                return 250;
            default:
                return 0; // Default price if commodity is not found
        }
    }

    public static void main(String[] args) {
        new FarmManagementApp();
    }
}
