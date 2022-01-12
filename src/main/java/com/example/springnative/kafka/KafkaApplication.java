package com.example.springnative.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.nativex.hint.MethodHint;
import org.springframework.nativex.hint.NativeHint;
import org.springframework.nativex.hint.TypeHint;

//==============================================================================
//  Spring Native specific
//==============================================================================
// Hint found at https://github.com/spring-projects-experimental/spring-native/blob/main/samples/kafka
// No effect? Maybe we are breaking before getting to the part where it is needed
//@NativeHint(
//		trigger = org.springframework.kafka.annotation.KafkaListenerConfigurationSelector.class,
//		types = {@TypeHint(types={org.springframework.kafka.annotation.KafkaBootstrapConfiguration.class})})
//@NativeHint(options = {"--enable-url-protocols=https"})

// Hints added by trying to fix log messages
@TypeHint(types = {org.apache.kafka.common.security.plain.PlainLoginModule.class})
@TypeHint(types = {org.apache.kafka.common.security.authenticator.SaslClientCallbackHandler.class}, methods = @MethodHint(name = "<init>"))
@TypeHint(types = {org.apache.kafka.common.security.authenticator.DefaultLogin.class}, methods = @MethodHint(name = "<init>"))
@TypeHint(types = {org.apache.kafka.common.security.authenticator.AbstractLogin.DefaultLoginCallbackHandler.class}, methods = @MethodHint(name = "<init>"))

// Added to fix the missing local_US error message
@NativeHint(options = {"-H:IncludeResourceBundles=sun.security.util.Resources"})

// Trial and Error... no effect in the final error
//@TypeHint(types = {javax.security.sasl.SaslClient.class}, methods = @MethodHint(name = "<init>"))
//@TypeHint(types = {javax.security.auth.spi.LoginModule.class}, methods = @MethodHint(name = "<init>"))
//@TypeHint(types = {org.apache.kafka.common.security.authenticator.SaslClientAuthenticator.class}, methods = @MethodHint(name = "<init>"))
//@TypeHint(types = {javax.security.sasl.SaslClient.class}, methods = @MethodHint(name = "<init>"))
//@TypeHint(types = {org.apache.kafka.common.security.scram.internals.ScramSaslClient.class}, methods = @MethodHint(name = "<init>"))
//@TypeHint(types = {org.apache.kafka.common.security.scram.internals.ScramSaslClient.ScramSaslClientFactory.class}, methods = @MethodHint(name = "<init>"))
//@TypeHint(types = {org.apache.kafka.common.security.scram.ScramLoginModule.class}, methods = @MethodHint(name = "<init>"))
//==============================================================================

@SpringBootApplication
public class KafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);
	}

}
