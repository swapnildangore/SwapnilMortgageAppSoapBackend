/**
 * 
 */
package com.mymortgagaeapp.data.config;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

import com.mymortgagaeapp.data.models.MortgageApplication;

/**
 * @author Swapnil Dangore
 */
public class MortgageAppComparator implements Comparator<MortgageApplication> {

	@Override
	public int compare(MortgageApplication app1, MortgageApplication app2) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		
		Date app1Date = null;
		Date app2Date = null;
		try {
			app1Date = dateFormat.parse(app1.getCreatedDate());
			app2Date = dateFormat.parse(app2.getCreatedDate());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return app1Date.compareTo(app2Date);
	}

}
