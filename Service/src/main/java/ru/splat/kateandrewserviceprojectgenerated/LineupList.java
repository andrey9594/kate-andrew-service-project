//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.09.17 at 01:57:45 PM MSK 
//


package ru.splat.kateandrewserviceprojectgenerated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for lineupList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="lineupList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="lineup" type="{}lineupEntry" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="team_id" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="team_name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="squad_type_id" type="{http://www.w3.org/2001/XMLSchema}short" />
 *       &lt;attribute name="squad_type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lineupList", propOrder = {
    "lineup"
})
public class LineupList {

    protected List<LineupEntry> lineup;
    @XmlAttribute(name = "team_id")
    protected Integer teamId;
    @XmlAttribute(name = "team_name")
    protected String teamName;
    @XmlAttribute(name = "squad_type_id")
    protected Short squadTypeId;
    @XmlAttribute(name = "squad_type")
    protected String squadType;

    /**
     * Gets the value of the lineup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lineup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLineup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LineupEntry }
     * 
     * 
     */
    public List<LineupEntry> getLineup() {
        if (lineup == null) {
            lineup = new ArrayList<LineupEntry>();
        }
        return this.lineup;
    }

    /**
     * Gets the value of the teamId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTeamId() {
        return teamId;
    }

    /**
     * Sets the value of the teamId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTeamId(Integer value) {
        this.teamId = value;
    }

    /**
     * Gets the value of the teamName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * Sets the value of the teamName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTeamName(String value) {
        this.teamName = value;
    }

    /**
     * Gets the value of the squadTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getSquadTypeId() {
        return squadTypeId;
    }

    /**
     * Sets the value of the squadTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setSquadTypeId(Short value) {
        this.squadTypeId = value;
    }

    /**
     * Gets the value of the squadType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSquadType() {
        return squadType;
    }

    /**
     * Sets the value of the squadType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSquadType(String value) {
        this.squadType = value;
    }

}
