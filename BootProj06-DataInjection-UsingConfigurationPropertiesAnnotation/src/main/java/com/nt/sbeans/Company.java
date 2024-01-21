package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component("comp")
@ConfigurationProperties(prefix = "org.nit")
@PropertySource("app.properties")
public class Company {

	private String name;
	private String addrs;
	private Long pincode;

	@Value("${nit.phone}") // @Value injection(Field)
	private long contact;// @ConfigurationProperties injection(Setter)

	@Value("${nit.size}") // @Value injection(Field)
	private Integer size;// @ConfigurationProperties injection(Setter)

}
