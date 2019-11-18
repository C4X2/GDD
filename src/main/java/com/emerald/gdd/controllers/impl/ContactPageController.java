package com.emerald.gdd.controllers.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.emerald.gdd.controllers.model.EmeraldGDDPageController;

@Controller
@RequestMapping(value = "/contact")
public class ContactPageController implements EmeraldGDDPageController
{

	private static final String CONTACT_PAGE = "contact";

	@GetMapping()
	@Override
	public String doGet()
	{
		return CONTACT_PAGE;
	}

}
