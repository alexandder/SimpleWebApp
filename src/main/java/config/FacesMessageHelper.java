/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/*
    Przy zmianie podstrony i tak nie dziala, bo zmienia sie kontekst. 
    Trzeba by znalezc sposob na wydobycie tej wiadomosci na nowej podstronie. 
    Zaczalem cos kombinowac z klasa UIComponent, zeby sie dobrac do konkretnego pola, 
    ale jeszcze tego nie rozwiazalem do konca.
*/


public class FacesMessageHelper {
    
    public static void addFacesMessage(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, ""));
    }
    
}
