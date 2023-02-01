package com.general.objet;

import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class Mail {
	private String mail = "noreply.generalressort@gmail.com";
	private String password = "vayahtqyqtuqemcu";
	
	private String msg = "";
	private double price = 0;
	
	public void sendMail(User utilisateur, ListeArticles listeArticles) {
	Properties props = new Properties();
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.starttls.enable","true");
	props.put("mail.smtp.host","smtp.gmail.com");
	props.put("mail.smtp.port","587");
	
	Session session = Session.getInstance(props, new javax.mail.Authenticator() 
									{ 
										protected PasswordAuthentication getPasswordAuthentication() 
										{
										return new PasswordAuthentication(mail, password); 
										}
									});
	
		try {
			// Etape 2 : Cr�ation de l'objet Message
			Message message = new MimeMessage(session);
			
			message.setFrom(new InternetAddress(mail));
			message.setRecipients(Message.RecipientType.TO,
			InternetAddress.parse(utilisateur.getMail()));
			//OBJET.
			message.setSubject("Confirmation d'achat GENERAL RESSORT");
			
			msg+= "Bonjour "+utilisateur.getPrenom()+", Nous vous remercions de votre achat, ce mail constitut un recapitulatif/justificatif de votre achat\n";
			msg+= " Recapitulatif :\n";
			msg+= "id, nom, reference, prix, quantite, prix\n";
			
			List<Charriot> c = listeArticles.getCharriot();

			for (int i=0; i<listeArticles.getCharriotlength();i++) {
				msg+= c.get(i).getArticle().getId() + " ";
				msg+= c.get(i).getArticle().getNom() + " ";
				msg+= c.get(i).getArticle().getReference() + " ";
				msg+= c.get(i).getArticle().getPrix()  + " ";
				msg+= c.get(i).getQuantity()  + " ";
				price += c.get(i).getArticle().getPrix() * c.get(i).getQuantity();
				msg+= c.get(i).getArticle().getPrix() * c.get(i).getQuantity() + "\n";
			}
			
			msg+= "Total = "+price+"\n";
			msg+= "Avec reduction, Total = "+listeArticles.getFullPrice()+"\n";
			
				
			msg+="En esperant vous revoir bient�t! l'equipe general ressort.";
			
			
			//MESSAGE.
			message.setText(msg);
			
			
			
			
			// Etape 3 : Envoyer le message
			Transport.send(message);
		} catch (MessagingException e) {
		throw new RuntimeException(e);
		} 
	}
}
