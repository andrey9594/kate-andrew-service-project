//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.09.17 at 01:57:45 PM MSK 
//


package ru.splat.kateandrewserviceprojectgenerated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for lineupEntry complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="lineupEntry">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="player_id" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="jersey_number" type="{http://www.w3.org/2001/XMLSchema}short" />
 *       &lt;attribute name="match_name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lineupEntry")
public class LineupEntry {

    @XmlAttribute(name = "player_id")
    protected Integer playerId;
    @XmlAttribute(name = "jersey_number")
    protected Short jerseyNumber;
    @XmlAttribute(name = "match_name")
    protected String matchName;

    /**
     * Gets the value of the playerId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPlayerId() {
        return playerId;
    }

    /**
     * Sets the value of the playerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPlayerId(Integer value) {
        this.playerId = value;
    }

    /**
     * Gets the value of the jerseyNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getJerseyNumber() {
        return jerseyNumber;
    }

    /**
     * Sets the value of the jerseyNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setJerseyNumber(Short value) {
        this.jerseyNumber = value;
    }

    /**
     * Gets the value of the matchName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMatchName() {
        return matchName;
    }

    /**
     * Sets the value of the matchName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMatchName(String value) {
        this.matchName = value;
    }

}