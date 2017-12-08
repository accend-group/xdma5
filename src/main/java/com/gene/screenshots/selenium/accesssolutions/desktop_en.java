package com.gene.screenshots.selenium.accesssolutions;

import com.gene.screenshots.selenium.accesssolutions.en.*;
import com.gene.screenshots.utils.Log;
import com.gene.screenshots.utils.Screenshots;
import org.openqa.selenium.WebDriver;


public class desktop_en {

	public static void main(String[] args, WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Log logs[] = new Log[24];
		for(int i = 0; i < logs.length; ++i)
		    logs[i] = new Log();
		//count not yet updated
											// |# of screenshot	
        			// | desktop | mobile |
//			---> EN <---

		patient.main(args, driver);			// |	12 	 |	 13   |
		actemra.main(args, driver);			// |	42	 |	 35	  |
		alecensa.main(args, driver);		// |	37	 |   32	  |
		avastin.main(args, driver);			// |	41	 |	 36	  |
		cotellic.main(args, driver);		// |	37	 |	 32   |
		erivedge.main(args, driver);		// |	37	 |	 39	  |
		esbriet.main(args, driver); 		// |	37	 |	 41   |
		gazyva.main(args, driver); 			// |	37	 |	 39	  |
		hemlibra.main(args, driver); 		// |	35	 |	 38   |
		herceptin.main(args, driver);		// |	37	 |	 39   |
		kadcyla.main(args, driver); 		// |	36	 |	 38   |
		lucentis.main(args, driver); 		// |	40	 |	 42	  |
		ocrevus.main(args, driver); 		// |	36	 |	 32	  |
		pegasys.main(args, driver); 		// |	28 	 |	 32	  |
		perjeta.main(args, driver); 		// |	36	 | 	 38	  |
		pulmozyme.main(args, driver); 		// |	38	 |	 43	  |
		rituxan_ra.main(args, driver); 		// |	36	 |	 38	  |
		rituxan_gpampa.main(args, driver); 	// |	37	 |	 39	  |
		rituxan_nhl_cll.main(args, driver); // |	37	 |	 39	  |
		rituxanhycela.main(args, driver);	// | 	38	 |	 40	  |
		tarceva.main(args, driver); 		// |	38	 |	 40	  |
		tecentriq.main(args, driver); 		// |	37	 |	 39	  |
		venclexta.main(args, driver); 		// |	37	 |	 37	  |
		xolair.main(args, driver); 			// |	41	 |	 41	  |
		zelboraf.main(args, driver);    	// |	39	 |	 39	  |
									// total:  | 		 | 		  |
		
	}	
}
