package com.tcs.bfscoe.mobilebanking.service.v1;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tcs.bfscoe.mobilebanking.domain.Tool;
import com.tcs.bfscoe.mobilebanking.repository.ToolsRepository;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@Api(value = "tools", description = "Banking App Tools Master API")
public class ToolsController {

	@Autowired
	public ToolsRepository toolsRepository;

	/**
	 *
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/v1/tools")
	@ApiOperation(value = "Retrieves all Tools", response=Tool.class, responseContainer= "List")
	public ResponseEntity<List<Tool>> getAllTools() {

		List<Tool> allTools = toolsRepository.findAll();
		System.out.println(allTools);
		return new ResponseEntity<List<Tool>>(allTools, HttpStatus.OK);
	}

	/**
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/v1/tools/{id}")
	@ApiOperation(value = "Retrieves all tools from Tools Master")
	public ResponseEntity<Tool> getToolDetails(@PathVariable("id") String id) {

		Tool tool = toolsRepository.findOne(id);
		return new ResponseEntity<Tool>(tool, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Create a new Tool entry")
	@RequestMapping(method = RequestMethod.POST, value = "/v1/tools", consumes = "application/json")
	public ResponseEntity<Void> createTool(@RequestBody Tool tool) {

		// Set the location header for the newly created resource
		HttpHeaders responseHeaders = new HttpHeaders();

			toolsRepository.save(tool);

			URI newUserUri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand().toUri();
			responseHeaders.setLocation(newUserUri);

		return new ResponseEntity<Void>(null, responseHeaders, HttpStatus.CREATED);
	}
	
}
