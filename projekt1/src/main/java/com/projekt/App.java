package com.projekt;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        WebClient webClient = new WebClient();
        HtmlPage page = null;
        try {
            page = webClient.getPage("https://gera.dhge.de/SelfService/start.php");
        } catch (IOException e) {
            e.printStackTrace();
        }
        HtmlForm form = page.getForms().get(0);
        System.out.println(form);
        String user = "123";
        String pw = "123";

        form.getInputByName("matrnr").setValueAttribute(user);
        form.getInputByName("passw").setValueAttribute(pw);
        try {
            HtmlPage page2 = form.getButtonByName("Notenauskunft (Bildschirm)").click();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
