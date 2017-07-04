
package ru.alfa.objects;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Dmitry
 */
public class Order {
    
    @SerializedName("Pins")
    private String pins;
    @SerializedName("AssetId")
    private int assetId;
    @SerializedName("GeneralAgreementId")
    private int generalAgreementId;
    @SerializedName("Operation")
    private int operation;
    @SerializedName("Quantity")
    private int quantity;
    @SerializedName("AttachmentName")
    private String attachmentName;
    @SerializedName("AttachmentBody")
    private String attachmentBody;
    @SerializedName("Amount")
    private int amount;

    public String getPins() {
        return pins;
    }

    public void setPins(String pins) {
        this.pins = pins;
    }

    public int getAssetId() {
        return assetId;
    }

    public void setAssetId(int assetId) {
        this.assetId = assetId;
    }

    public int getGeneralAgreementId() {
        return generalAgreementId;
    }

    public void setGeneralAgreementId(int generalAgreementId) {
        this.generalAgreementId = generalAgreementId;
    }

    public int getOperation() {
        return operation;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getAttachmentName() {
        return attachmentName;
    }

    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName;
    }

    public String getAttachmentBody() {
        return attachmentBody;
    }

    public void setAttachmentBody(String attachmentBody) {
        this.attachmentBody = attachmentBody;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    
    
}
