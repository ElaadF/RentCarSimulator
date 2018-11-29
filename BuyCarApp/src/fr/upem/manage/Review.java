/**
 * Review.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.upem.manage;

public class Review  implements java.io.Serializable {
    private long client;

    private java.lang.String comment;

    private java.lang.Long idVehicle;

    private short mark;

    public Review() {
    }

    public Review(
           long client,
           java.lang.String comment,
           java.lang.Long idVehicle,
           short mark) {
           this.client = client;
           this.comment = comment;
           this.idVehicle = idVehicle;
           this.mark = mark;
    }


    /**
     * Gets the client value for this Review.
     * 
     * @return client
     */
    public long getClient() {
        return client;
    }


    /**
     * Sets the client value for this Review.
     * 
     * @param client
     */
    public void setClient(long client) {
        this.client = client;
    }


    /**
     * Gets the comment value for this Review.
     * 
     * @return comment
     */
    public java.lang.String getComment() {
        return comment;
    }


    /**
     * Sets the comment value for this Review.
     * 
     * @param comment
     */
    public void setComment(java.lang.String comment) {
        this.comment = comment;
    }


    /**
     * Gets the idVehicle value for this Review.
     * 
     * @return idVehicle
     */
    public java.lang.Long getIdVehicle() {
        return idVehicle;
    }


    /**
     * Sets the idVehicle value for this Review.
     * 
     * @param idVehicle
     */
    public void setIdVehicle(java.lang.Long idVehicle) {
        this.idVehicle = idVehicle;
    }


    /**
     * Gets the mark value for this Review.
     * 
     * @return mark
     */
    public short getMark() {
        return mark;
    }


    /**
     * Sets the mark value for this Review.
     * 
     * @param mark
     */
    public void setMark(short mark) {
        this.mark = mark;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Review)) return false;
        Review other = (Review) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.client == other.getClient() &&
            ((this.comment==null && other.getComment()==null) || 
             (this.comment!=null &&
              this.comment.equals(other.getComment()))) &&
            ((this.idVehicle==null && other.getIdVehicle()==null) || 
             (this.idVehicle!=null &&
              this.idVehicle.equals(other.getIdVehicle()))) &&
            this.mark == other.getMark();
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
        _hashCode += new Long(getClient()).hashCode();
        if (getComment() != null) {
            _hashCode += getComment().hashCode();
        }
        if (getIdVehicle() != null) {
            _hashCode += getIdVehicle().hashCode();
        }
        _hashCode += getMark();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Review.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://manage.upem.fr", "Review"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("client");
        elemField.setXmlName(new javax.xml.namespace.QName("http://manage.upem.fr", "client"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comment");
        elemField.setXmlName(new javax.xml.namespace.QName("http://manage.upem.fr", "comment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idVehicle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://manage.upem.fr", "idVehicle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mark");
        elemField.setXmlName(new javax.xml.namespace.QName("http://manage.upem.fr", "mark"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
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
