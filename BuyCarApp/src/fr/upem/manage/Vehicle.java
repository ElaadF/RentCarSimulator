/**
 * Vehicle.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.upem.manage;

public class Vehicle  implements java.io.Serializable {
    private int ageRequired;

    private java.lang.String brand;

    private double buyPrice;

    private long id;

    private java.lang.String model;

    private int nbRented;

    private double rentPrice;

    public Vehicle() {
    }

    public Vehicle(
           int ageRequired,
           java.lang.String brand,
           double buyPrice,
           long id,
           java.lang.String model,
           int nbRented,
           double rentPrice) {
           this.ageRequired = ageRequired;
           this.brand = brand;
           this.buyPrice = buyPrice;
           this.id = id;
           this.model = model;
           this.nbRented = nbRented;
           this.rentPrice = rentPrice;
    }


    /**
     * Gets the ageRequired value for this Vehicle.
     * 
     * @return ageRequired
     */
    public int getAgeRequired() {
        return ageRequired;
    }


    /**
     * Sets the ageRequired value for this Vehicle.
     * 
     * @param ageRequired
     */
    public void setAgeRequired(int ageRequired) {
        this.ageRequired = ageRequired;
    }


    /**
     * Gets the brand value for this Vehicle.
     * 
     * @return brand
     */
    public java.lang.String getBrand() {
        return brand;
    }


    /**
     * Sets the brand value for this Vehicle.
     * 
     * @param brand
     */
    public void setBrand(java.lang.String brand) {
        this.brand = brand;
    }


    /**
     * Gets the buyPrice value for this Vehicle.
     * 
     * @return buyPrice
     */
    public double getBuyPrice() {
        return buyPrice;
    }


    /**
     * Sets the buyPrice value for this Vehicle.
     * 
     * @param buyPrice
     */
    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }


    /**
     * Gets the id value for this Vehicle.
     * 
     * @return id
     */
    public long getId() {
        return id;
    }


    /**
     * Sets the id value for this Vehicle.
     * 
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }


    /**
     * Gets the model value for this Vehicle.
     * 
     * @return model
     */
    public java.lang.String getModel() {
        return model;
    }


    /**
     * Sets the model value for this Vehicle.
     * 
     * @param model
     */
    public void setModel(java.lang.String model) {
        this.model = model;
    }


    /**
     * Gets the nbRented value for this Vehicle.
     * 
     * @return nbRented
     */
    public int getNbRented() {
        return nbRented;
    }


    /**
     * Sets the nbRented value for this Vehicle.
     * 
     * @param nbRented
     */
    public void setNbRented(int nbRented) {
        this.nbRented = nbRented;
    }


    /**
     * Gets the rentPrice value for this Vehicle.
     * 
     * @return rentPrice
     */
    public double getRentPrice() {
        return rentPrice;
    }


    /**
     * Sets the rentPrice value for this Vehicle.
     * 
     * @param rentPrice
     */
    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Vehicle)) return false;
        Vehicle other = (Vehicle) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.ageRequired == other.getAgeRequired() &&
            ((this.brand==null && other.getBrand()==null) || 
             (this.brand!=null &&
              this.brand.equals(other.getBrand()))) &&
            this.buyPrice == other.getBuyPrice() &&
            this.id == other.getId() &&
            ((this.model==null && other.getModel()==null) || 
             (this.model!=null &&
              this.model.equals(other.getModel()))) &&
            this.nbRented == other.getNbRented() &&
            this.rentPrice == other.getRentPrice();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getAgeRequired();
        if (getBrand() != null) {
            _hashCode += getBrand().hashCode();
        }
        _hashCode += new Double(getBuyPrice()).hashCode();
        _hashCode += new Long(getId()).hashCode();
        if (getModel() != null) {
            _hashCode += getModel().hashCode();
        }
        _hashCode += getNbRented();
        _hashCode += new Double(getRentPrice()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Vehicle.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://manage.upem.fr", "Vehicle"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ageRequired");
        elemField.setXmlName(new javax.xml.namespace.QName("http://manage.upem.fr", "ageRequired"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("brand");
        elemField.setXmlName(new javax.xml.namespace.QName("http://manage.upem.fr", "brand"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("buyPrice");
        elemField.setXmlName(new javax.xml.namespace.QName("http://manage.upem.fr", "buyPrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://manage.upem.fr", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("model");
        elemField.setXmlName(new javax.xml.namespace.QName("http://manage.upem.fr", "model"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nbRented");
        elemField.setXmlName(new javax.xml.namespace.QName("http://manage.upem.fr", "nbRented"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rentPrice");
        elemField.setXmlName(new javax.xml.namespace.QName("http://manage.upem.fr", "rentPrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
