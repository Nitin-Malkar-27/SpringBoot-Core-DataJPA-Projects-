package com.nt.runeer;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.document.PlayerInfo;
import com.nt.service.IPlayerMgmtService;

@Component
public class IPlayerTypesTestRunner implements CommandLineRunner {

	@Autowired
	private IPlayerMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		PlayerInfo info = new PlayerInfo();
		info.setPid(new Random().nextInt(1000));
		info.setPname("jadeja");
		info.setPaddrs("jaipur");

		info.setNickNames(List.of("jaddu", "jadu", "sir"));
		info.setFriends(new String[] { "dhoni", "ashwin", "raina", "rohit" });
		info.setImpKnoks(Map.of("asia cup", "35 runs", "2019 world cup semi final", "60+ runs"));
		info.setContactumbers(Set.of(555555555L, 44444444L, 777777777L));

		Properties props = new Properties();
		props.put("addhar", "23424324542");
		props.put("pancard", "ASPUF2532A");
		info.setIdDetails(props);

		System.out.println(service.registerPlayer(info));

	}

}
