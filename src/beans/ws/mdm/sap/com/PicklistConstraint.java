/**
 * PicklistConstraint.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package beans.ws.mdm.sap.com;

public class PicklistConstraint  extends base.core.mdm.sap.com.AbstractDataObject  implements java.io.Serializable {
    private java.lang.String expressionOperator;

    private beans.ws.mdm.sap.com.RecordIdentifierConstraint[] value;

    public PicklistConstraint() {
    }

    public PicklistConstraint(
           java.lang.String expressionOperator,
           beans.ws.mdm.sap.com.RecordIdentifierConstraint[] value) {
        this.expressionOperator = expressionOperator;
        this.value = value;
    }


    /**
     * Gets the expressionOperator value for this PicklistConstraint.
     * 
     * @return expressionOperator
     */
    public java.lang.String getExpressionOperator() {
        return expressionOperator;
    }


    /**
     * Sets the expressionOperator value for this PicklistConstraint.
     * 
     * @param expressionOperator
     */
    public void setExpressionOperator(java.lang.String expressionOperator) {
        this.expressionOperator = expressionOperator;
    }


    /**
     * Gets the value value for this PicklistConstraint.
     * 
     * @return value
     */
    public beans.ws.mdm.sap.com.RecordIdentifierConstraint[] getValue() {
        return value;
    }


    /**
     * Sets the value value for this PicklistConstraint.
     * 
     * @param value
     */
    public void setValue(beans.ws.mdm.sap.com.RecordIdentifierConstraint[] value) {
        this.value = value;
    }

    public beans.ws.mdm.sap.com.RecordIdentifierConstraint getValue(int i) {
        return this.value[i];
    }

    public void setValue(int i, beans.ws.mdm.sap.com.RecordIdentifierConstraint _value) {
        this.value[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PicklistConstraint)) return false;
        PicklistConstraint other = (PicklistConstraint) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.expressionOperator==null && other.getExpressionOperator()==null) || 
             (this.expressionOperator!=null &&
              this.expressionOperator.equals(other.getExpressionOperator()))) &&
            ((this.value==null && other.getValue()==null) || 
             (this.value!=null &&
              java.util.Arrays.equals(this.value, other.getValue())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getExpressionOperator() != null) {
            _hashCode += getExpressionOperator().hashCode();
        }
        if (getValue() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getValue());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getValue(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PicklistConstraint.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:com.sap.mdm.ws.beans", "PicklistConstraint"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("expressionOperator");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:com.sap.mdm.ws.beans", "expressionOperator"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("value");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:com.sap.mdm.ws.beans", "value"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:com.sap.mdm.ws.beans", "RecordIdentifierConstraint"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
