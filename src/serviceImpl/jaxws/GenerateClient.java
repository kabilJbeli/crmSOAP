
package serviceImpl.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.7.9
 * Wed May 12 21:25:33 WAT 2021
 * Generated source version: 2.7.9
 */

@XmlRootElement(name = "GenerateClient", namespace = "http://serviceImpl/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GenerateClient", namespace = "http://serviceImpl/")

public class GenerateClient {

    @XmlElement(name = "arg0")
    private model.Client arg0;

    public model.Client getArg0() {
        return this.arg0;
    }

    public void setArg0(model.Client newArg0)  {
        this.arg0 = newArg0;
    }

}

