package org.susi.integration.common.beans;
 

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.jms.JmsSendingMessageHandler;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.susi.integration.CentralConfig;

@Configuration
@EnableIntegration
public class LogJmsSender {

	Logger log = Logger.getLogger(LogJmsSender.class);
 
	@Autowired
	CentralConfig centralConfig;
	
	@Autowired
	@Qualifier("solaceTopicSenderTemplate")
	JmsTemplate solaceTopicSenderTemplate;
	
    @Bean("azureLogChannel")
    public MessageChannel azureLogChannel() {
       DirectChannel dc = new DirectChannel();
       return dc;
    }
    
    @Bean
	@ServiceActivator(inputChannel = "azureLogChannel")
	public MessageHandler jmsLogMessageHandler() {
	  JmsSendingMessageHandler handler = new JmsSendingMessageHandler(solaceTopicSenderTemplate);
	  handler.setDestinationName(centralConfig.getLogJmsDestination());
	  return handler;
	}

}