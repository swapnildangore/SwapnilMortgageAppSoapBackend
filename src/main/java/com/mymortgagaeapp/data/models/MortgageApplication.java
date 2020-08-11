//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.08.11 at 02:53:50 PM IST 
//


package com.mymortgagaeapp.data.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MortgageApplication complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MortgageApplication"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="mortgageId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="offerId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="productId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="offerDate" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="createdDate" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="offerExpired" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MortgageApplication", propOrder = {
    "mortgageId",
    "version",
    "offerId",
    "productId",
    "offerDate",
    "createdDate",
    "offerExpired"
})
public class MortgageApplication {

    @XmlElement(required = true)
    protected String mortgageId;
    @XmlElement(required = true)
    protected String version;
    @XmlElement(required = true)
    protected String offerId;
    @XmlElement(required = true)
    protected String productId;
    @XmlElement(required = true)
    protected String offerDate;
    @XmlElement(required = true)
    protected String createdDate;
    protected boolean offerExpired;

    /**
     * Gets the value of the mortgageId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMortgageId() {
        return mortgageId;
    }

    /**
     * Sets the value of the mortgageId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMortgageId(String value) {
        this.mortgageId = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the offerId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOfferId() {
        return offerId;
    }

    /**
     * Sets the value of the offerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOfferId(String value) {
        this.offerId = value;
    }

    /**
     * Gets the value of the productId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductId() {
        return productId;
    }

    /**
     * Sets the value of the productId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductId(String value) {
        this.productId = value;
    }

    /**
     * Gets the value of the offerDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOfferDate() {
        return offerDate;
    }

    /**
     * Sets the value of the offerDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOfferDate(String value) {
        this.offerDate = value;
    }

    /**
     * Gets the value of the createdDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatedDate() {
        return createdDate;
    }

    /**
     * Sets the value of the createdDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatedDate(String value) {
        this.createdDate = value;
    }

    /**
     * Gets the value of the offerExpired property.
     * 
     */
    public boolean isOfferExpired() {
        return offerExpired;
    }

    /**
     * Sets the value of the offerExpired property.
     * 
     */
    public void setOfferExpired(boolean value) {
        this.offerExpired = value;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mortgageId == null) ? 0 : mortgageId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MortgageApplication other = (MortgageApplication) obj;
		if (mortgageId == null) {
			if (other.mortgageId != null)
				return false;
		} else if (!mortgageId.equals(other.mortgageId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MortgageApplication [mortgageId=" + mortgageId + ", version=" + version + ", offerId=" + offerId
				+ ", productId=" + productId + ", offerDate=" + offerDate + ", createdDate=" + createdDate
				+ ", offerExpired=" + offerExpired + "]";
	}

}
