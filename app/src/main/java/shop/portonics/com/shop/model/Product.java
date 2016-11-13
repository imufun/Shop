package shop.portonics.com.shop.model;

/**
 * Created by imran on 11/13/2016.
 */

public class Product {

    public int ProductID;
    public String ProductName;
    public int CatId;
    public int BrandId;
    public String BodyText;
    public double Price;
    public String ImageUrl;
    public boolean Type;

    public Product(int productID, String productName, int catId, int brandId, String bodyText, double price, String imageUrl, boolean type) {
        ProductID = productID;
        ProductName = productName;
        CatId = catId;
        BrandId = brandId;
        BodyText = bodyText;
        Price = price;
        ImageUrl = imageUrl;
        Type = type;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int productID) {
        ProductID = productID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public int getCatId() {
        return CatId;
    }

    public void setCatId(int catId) {
        CatId = catId;
    }

    public int getBrandId() {
        return BrandId;
    }

    public void setBrandId(int brandId) {
        BrandId = brandId;
    }

    public String getBodyText() {
        return BodyText;
    }

    public void setBodyText(String bodyText) {
        BodyText = bodyText;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public boolean isType() {
        return Type;
    }

    public void setType(boolean type) {
        Type = type;
    }
}
