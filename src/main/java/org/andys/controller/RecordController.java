package org.andys.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.andys.domain.Record;
import org.andys.model.MyAction;
import org.andys.model.MyData;
import org.andys.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = {"","/app"})
public class RecordController {

	private final SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm"); 
	
	@Autowired
	private RecordService recordService;

	@RequestMapping(value = {"/","login"})
	public String hospital(Model model){
		//System.out.println(patientService.findAll());
		//model.addAttribute("persons", patientService.findAll());
		return "person/login";
	}

	@RequestMapping(value = "login",method = RequestMethod.POST)
	public String login(){
		return "redirect:index";

	}

	@RequestMapping(value = "index")
	public String index(Model model){
		return "person/index";
	}
//
//	@RequestMapping(value = "create")
//	public String create(){
//		return "person/create";
//	}
//
//	@RequestMapping(value = "save", method = RequestMethod.POST)
//	public String save(Record patient,Model model){
////		patientService.save(patient);
////		model.addAttribute("patient", patientService.findAll());
//		return "person/index";
//	}
//
//	@RequestMapping(value = "edit/{id}")
//	public String edit(@PathVariable Long id, Model model){
////		System.out.println(patientService.findById(id));
////		model.addAttribute("patient", patientService.findById(id));
//		return "person/edit";
//	}
//
//
//	@RequestMapping(value = "update",method = RequestMethod.POST)
//	public String update(Record patient,Model model){
////		patientService.save(patient);
//		return "redirect:index";
//	}
//
//	@RequestMapping(value = "savedoc",method = RequestMethod.POST)
//	public String saveDoc(Model model){
////		doctorService.save(doctor);
//		return "redirect:index";
//	}
//	@RequestMapping(value = "register")
//	public String registerDoc(){
//		return "person/register";
//	}

	@RequestMapping(value = "temperatures",  method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<InputStreamResource> temperatures(){
		try {
			System.out.println("getting temp");
			final MyAction myAction = new MyAction();
			Date start = dt.parse("2017-01-01 19:00");
			System.out.println(dt.format(start));
			final MyData data = recordService.getByInterval(start, new Date());

			new Thread(
					new Runnable(){
						public void run(){
								try {
									data.forEachRemaining(myAction);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						}
					}
					).start();



			return ResponseEntity.ok()
					.contentType(MediaType.TEXT_PLAIN)
					.body(new InputStreamResource(myAction.getIn()));
		} catch (IOException | ParseException e) {
			throw new RuntimeException(e);
		}
	}

}
