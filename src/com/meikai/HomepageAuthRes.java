package com.meikai;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for homepageAuthRes complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;homepageAuthRes&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;description&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;epgGroupNMB&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;mac&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;products&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;returnCode&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;stbId&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;tokenExpiredTime&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;userGroupNMB&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;userID&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "homepageAuthRes", propOrder = { "description", "epgGroupNMB",
		"mac", "products", "returnCode", "stbId", "tokenExpiredTime",
		"userGroupNMB", "userID" })
public class HomepageAuthRes {

	protected String description;
	protected String epgGroupNMB;
	protected String mac;
	protected String products;
	protected String returnCode;
	protected String stbId;
	protected String tokenExpiredTime;
	protected String userGroupNMB;
	protected String userID;

	/**
	 * Gets the value of the description property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the value of the description property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * Gets the value of the epgGroupNMB property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getEpgGroupNMB() {
		return epgGroupNMB;
	}

	/**
	 * Sets the value of the epgGroupNMB property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEpgGroupNMB(String value) {
		this.epgGroupNMB = value;
	}

	/**
	 * Gets the value of the mac property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMac() {
		return mac;
	}

	/**
	 * Sets the value of the mac property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMac(String value) {
		this.mac = value;
	}

	/**
	 * Gets the value of the products property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getProducts() {
		return products;
	}

	/**
	 * Sets the value of the products property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setProducts(String value) {
		this.products = value;
	}

	/**
	 * Gets the value of the returnCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getReturnCode() {
		return returnCode;
	}

	/**
	 * Sets the value of the returnCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setReturnCode(String value) {
		this.returnCode = value;
	}

	/**
	 * Gets the value of the stbId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getStbId() {
		return stbId;
	}

	/**
	 * Sets the value of the stbId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setStbId(String value) {
		this.stbId = value;
	}

	/**
	 * Gets the value of the tokenExpiredTime property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTokenExpiredTime() {
		return tokenExpiredTime;
	}

	/**
	 * Sets the value of the tokenExpiredTime property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTokenExpiredTime(String value) {
		this.tokenExpiredTime = value;
	}

	/**
	 * Gets the value of the userGroupNMB property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getUserGroupNMB() {
		return userGroupNMB;
	}

	/**
	 * Sets the value of the userGroupNMB property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setUserGroupNMB(String value) {
		this.userGroupNMB = value;
	}

	/**
	 * Gets the value of the userID property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * Sets the value of the userID property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setUserID(String value) {
		this.userID = value;
	}

}
