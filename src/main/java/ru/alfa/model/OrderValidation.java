/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.alfa.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Dmitry
 */
@Slf4j
@Data
@ToString
public class OrderValidation {

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
