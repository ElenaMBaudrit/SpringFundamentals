package com.embaudrit.ninjagold.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NinjaGoldControllers {
	
	@RequestMapping("/")
	public String index (HttpSession session) {
		if (session.getAttribute("golden_reward")==null) {
			session.setAttribute("golden_reward", 0);
		}
		if (session.getAttribute("game_results")==null) {
			session.setAttribute("game_results", new ArrayList<String>());
		}
		return "index.jsp";
}
	
	@RequestMapping(path = "/process", method = RequestMethod.POST)
	public String process(@RequestParam(value = "golden_reward") String golden_reward, HttpSession session) {
		Random random = new Random();
		int gold = (int) session.getAttribute("gold"); //casting the data type into integer.
		ArrayList<String> game_results = (ArrayList<String>) session.getAttribute("game_results");
		SimpleDateFormat df = new SimpleDateFormat ("MMMM dd, yyyy HH:mm:ss a");
		String date = df.format(new Date());
	
//		Here comes the random numbers
		//https://www.javatpoint.com/understanding-toString()-method
		int randNum = 0;
		if (golden_reward.toString()=="farm".toString()) { //https://www.javatpoint.com/understanding-toString()-method
			System.out.println("Here comes the string");
		}
		
		switch (golden_reward) {
		case "farm":{
			randNum = random.nextInt(11)+10;
			game_results.add(0, "You have worked har in the farm and earned "+randNum+" gold ("+date+")");
		}break;
		case "cave":{
			randNum = random.nextInt(6)+5;
			game_results.add(0, "You entered into a cave and found "+randNum+" gold ("+date+")");
		}break;
		case "house":{
			randNum = random.nextInt(4)+2;
			game_results.add(0, "Cleaning around your house, you found "+randNum+" gold ("+date+")");
		}break;
		case "casino":{
			randNum = random.nextInt(101)-50;
			session.setAttribute("gold", gold);
			if (randNum > 0) {
				game_results.add(0, "You entered a casino and earned "+randNum+" gold. ("+date+")");
			} else {
				game_results.add(0, "You entered a casino and lost "+Math.abs(randNum)+" gold. Ouch!  ("+date+")");
			}
		}break;
		}
		gold = gold + randNum;
		session.setAttribute("gold", gold);
		return "redirect:/"; 
	}
}

//https://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html

