package com.example.springnative.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaBootstrapConfiguration;
import org.springframework.kafka.annotation.KafkaListenerConfigurationSelector;
import org.springframework.nativex.hint.MethodHint;
import org.springframework.nativex.hint.NativeHint;
import org.springframework.nativex.hint.TypeHint;

//==============================================================================
//  Spring Native specific
//==============================================================================
// Hint found at https://github.com/spring-projects-experimental/spring-native/blob/main/samples/kafka
// No effect? Maybe we are breaking before getting to the part where it is needed
@NativeHint(trigger = KafkaListenerConfigurationSelector.class, types = {@TypeHint(types={KafkaBootstrapConfiguration.class})})

// Hints added by trying to fix log messages
@TypeHint(types={org.apache.kafka.common.security.plain.PlainLoginModule.class})
@TypeHint(types = {org.apache.kafka.common.security.authenticator.SaslClientCallbackHandler.class}, methods = @MethodHint(name = "<init>"))
@TypeHint(types = {org.apache.kafka.common.security.authenticator.DefaultLogin.class}, methods = @MethodHint(name = "<init>"))
@TypeHint(types = {org.apache.kafka.common.security.authenticator.AbstractLogin.DefaultLoginCallbackHandler.class}, methods = @MethodHint(name = "<init>"))
//==============================================================================

@SpringBootApplication
public class KafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);
	}

}
