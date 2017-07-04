
package ru.alfa.objects.clientPhone;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;


@Root(name = "inParms")
public class InParams {

    @Element
    private String cus;

   public InParams(String cus) {
      this.cus = cus;  
   }
}
