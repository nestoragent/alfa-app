package ru.alfa.model;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author Dmitry
 */
@Data
@ToString
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


}
