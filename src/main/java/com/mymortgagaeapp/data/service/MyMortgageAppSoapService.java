/**
 * 
 */
package com.mymortgagaeapp.data.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.mymortgagaeapp.data.models.CreateOrUpdateApplicationRequest;
import com.mymortgagaeapp.data.models.CreateOrUpdateApplicationResponse;
import com.mymortgagaeapp.data.models.GetAllApplicationsRequest;
import com.mymortgagaeapp.data.models.GetAllApplicationsResponse;
import com.mymortgagaeapp.data.models.GetApplicationRequest;
import com.mymortgagaeapp.data.models.GetApplicationResponse;
import com.mymortgagaeapp.data.models.MortgageApplication;

/**
 * @author Swapnil Dangore
 */
@Endpoint
public class MyMortgageAppSoapService {
	
	@Autowired
	Set<MortgageApplication> applicationList;

	@PayloadRoot(namespace = "http://mymortgageapp.com/mortgageApplications", localPart = "GetAllApplicationsRequest")
	@ResponsePayload
	public GetAllApplicationsResponse getAllApplications(@RequestPayload GetAllApplicationsRequest request) {
		GetAllApplicationsResponse response = new GetAllApplicationsResponse();
		response.getMortgageApplication().addAll(applicationList);
		System.out.println("getAllApplications SOAP ### "+response);
		return response;
	}
	
	@PayloadRoot(namespace = "http://mymortgageapp.com/mortgageApplications", localPart = "CreateOrUpdateApplicationRequest")
	@ResponsePayload
	public CreateOrUpdateApplicationResponse processCourseDetailsRequest(@RequestPayload CreateOrUpdateApplicationRequest request) {
		CreateOrUpdateApplicationResponse response = new CreateOrUpdateApplicationResponse();
		MortgageApplication reqApp = request.getMortgageApplication();
		System.out.println("reqApp ###  "+reqApp);
		applicationList.forEach(e->{System.out.println("Is == >> "+(e==reqApp));
		System.out.println("Is Eq >> "+(e.equals(reqApp)));});
		System.out.println("applicationList before ###  "+applicationList);
		Optional<MortgageApplication> optionaltemp = applicationList.stream().filter(appElement->reqApp.getMortgageId().equals(appElement.getMortgageId())).findFirst();
		if(optionaltemp.isPresent()) {
			
			MortgageApplication temp = optionaltemp.get();
			temp.setVersion(reqApp.getVersion());
			temp.setOfferId(reqApp.getOfferId());
			temp.setProductId(reqApp.getProductId());
			temp.setCreatedDate(reqApp.getCreatedDate());
			temp.setOfferDate(reqApp.getOfferDate());
			temp.setOfferExpired(reqApp.isOfferExpired());
			System.out.println("App exists ### "+temp);
		}else {
			System.out.println("App doesn't exists *****"+applicationList.contains(reqApp));
			boolean isAdded = applicationList.add(reqApp);
			System.out.println("isAdded *****"+isAdded);
		}
		System.out.println("applicationList after ###  "+applicationList);
		response.setMortgageApplication(reqApp);
		return response;
	}

	@PayloadRoot(namespace = "http://mymortgageapp.com/mortgageApplications", localPart = "GetApplicationRequest")
	@ResponsePayload
	public GetApplicationResponse getApplication(@RequestPayload GetApplicationRequest request) {
		Optional<MortgageApplication> optionaltemp = applicationList.stream()
				.filter(appElement->request.getMortgageId().equals(appElement.getMortgageId()))
				.findFirst();
		GetApplicationResponse response = new GetApplicationResponse();
		if(optionaltemp.isPresent()) {			
			response.setMortgageApplication(optionaltemp.get()); 
		}else {
			response.setMortgageApplication(null);
		}
		return response;
	}
}
