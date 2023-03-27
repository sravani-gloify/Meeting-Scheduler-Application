package com.jcg.mapstruct.service;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import com.jcg.mapstruct.dto.CalendarDto;
import com.jcg.mapstruct.dto.EmailDto;

import biweekly.Biweekly;
import biweekly.ICalendar;
import biweekly.component.VEvent;
import biweekly.parameter.ParticipationLevel;
import biweekly.property.Attendee;
import biweekly.property.Method;
import biweekly.util.Duration;


@Service
public class EmailService {
	
	
	@Autowired
	private JavaMailSender javaMailSender;
    
	
	public void sendEmail(EmailDto emailDto)
	{
		SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
		if (!CollectionUtils.isEmpty(emailDto.getToList())) {
		String[] toList=emailDto.getToList().toArray(new String[0]);
			simpleMailMessage.setTo(toList);

			
		} else {
			simpleMailMessage.setTo(emailDto.getTo());
		}

		simpleMailMessage.setSubject(emailDto.getSubject());
		simpleMailMessage.setText(emailDto.getMessage());
		javaMailSender.send(simpleMailMessage);
	}

	public void sendCalendarInvite(CalendarDto calendarDto)throws IOException,MessagingException
	{
		MimeMessage  mimeMessage= javaMailSender.createMimeMessage();
		mimeMessage.setRecipients(Message.RecipientType.TO,getToAddress(calendarDto.getAttendees()));
		mimeMessage.setSubject(calendarDto.getSubject());
		
		MimeMultipart mimeMultipart=new MimeMultipart("Mixed");
		mimeMultipart.addBodyPart(getAttachmentMimeBodyPart());
		mimeMultipart.addBodyPart(createCalendarMimeBody(calendarDto));
		mimeMessage.setContent(mimeMultipart);
		javaMailSender.send(mimeMessage);
	}
	private BodyPart createCalendarMimeBody(CalendarDto calendarDto)throws IOException,MessagingException {
		MimeBodyPart calendarBody =new MimeBodyPart();
		final DataSource source= new ByteArrayDataSource(createCal(calendarDto),"text/calendar; charset=UTF-8");
		calendarBody.setDataHandler(new DataHandler(source));
		calendarBody.setHeader("content-type","text/calendar; charset=UTF-8; method=REQUEST");
		return calendarBody;
	}


	private String createCal(CalendarDto calendarDto) {
		ICalendar calendar=new ICalendar();
		calendar.addProperty(new Method(Method.REQUEST));
		VEvent  event=new VEvent();
		event.setUrl(calendarDto.getMeetingLink());
		event.setDescription(calendarDto.getDescription());
		event.setDateStart(getStartDate(calendarDto.getEventDateTime()));
		event.setSummary(calendarDto.getSummary());
		event.setDuration(new Duration.Builder().hours(1).build());
		event.setOrganizer(calendarDto.getOrganizer());
		addAttendees(event,calendarDto.getAttendees());
		calendar.addEvent(event);
		return Biweekly.write(calendar).go();
	}

	private void addAttendees(VEvent vEvent,List<Attendee> attendees) {
		for(Attendee attendee:attendees)
		{
			attendee.setParticipationLevel(ParticipationLevel.REQUIRED);
			vEvent.addAttendee(attendee);
		}
		
	}
	private Date getStartDate(LocalDateTime eventDateTime)
	{
		Instant instant =eventDateTime.atZone(ZoneId.systemDefault()).toInstant();
		return Date.from(instant);
		
	}

	private  MimeBodyPart getAttachmentMimeBodyPart()throws IOException,MessagingException {
		File file=new  File(" ");
		MimeBodyPart attachmentMimeBodyPart=new MimeBodyPart();
		attachmentMimeBodyPart.attachFile(file);
		return attachmentMimeBodyPart;
	}

	private Address[] getToAddress(List<Attendee> attendees) {
		return attendees.stream().map(attendee ->{
			Address address=null;
			try {
				address=new InternetAddress(attendee.getEmail());
				
			}catch (AddressException e) {
				e.printStackTrace();
			}
			return address;
		}).collect(Collectors.toList()).toArray(new InternetAddress[0]);
		
	}


	public JavaMailSender getJavaMailSender() {
		return javaMailSender;
	}

	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	

}

	