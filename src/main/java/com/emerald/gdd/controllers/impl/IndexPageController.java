package com.emerald.gdd.controllers.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.emerald.gdd.controllers.model.EmeraldGDDPageController;


@Controller
@RequestMapping(value = "")
public class IndexPageController implements EmeraldGDDPageController
{
	private static final String INDEX_PAGE = "index";

	@GetMapping()
	@Override
	public String doGet()
	{
		return INDEX_PAGE;
	}
}
