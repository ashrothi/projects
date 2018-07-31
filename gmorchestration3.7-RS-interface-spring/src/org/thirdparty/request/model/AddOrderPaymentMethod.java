package org.thirdparty.request.model;

public class AddOrderPaymentMethod {
	private String cardType;
	private String cardHolderName;
	private String cardToken;
	private String cardExpiryDate;
	private String transactionReference;
	private String paymentAgreementId;
	/**
	 * @return the cardType
	 */
	public String getCardType() {
		return cardType;
	}
	/**
	 * @param cardType the cardType to set
	 */
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	/**
	 * @return the cardHolderName
	 */
	public String getCardHolderName() {
		return cardHolderName;
	}
	/**
	 * @param cardHolderName the cardHolderName to set
	 */
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	/**
	 * @return the cardToken
	 */
	public String getCardToken() {
		return cardToken;
	}
	/**
	 * @param cardToken the cardToken to set
	 */
	public void setCardToken(String cardToken) {
		this.cardToken = cardToken;
	}
	/**
	 * @return the cardExpiryDate
	 */
	public String getCardExpiryDate() {
		return cardExpiryDate;
	}
	/**
	 * @param cardExpiryDate the cardExpiryDate to set
	 */
	public void setCardExpiryDate(String cardExpiryDate) {
		this.cardExpiryDate = cardExpiryDate;
	}
	/**
	 * @return the transactionReference
	 */
	public String getTransactionReference() {
		return transactionReference;
	}
	/**
	 * @param transactionReference the transactionReference to set
	 */
	public void setTransactionReference(String transactionReference) {
		this.transactionReference = transactionReference;
	}
	/**
	 * @return the paymentAgreementId
	 */
	public String getPaymentAgreementId() {
		return paymentAgreementId;
	}
	/**
	 * @param paymentAgreementId the paymentAgreementId to set
	 */
	public void setPaymentAgreementId(String paymentAgreementId) {
		this.paymentAgreementId = paymentAgreementId;
	}
	
	
	
}
