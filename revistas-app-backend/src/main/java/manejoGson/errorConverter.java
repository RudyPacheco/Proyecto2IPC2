/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package manejoGson;

import modelo.errorBackendModel;

/**
 * 
 * @author AndaryuS
 */
public class errorConverter extends converter<errorBackendModel>{

    public errorConverter(Class<errorBackendModel> typeConverter) {
        super(typeConverter);
    }

}
